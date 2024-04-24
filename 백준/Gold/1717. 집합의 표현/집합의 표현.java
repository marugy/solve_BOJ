import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[]parent;
	
	static void union(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		
		if(aParent!=bParent) {
			if(aParent<bParent)
				parent[bParent]=aParent;
			else
				parent[aParent]=bParent;				
		}
	}
	
	static int findParent(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a]=findParent(parent[a]);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1;i<=n; i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check==0) {
				union(a,b);
			}else {
				int aPrent = findParent(a);
				int bPrent = findParent(b);
				if(aPrent==bPrent)
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		System.out.println(sb.toString());
		
	}
}
