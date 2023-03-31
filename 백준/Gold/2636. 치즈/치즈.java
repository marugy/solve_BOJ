import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0;
	static int N;
	static int M;
	static int[][] arr;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void melting() {
		boolean[][] visited = new boolean[N][M];

		Queue<Pos> q = new ArrayDeque<>();
		visited[0][0] = true;
		q.add(new Pos(0, 0));

		while (!q.isEmpty()) {
			int size = q.size();
			while (--size >= 0) {
				Pos now = q.poll();
				for (int i = 0; i < 4; i++) {
					int xx = now.x + dir[i][0];
					int yy = now.y + dir[i][1];

					if (0 <= xx && xx < N && 0 <= yy && yy < M) { // 범위 안에 있는 0의 경우
						if (!visited[xx][yy] && arr[xx][yy] == 0) {// 방문 안한 0
							visited[xx][yy] = true;// 방문 처리하고
							q.add(new Pos(xx, yy));

							for (int d = 0; d < 4; d++) {// 사방 탐색
								int xxx = xx + dir[d][0];
								int yyy = yy + dir[d][1];
								if (0 <= xxx && xxx < N && 0 <= yyy && yyy < M)
									if (!visited[xxx][yyy]&&arr[xxx][yyy] == 1) {
										visited[xxx][yyy] = true;
										cnt--;
										arr[xxx][yyy] = 0;
									}
							}
						}

					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cnt++;
			}
		}
		int round = 0;
		int lastCnt = 0;

		while (cnt > 0) {
			int last = cnt;
			round++;
			melting();
			if (cnt == 0) {
				lastCnt = last;
			}

		}
		System.out.println(round);
		System.out.println(lastCnt);
	}
}
