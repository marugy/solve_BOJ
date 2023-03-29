package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465_스티커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N + 1];
			int[][] dp = new int[2][N + 1];

			for (int row = 0; row < 2; row++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 1; i <= N; i++)
					arr[row][i] = Integer.parseInt(st.nextToken());
			}
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			for (int a = 2; a <= N; a++) {
				dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
				dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
			}
			System.out.println(Math.max(dp[0][N], dp[1][N]));
		}
	}
}
