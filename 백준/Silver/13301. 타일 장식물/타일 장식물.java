import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long [][]dp = new long[N+1][2];
		//0 가로, 1 세로
		dp[1][0] =1;
		dp[1][1] =1;
		for(int i=2; i<=N;i++) {
			if(i%2==0) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][0] + dp[i-1][1];
			}else {
				dp[i][0] = dp[i-1][0] + dp[i-1][1];
				dp[i][1] = dp[i-1][1];
			}
		}
		System.out.println(2*dp[N][0]+2*dp[N][1]);
	}
}
