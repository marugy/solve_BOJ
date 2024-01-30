package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15666_N과M_12 {
	
	static int N;
	static int M;
	static int[]arr = null;
	static int[]answer = null;
	
	static void findAnswer(int start, int count) {
		if(count == M) {
			for(int i=0;i<M;i++)
				System.out.print(answer[i]+" ");
			System.out.println();
			return;
		}
		
		for(int i=start; i<N;i++) {
			if(i+1 < N && arr[i]==arr[i+1]) continue;
			answer[count]=arr[i];
			findAnswer(i,count+1);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		answer = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		findAnswer(0,0);
	}
}
