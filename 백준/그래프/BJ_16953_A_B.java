package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_16953_A_B {

	static int count(long a, long b) {
		ArrayList<Long> q = new ArrayList<>();
		q.add(a);
		int cnt =1;
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while(--size>=0) {
				Long num = q.remove(0);
				if(num*10+1<b)
					q.add(num*10+1);
				else if(num*10+1==b) {
					System.out.println(num);
					return cnt;
				}
				if(num*2<b)
					q.add(2*num);
				else if(num*2==b) {
					System.out.println(num);
					return cnt;
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		System.out.println(count(A, B));
	}
}
