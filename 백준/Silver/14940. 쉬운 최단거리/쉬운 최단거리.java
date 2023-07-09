import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n,m, startX, startY;
	static int[][]map = null;
	static int[][]dist = null;
	static int[][]dir= {{1,0},{-1,0},{0,1},{0,-1}};
	static boolean[][] visited = null;
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void findDist() {
		Queue<Pos> q = new ArrayDeque<Pos>();
		q.add(new Pos(startX,startY));
		int dis = 1;
		visited[startX][startY]=true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size>=0) {
				Pos p = q.poll();
				
				for(int i=0;i<4;i++) {
					int xx = p.x+dir[i][0];
					int yy = p.y+dir[i][1];
					
					if(!(0<=xx&& xx<n && 0<=yy && yy<m) || visited[xx][yy] || map[xx][yy]==0) continue; //범위X, 이미방문, 이동X 통과
					dist[xx][yy]=dis;
					visited[xx][yy]=true;
					q.add(new Pos(xx,yy));
				}
			}
			dis++;
		}
		
	}
	
	static void checkDisable() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0 && !visited[i][j]) {
					dist[i][j]=-1;
				}
			}
		}
	}
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					startX=i; startY=j;
				}
			}
		}
		findDist();
		
		checkDisable();
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				sb.append(dist[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
