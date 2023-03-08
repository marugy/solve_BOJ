package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15657_N과M8 {
	static int n;
	static int m;
	static boolean []visited;
	static int []num;
	static int []arr;
	static StringBuilder sb = new StringBuilder();
	
	static void print(int start, int count) {
		if(count==m) {
			for(int i=0;i<m;i++)
				sb.append(num[i]+" ");
			sb.append("\n");
			return;
		}
		for (int i=start; i<n; i++) {
				num[count]=arr[i];
				visited[i]=true;
				print(i,count+1);
				visited[i]=false;
			}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		visited = new boolean[n];
		
		num = new int[m];
		
		print(0,0);
		System.out.println(sb.toString());
	}
}


