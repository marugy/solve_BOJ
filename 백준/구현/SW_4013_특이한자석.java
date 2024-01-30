package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_4013_특이한자석 {

	static int[][] gear;
	static boolean[]visited;
	static int score;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			score = 0;

			int K = Integer.parseInt(br.readLine());
			gear = new int[4][8];

			for (int i = 0; i < 4; i++) { // 톱니바퀴 값 입력하기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					gear[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int kk = 0; kk < K; kk++) {// 회전 정보 입력받기
				st = new StringTokenizer(br.readLine());
				// 돌릴 기어 번호, 방향
				int gearNum = Integer.parseInt(st.nextToken()) - 1;
				int dir = Integer.parseInt(st.nextToken());
				// 돌려버리기
				visited = new boolean[4];
				turnGear(gearNum, dir);
			}
			getScore();
			sb.append(score).append("\n");
		}
		System.out.println(sb.toString());
	}

	// 점수 얻기
	public static void getScore() {
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1) {
				score += Math.pow(2, i);
			}
		}
	}

	public static void turnGear(int gearNum, int dir) {
		visited[gearNum]=true;
		if (gearNum == 0) {// gearNum = 0
			if(gear[gearNum][2] != gear[gearNum + 1][6]&&!visited[1]) { // 1,2번 연결되어 있다면
				turnGear(gearNum+1,dir*-1);
			}
		}else if (gearNum == 1) {// gearNum = 1
			if(gear[gearNum-1][2] != gear[gearNum][6]&&!visited[0]) { // 1, 2번 연결되어 있다면
				turnGear(gearNum-1,dir*-1);
			}
			if(gear[gearNum][2] != gear[gearNum+1][6]&&!visited[2]) { // 2, 3번 연결되어 있다면
				turnGear(gearNum+1,dir*-1);
			}
		}else if (gearNum == 2) {// gearNum = 2
			if(gear[gearNum-1][2] != gear[gearNum][6]&&!visited[1]) { // 1, 2번 연결되어 있다면
				turnGear(gearNum-1,dir*-1);
			}
			if(gear[gearNum][2] != gear[gearNum+1][6]&&!visited[3]) { // 2, 3번 연결되어 있다면
				turnGear(gearNum+1,dir*-1);
			}
		}else if (gearNum == 3) {// gearNum = 3
			if(gear[gearNum-1][2] != gear[gearNum][6]&&!visited[2]) { // 2, 3번 연결되어 있다면
				turnGear(gearNum-1,dir*-1);
			}
		}
		move(gearNum, dir);
	}

	public static void move(int gearNum, int lr) {
		if (lr == -1) { // 왼쪽으로 돌리기
			int tmp = gear[gearNum][0];
			for (int i = 1; i < 8; i++) {
				gear[gearNum][i - 1] = gear[gearNum][i];
			}
			gear[gearNum][7] = tmp;
		} else { // 오른쪽으로 돌리기
			int tmp = gear[gearNum][7];
			for (int i = 7; i > 0; i--) {
				gear[gearNum][i] = gear[gearNum][i-1];
			}
			gear[gearNum][0] = tmp;
		}
	}
}
