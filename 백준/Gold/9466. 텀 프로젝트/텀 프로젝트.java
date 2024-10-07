import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] arr;
	static boolean[] visited;
	static boolean[] done;
	static int cnt;
	
	public static void findAnswer(int idx) {
		if(visited[idx]) {
			done[idx]=true;
			cnt++;
		}else {
			visited[idx]=true;
		}
		
		if(!done[arr[idx]]) findAnswer(arr[idx]);
		
		visited[idx]=false;
		done[idx]=true;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n+1];
			visited = new boolean[n+1];
			done = new boolean[n+1];
			cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine());			
			for(int i=0;i<n;i++) arr[i+1] = Integer.parseInt(st.nextToken());
			for(int i=1;i<=n;i++) {
				if(!done[i]) findAnswer(i);
			}
			sb.append(n-cnt+"\n");
		}
		System.out.println(sb.toString());
	}
}	