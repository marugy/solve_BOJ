import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long number[], result,start, end, mul;
	
	//자릿수를 더하는 함수
	//끝자리가 9,0이 아닌 수들에 대해 연산 수행
	static void cal(long a) {
		//끝자리를 확인하며
		for (long i = a; i > 0; i /= 10) {
			String s = Long.toString(i);
			int t = s.charAt(s.length()-1)-'0';
			//자릿수를 의미하는 mul씩 더해주기
			number[t]+=mul;				
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			start = Long.parseLong(st.nextToken());
			end = Long.parseLong(st.nextToken());
			// 초기화
			number = new long[10];
			result = 0;
			mul = 1;
			
			if(start==0) start=1;
			
			while (start <= end) {
				//끝자리가 0이 될때까지 연산하고 더해주기
				while(start%10!=0 && start<=end) {
					cal(start);
					start++;
				}
				//커지면 중단
				if(start>end) break;
				//끝자리가 9가 될때까지 연산하고 뺴주고
				while(end%10!=9 && start<=end) {
					cal(end);
					end--;
				}
				//1의 자리가 0~9까지 나오는 횟수
				long diff = end/10 - start/10 +1;
				//각 자릿수 횟수만큼 증가시키기
				for(int i=0;i<10;i++)
					number[i]+=diff*mul;
				
				mul*=10;//1의자리 10~19 일때와 100~190일때의 갯수 차이는 10배기 때문 자릿수 유지
				start/=10;//나누기
				end/=10;//나누기
			}		
			//결과 더하기
			for (int i = 1; i < 10; i++)
				result += (i * number[i]);
			sb.append("#" + tc + " " + result+"\n");
		}
		System.out.println(sb.toString());
	}
}
