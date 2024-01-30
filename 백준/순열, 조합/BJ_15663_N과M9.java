package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15663_N과M9 {
	static int n;
	static int m;
	static int []arr;
	static int []num;
	static boolean []visited;	
	static StringBuilder sb = new StringBuilder();
	
	static void print(int count) {
		if(count==m) {
			for(int i=0;i<m;i++)
				sb.append(num[i]+" ");
			sb.append("\n");
			return;
		}
		int last = -1;
		for (int i=0; i<n; i++) {
			if(!visited[i] && arr[i]!=last) {
				num[count]=arr[i];
				last = num[count];
				visited[i]=true;
				print(count+1);
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		num = new int[m];
		visited = new boolean[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);		
		
		print(0);
		System.out.println(sb.toString());
	}
}
