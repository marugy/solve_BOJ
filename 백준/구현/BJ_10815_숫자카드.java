package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		boolean []num = new boolean[20000001];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++) {
			num[Integer.parseInt(st.nextToken())+10000000]=true;
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0 ;i<M;i++) {
			if(num[Integer.parseInt(st.nextToken())+10000000]) {
				sb.append("1 ");
			}else
				sb.append("0 ");
		}
		System.out.println(sb);
	}
}
