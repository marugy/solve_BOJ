package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074_Z {

	static int N;
	static int r;
	static int c;
	
	public static int visiteZ(int r, int c, int size) {
		int sum = 0;
		int half = size/2;
		if (size == 2) { //사이즈가 2라면
			if (r == 0) //첫번째 행일때 열 반환
				return c;
			else//두번째 행이면 사이즈가 2이므로 2더해서 반환
				return  2 + c;
		}
		else if (r < (half) && c < half) { //2사분면일 때
			sum = visiteZ(r, c, half);
		}
		else if (r < half && c >= half) { // 1사분면일 떄
			sum = half*half+ visiteZ(r, c % half, half);
		}
		else if (r >= half && c < half) {//3사분면일 때
			sum = 2*half*half + visiteZ(r% half, c, half);
		}
		else if (r >= half && c >= half) {//4사분면일 때
			sum = 3*half*half + visiteZ(r% half, c % half, half);
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException{

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	//값 입력 받기
	N = Integer.parseInt(st.nextToken());
	r = Integer.parseInt(st.nextToken());
	c = Integer.parseInt(st.nextToken());
	//결과 출력
	System.out.println(visiteZ(r,c,(int)Math.pow(2, N)));
	}
}
