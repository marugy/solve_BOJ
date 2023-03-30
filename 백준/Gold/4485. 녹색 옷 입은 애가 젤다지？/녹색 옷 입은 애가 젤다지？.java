import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int[][] pay;
	static boolean[][] visited;
	static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

	static class Pos {
		int x;
		int y;
		int w;
		Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}

	private static void play() {
		Deque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, map[0][0]));
		while (!q.isEmpty()) {
			Pos pos = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = pos.x + dir[i][0];
				int yy = pos.y + dir[i][1];
				if(0<=xx && xx<N && 0<= yy && yy<N) {
					if(pos.w + map[xx][yy] < pay[xx][yy]) {
						pay[xx][yy] = pos.w + map[xx][yy];
						q.add(new Pos(xx,yy,pay[xx][yy]));
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int t = 1;
		while (N!=0) {
			map = new int[N][N];
			pay = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					pay[i][j] = Integer.MAX_VALUE;
				}
			}
			pay[0][0]=map[0][0];
			visited[0][0]=true;
			play();
			sb.append("Problem " + t + ": " + pay[N - 1][N - 1] + "\n");
			t++;
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb.toString());
	}
	
}
