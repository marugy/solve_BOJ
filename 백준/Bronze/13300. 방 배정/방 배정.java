import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 학생 수
		int k = Integer.parseInt(st.nextToken()); // 한 방 최대 인원
		int answer = 0;
		
		int [][]info = new int[6][2];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			info[grade-1][gender]++;
		}
		
		for(int i=0;i<6;i++) {
			for(int j=0;j<2;j++)
			if(info[i][j]%k==0)answer+=info[i][j]/k;
			else answer += info[i][j]/k+1;
		}
		System.out.println(answer);
	}

}
