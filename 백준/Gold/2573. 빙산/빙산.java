import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][]dir = {{-1,0},{1,0},{0,-1},{0,1}};
		int[][]map = new int[N][M];
		Queue<Pos> que = new LinkedList<>();
		
		for(int i=0;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) que.add(new Pos(i,j));
			}
		}
		
		int year = 0;
		while(!que.isEmpty()) {
			year++;
			int size = que.size();
			int [][]newMap = new int[N][M];
			while(--size>=0) {
				Pos now = que.poll();
				int count = 0;
				for(int d=0; d<4; d++) {
					int dx = now.x + dir[d][0];
					int dy = now.y + dir[d][1];
					if(!(0<=dx && dx<N && 0<=dy && dy<M)) continue;
					if(map[dx][dy]==0) count++;
				}
				int newVal = map[now.x][now.y]-count;
				if(newVal>0) {
					newMap[now.x][now.y]=newVal;
					que.add(new Pos(now.x, now.y));
				}
			}
			
			size = que.size();
			boolean[][]visited = new boolean[N][M];
			Pos now = que.peek();
			
			if(now ==null) {
				System.out.println(0);
				return;
			}
			
			visited[now.x][now.y]=true;
			Queue<Pos> landCheck = new LinkedList<>();
			landCheck.add(now);
			int cnt = 0;
			
			while(!landCheck.isEmpty()) {	
				int landSize = landCheck.size();	
				while(--landSize>=0) {
					Pos tmp = landCheck.poll();
					cnt++;
					for(int d=0; d<4; d++) {
						int dx = tmp.x + dir[d][0];
						int dy = tmp.y + dir[d][1];
						if(!(0<=dx && dx<N && 0<=dy && dy<M) || newMap[dx][dy]==0 || visited[dx][dy]) continue;
						visited[dx][dy]=true;
						landCheck.add(new Pos(dx, dy));
					}
				}
			}
			if(cnt!=que.size()) {
				System.out.println(year);
				return;
			}
			map=newMap;
		}
		System.out.println(0);
	}

}
