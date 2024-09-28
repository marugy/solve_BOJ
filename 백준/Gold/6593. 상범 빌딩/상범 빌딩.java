import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dir = {{0,-1,0},{0,0,-1},{0,1,0},{0,0,1},{-1,0,0},{1,0,0}};
	static int L,R,C; 
	static char [][][]building;
	static boolean [][][]visited;
	static Queue<Pos> que = new LinkedList<>();
	
	
	static void run() {
		
		int time = 0;
		while(!que.isEmpty()) {
			
			int size = que.size();
			while(--size>=0) {
				
				Pos tmp = que.poll();
				if(building[tmp.l][tmp.r][tmp.c]=='E') {
					System.out.println("Escaped in "+time+" minute(s).");
					return;
				}
				
				for(int d=0; d<6; d++) {
					int dl = tmp.l +dir[d][0];
					int dr = tmp.r +dir[d][1];
					int dc = tmp.c +dir[d][2];
					
					if(0<=dl && dl<L && 0<=dr && dr<R && 0<=dc && dc<C && !visited[dl][dr][dc] && building[dl][dr][dc]!='#'){
						visited[dl][dr][dc]=true;
						que.add(new Pos(dl,dr,dc));
					}
				}
			}
			time++;
		}
		System.out.println("Trapped!");
	}
	
	static class Pos{
		int l;
		int r;
		int c;
		Pos(int l, int r, int c){
			this.l=l;
			this.r=r;
			this.c=c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
	
			if(L==0 && R==0 && C==0) return;
			
			building = new char[L][R][C];
			visited = new boolean[L][R][C];
			que.clear();
			
			for(int l=0; l<L;l++) {
				for(int r=0;r<R;r++) {
					building[l][r]=br.readLine().toCharArray();
					for(int c=0; c<C; c++) {
						if(building[l][r][c]=='S') {
							que.add(new Pos(l,r,c));
							visited[l][r][c]=true;
						}
					}
				}
				br.readLine();
			}
			run();
		}
	}

}
