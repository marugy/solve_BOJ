import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//공장 수
		int N = Integer.parseInt(br.readLine());
		int []fac = new int[N+2];
		//공장 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			fac[i]=Integer.parseInt(st.nextToken());
		
		//갯수파악
		int sum=0;
		for(int i=0; i<N; i++){
			//가운데가 더 클때
	        if(fac[i+1]>fac[i+2]){
	        	//2개씩 최대로 뽑기 -> i+1, i+2 동일하게 만들기
	        	int a=Math.min(fac[i], fac[i+1]-fac[i+2]);
	            sum+=5*a;
	            fac[i]-=a; fac[i+1]-=a;
	            //3개씩 최대로 뽑기 위해i+1, i+2의 차와 fac[i]비교
	            int b=Math.min(fac[i], Math.min(fac[i+1], fac[i+2]));
	            sum+=7*b;
	            fac[i]-=b; fac[i+1]-=b; fac[i+2]-=b;
	            //남은 fac[i]처리
	            sum+=3*fac[i];
	        }
	        else{ //오른쪽이 크거나 같을 때
	        	//3개씩 최대로 뽑기
	            int a=Math.min(fac[i], fac[i+1]);
	            sum+=7*a;
	            fac[i]-=a; fac[i+1]-=a; fac[i+2]-=a;
	            //2개씩 최대 뽑기
	            int b=Math.min(fac[i], fac[i+1]);
	            sum+=5*b;
	            fac[i]-=b; fac[i+1]-=b;
	            //남은 fac[i]처리
	            sum+=3*fac[i];
	        }
	    }
		System.out.println(sum);
	}
}
