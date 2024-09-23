import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char[][]map;
	static boolean[][]visited;
	static boolean[][]burned;
	static Queue<Pos> jihun = new LinkedList<>();
	static Queue<Pos> fire = new LinkedList<>();
	static int minTime = Integer.MAX_VALUE;
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
		while(!jihun.isEmpty()) {
			
			int size = jihun.size();
			while(--size>=0) {
				Pos j = jihun.poll();
				if(0==j.x || j.x==R-1 || 0==j.y || j.y==C-1) {
					minTime=time;
					return;
				}
				visited[j.x][j.y]=true;
				
				for(int d=0; d<4; d++) {
					int dx = j.x + dir[d][0];
					int dy = j.y + dir[d][1];
					
					if(0<=dx && dx<R && 0<=dy && dy<C && !visited[dx][dy]) {
						if(map[dx][dy]=='.' || (map[dx][dy]!='#' && map[dx][dy]>time)) {
							visited[dx][dy]=true;
							jihun.add(new Pos(dx,dy));
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
				map[f.x][f.y]=(char) time;
				
				for(int d=0; d<4; d++) {
					int dx = f.x + dir[d][0];
					int dy = f.y + dir[d][1];
					
					if(0<=dx && dx<R && 0<=dy && dy<C && map[dx][dy]=='.' && !burned[dx][dy]) {
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
		StringTokenizer st= new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		burned = new boolean[R][C];
		
		for(int i=0;i<R; i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j]=='J') {
					jihun.add(new Pos(i,j));
					map[i][j]='.';
				}else if(map[i][j]=='F') {
					fire.add(new Pos(i,j));
				}
			}
		}
		
		findAnswer();
		
		if(minTime==Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		}else System.out.println(minTime);
	}

}
