import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int low = Integer.MAX_VALUE;
	static int high = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int maxSafe = Integer.MIN_VALUE;

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void rainy(int rain, int x, int y) {
		visited[x][y] = true;
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(x,y));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int d = 0; d < 4; d++) {
				int xx = now.x + dir[d][0];
				int yy = now.y + dir[d][1];
				if (0 <= xx && xx < N && 0 <= yy && yy < N && !visited[xx][yy] && map[xx][yy] > rain) {
					visited[xx][yy]=true;
					q.add(new Pos(xx,yy));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (low > map[i][j])
					low = map[i][j];
				if (high < map[i][j])
					high = map[i][j];
			}
		}
		for (int rain = low-1; rain < high; rain++) {
			visited = new boolean[N][N];
			int safe =0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (rain < map[i][j] && !visited[i][j]) {
						safe++;
						rainy(rain, i, j);
					}
				}
			}
			if(maxSafe < safe)
				maxSafe = safe;
		}
		System.out.println(maxSafe);
	}
}
