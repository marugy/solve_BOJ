import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, X, map[][];
	static boolean[] visited;
	static int wayCnt;

	static class Pos {
		int num;
		int cnt;

		Pos(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static void makeWay() {
		for (int i = 0; i < N; i++) {
			// 행검사
			visited = new boolean[N];
			if (checkCol(i)) {
				wayCnt++;
			}
			// 열검사
			visited = new boolean[N];
			if (checkRow(i)) {
				wayCnt++;
			}
		}
	}

	// 행검사
	static boolean checkCol(int col) {
		// 행에 대한 열 검사
		for (int j = 0; j < N - 1; j++) {
			if (map[col][j] == map[col][j + 1])
				continue;// 같으면 통과
			if (map[col][j] < map[col][j + 1]) {// 왼쪽이 작을 때
				if (map[col][j] + 2 <= map[col][j + 1]) { // 2차이 이상 난다면 return false
					return false;
				} else {
					if (j - X + 1 >= 0) { // 경사로 갯수를 못채울수 있을때
						for (int k = j; k >= j - X + 1; k--) {
							if (visited[k]) {
								return false;// 이미 경사로를 쓴거면 중단
							} else {
								visited[k] = true;// 아니면 사용처리
							}
						}
					} else { // 갯수를 채울 수 없으면 false
						return false;
					}
				}

			} else {// 오른쪽이 작을 때
				if (map[col][j] >= map[col][j + 1] + 2) { // 2차이 이상 난다면 return false
					return false;
				} else {
					if (j + X < N) { // 경사로 갯수를 못채울수 있을때
						for (int k = j + 1; k <= j + X; k++) {
							if (visited[k]) {
								return false;// 이미 경사로를 쓴거면 중단
							} else {
								visited[k] = true;// 아니면 사용처리
							}
						}
					} else { // 갯수를 채울 수 없으면 false
						return false;
					}
				}
			}
		}
		return true;
	}

	// 열 검사
	static boolean checkRow(int row) {
		// 열에 대한 행 검사
		for (int j = 0; j < N - 1; j++) {
			if (map[j][row] == map[j + 1][row])
				continue;// 같으면 통과

			if (map[j][row] < map[j + 1][row]) {// 위가 작을 때
				if (map[j][row] + 2 <= map[j + 1][row]) { // 2차이 이상 난다면 return false
					return false;
				} else {
					if (j - X + 1 >= 0) { // 경사로 갯수를 못채울수 있을때
						for (int k = j; k >= j - X + 1; k--) {
							if (visited[k]) {
								return false;// 이미 경사로를 쓴거면 중단
							} else {
								visited[k] = true;// 아니면 사용처리
							}
						}
					} else { // 갯수를 채울 수 없으면 false
						return false;
					}
				}

			} else {// 아래가 작을 때
				if (map[j][row] >= map[j + 1][row] + 2) { // 2차이 이상 난다면 return false
					return false;
				} else {
					if (j + X < N) { // 경사로 갯수를 못채울수 있을때
						for (int k = j + 1; k <= j + X; k++) {
							if (visited[k]) {
								return false;// 이미 경사로를 쓴거면 중단
							} else {
								visited[k] = true;// 아니면 사용처리
							}
						}
					} else { // 갯수를 채울 수 없으면 false
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 맵 사이즈
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 맵 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wayCnt = 0;

		makeWay();

		System.out.println(wayCnt);
	}
}
