import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		// 테케 반복
		for (int tc = 1; tc <= T; tc++) {
			// 편의점 수
			int N = Integer.parseInt(br.readLine());
			
			int[][] info = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
			}

			int[][] map = new int[N + 2][N + 2]; //0은 거리 저장, 1은 편의점 들린 횟수 저장

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					int dis = Math.abs(info[i][0] - info[j][0]) + Math.abs(info[i][1] - info[j][1]);
					if(dis<=1000)
						dis=0;
					map[i][j] = dis;
					map[j][i] = dis;
				}
			}
			
			//i -> k -> j
			for (int k = 0; k < N + 2; k++) {//경유지
				for (int i = 0; i < N + 2; i++) {// 출발지
					if(i==k) continue;
					for (int j = 0; j < N + 2; j++) {// 도착지
						if(j==k || j==i) continue;
						map[i][j] = Math.min(map[i][k]+map[k][j],map[i][j]);
					}
				}
			}
			
			if(map[0][N+1]==0)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
