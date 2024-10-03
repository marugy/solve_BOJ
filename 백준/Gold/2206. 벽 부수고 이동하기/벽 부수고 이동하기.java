import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static char[][]map;
	static int[][][]dis;
	static int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
	
	static int findAnswer() {
		
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0,0,0));
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			while(--size>=0) {
				
				Info now = que.poll();
				if(now.x==N-1 && now.y==M-1) {
					return dis[now.x][now.y][now.broken];
				}
				
				for(int d=0; d<4; d++) {
					int dx = now.x+dir[d][0];
					int dy = now.y+dir[d][1];
					int nextDis = dis[now.x][now.y][now.broken]+1;
					if(0<=dx && dx<N && 0<=dy && dy<M) {
						if(map[dx][dy]=='0' && dis[dx][dy][now.broken]==0) { //그냥 길
							dis[dx][dy][now.broken]=nextDis;
							que.add(new Info(dx, dy, now.broken));
						}
						if(now.broken==0 && map[dx][dy]=='1' && dis[dx][dy][1]==0) {
							dis[dx][dy][1]= nextDis;
							que.add(new Info(dx,dy,1));
						}
					}
				}
			}
		}
		return -1;
	}
	
	
	static class Info{
		int broken;
		int x;
		int y;
		Info(int x, int y, int broken){
			this.broken=broken;
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		dis = new int[N][M][2];
		dis[0][0][0]=1;
		dis[0][0][1]=1;
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int minDis = findAnswer();
		System.out.println(minDis);
	}

}
