import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int maxSafe = Integer.MIN_VALUE;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static void corona(int cnt) {
		// 기능 3개를 세우고 바이러스 확산 검사
		if (cnt == 3) {
			spreadVirus();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					corona(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	// 바이러스 퍼트리기
	static void spreadVirus() {
		int[][] spreadMap = new int[N][M];
		for(int i=0;i<N;i++)
			spreadMap[i] = map[i].clone();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (spreadMap[i][j] == 2) {
					Queue<int[]> q = new ArrayDeque<>();
					int[] a = { i, j };
					q.add(a);
					while (!q.isEmpty()) {
						int size = q.size();
						while (--size >= 0) {
							int[] now = q.poll();
							for (int d = 0; d < 4; d++) {
								int xx = now[0] + dir[d][0];
								int yy = now[1] + dir[d][1];

								if (0 <= xx && xx < N && 0 <= yy && yy < M) {
									if (spreadMap[xx][yy] == 0) {
										spreadMap[xx][yy] = 2;
										int[] b = { xx, yy };
										q.add(b);
									}
								}
							}
						}
					}
				}
			}
		}
		
		// 안전 구역 검사
		countSafeArea(spreadMap);
	}

	static void countSafeArea(int[][] spreadMap) {
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (spreadMap[i][j] == 0)
					cnt++;
			}
		}
		if (maxSafe < cnt) {
			maxSafe = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 사이즈 및 지도 선언
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		// 지도 값 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		corona(0);
		System.out.println(maxSafe);
	}
}
