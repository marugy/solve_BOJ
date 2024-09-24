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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=null;
		
		int T = Integer.parseInt(br.readLine());//테스트케이스
		for(int tc=0; tc<T; tc++) {
			Queue<Pos> night = new LinkedList<>();
			int L = Integer.parseInt(br.readLine());
			boolean[][]visited = new boolean[L][L];
			int[][]dir= {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
			
			st= new StringTokenizer(br.readLine());
			int nightX = Integer.parseInt(st.nextToken());
			int nightY = Integer.parseInt(st.nextToken());
			night.add(new Pos(nightX, nightY));
			
			st= new StringTokenizer(br.readLine());
			int targetX = Integer.parseInt(st.nextToken());
			int targetY = Integer.parseInt(st.nextToken());
		
			int time = -1;
			while(!night.isEmpty()) {
				int size = night.size();
				while(--size>=0) {
					Pos now = night.poll();
					if(now.x==targetX && now.y==targetY) {
						night.clear();
						break;
					}
					
					for(int d=0;d<8;d++) {
						int dx = now.x + dir[d][0];
						int dy = now.y + dir[d][1];
						
						if(!(0<=dx && dx<L && 0<=dy && dy<L)) continue;
						if(visited[dx][dy])continue;
						visited[dx][dy]=true;
						night.add(new Pos(dx, dy));
					}
					
				}
				time++;
			}
			sb.append(time+"\n");
		}
		System.out.println(sb.toString());
	}
}
