import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int w, h;
	static char[][]map;
	static boolean[][]visited;
	static boolean[][]burned;
	static int [][]dist;
	static Queue<Pos> sg = new LinkedList<>();
	static Queue<Pos> fire = new LinkedList<>();
	static int minTime;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	static void findAnswer() {
		
		makeFire();
		
		int time = 1;
		while(!sg.isEmpty()) {
			
			int size = sg.size();
			while(--size>=0) {
				Pos now = sg.poll();
				if(0==now.x || now.x==h-1 || 0==now.y || now.y==w-1) {
					minTime=time;
					return;
				}
				
				for(int d=0; d<4; d++) {
					int dx = now.x + dir[d][0];
					int dy = now.y + dir[d][1];
					
					if(0<=dx && dx<h && 0<=dy && dy<w && map[dx][dy]=='.' && !visited[dx][dy]) {
						if(!burned[dx][dy] || dist[dx][dy]>time) {
							visited[dx][dy]=true;
							sg.add(new Pos(dx,dy));
						}
					}
				}
			}
			time++;
		}
	}
	
	static void makeFire() {
		
		int time = 0;
		
		while(!fire.isEmpty()) {
			
			int size = fire.size();
			
			while(--size>=0) {
				
				Pos f = fire.poll();
				dist[f.x][f.y]=time;
				
				for(int d=0; d<4; d++) {
					int dx = f.x + dir[d][0];
					int dy = f.y + dir[d][1];
					
					if(0<=dx && dx<h && 0<=dy && dy<w && map[dx][dy]!='#' && !burned[dx][dy]) {
						burned[dx][dy]=true;
						fire.add(new Pos(dx,dy));
					}
				}
			}
			time++;
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st= null;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc< T; tc++) {
			minTime = Integer.MAX_VALUE;
			sg.clear();
			fire.clear();
			
			st= new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			dist = new int[h][w];
			visited = new boolean[h][w];
			burned = new boolean[h][w];
			
			for(int i=0;i<h; i++) {
				map[i]=br.readLine().toCharArray();
				
				for(int j=0;j<w;j++) {
					if(map[i][j]=='@') {
						sg.add(new Pos(i,j));
						visited[i][j]=true;
					}else if(map[i][j]=='*') {
						burned[i][j]=true;
						fire.add(new Pos(i,j));
					}
				}
			}
			
			findAnswer();
			
			if(minTime==Integer.MAX_VALUE) {
				sb.append("IMPOSSIBLE\n");
			}else sb.append(minTime+"\n");
		}
		System.out.print(sb.toString());
	}

}
