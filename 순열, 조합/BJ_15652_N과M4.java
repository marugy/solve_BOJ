package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_15652_N과M4 {
	
	static int n;
	static int m;
	static boolean []visited;
	static int []num;
	static StringBuilder sb = new StringBuilder();
	
	static void print(int start, int count) {
		if(count==m) {
			for(int i=0;i<m;i++)
				System.out.print(num[i]+" ");
			System.out.println();
			return;
		}
		for (int i=start; i<n; i++) {
			num[count]=i+1;
			print(i,count+1);
			visited[count]=true;
		}	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n];
		num = new int[m];
		
		print(0,0);
	}
}
