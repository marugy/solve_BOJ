import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static char[][]stars;
	
	static void makeStars(int r,int c,int N) {
		if(N==3) {
			stars[r][c]='*';
			stars[r+1][c-1]='*';
			stars[r+1][c+1]='*';
			for(int i=-2; i<=2; i++)
				stars[r+2][c+i]='*';
		}else {
			makeStars(r, c, N/2);
			makeStars(r+N/2, c-N/2, N/2);
			makeStars(r+N/2, c+N/2, N/2);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		stars = new char[N][2*N-1];
		
		stars = new char[N][N * 2 - 1]; // 꼭대기 별이 (0,N-1)에 찍힘
		for (int i = 0; i < N; i++) {
			Arrays.fill(stars[i], ' '); // 공백으로 채움
		}
		
		makeStars(0,N-1,N);
		for(int i=0;i<N;i++) {
			for(int j=0;j<stars[i].length;j++) {
				sb.append(stars[i][j]);					
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
