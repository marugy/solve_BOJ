import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc =1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int [][]map = new int[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i!=j && map[i][j]==0)
						map[i][j]=10000;
				}
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					if(i==k) continue;
					for(int j=0;j<N;j++) {
						if(j==k || j==i) continue;
						map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
					}
				}
			}
			int minSum = Integer.MAX_VALUE;
			for(int k=0;k<N;k++) {
				int sum = 0;
				for(int i=0;i<N;i++) {
					sum+=map[k][i];
				}
				if(minSum>sum)
					minSum = sum;
			}
			sb.append(minSum+"\n");
		}
		System.out.println(sb.toString());
	}
}
