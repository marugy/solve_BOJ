import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m,cnt = 0;
	static int maxArea = 0;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	static int [][]map = null;
	static boolean [][]visited = null;
	
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static void BFS(int x, int y) {
		
		Queue<Pos> que = new LinkedList<>();
		visited[x][y]=true;
		que.add(new Pos(x,y));
		int area =0;
		
		while(!que.isEmpty()) {
		
			int size = que.size();
			while(--size>=0) {
				Pos now = que.poll();
				area++;
				for(int d=0;d<4;d++) {
					int dx = now.x+dir[d][0];
					int dy = now.y+dir[d][1];
					
					if(!(0<=dx && dx<n && 0<=dy && dy<m) || map[dx][dy]==0 || visited[dx][dy]) continue;
					visited[dx][dy]=true;
					que.add(new Pos(dx,dy));
				}
			}
			
		}
		if(area > maxArea) maxArea = area;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					cnt++;
					BFS(i,j);
				}
			}
		}
		System.out.print(cnt+"\n"+maxArea);
	}

}
