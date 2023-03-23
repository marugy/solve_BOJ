package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629_곱셈 {
	static long C;
	static long calMul(long A, long B) {
		if(B==1) {
			return A%C;
		}
		long cal = calMul(A,B/2);
		if(B%2==0) {
			return cal*cal%C ;
		}
		else {
			return (cal*cal%C)*A%C;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		System.out.println(calMul(A,B));
	}
}
