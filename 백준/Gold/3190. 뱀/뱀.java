import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int N, K, L;
	static int [][]map;
	static int time = 0;
	static ArrayDeque<Direction> que = new ArrayDeque<>();
	static int[][]dir = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	
	static class Direction{
		int time;
		String dir;
		Direction(int time, String dir) {
			this.time=time;
			this.dir=dir;
		}
	}
	
	static void play() {
		
		int headX=0, headY=0;
		int tailX=0, tailY = 0;
		map[0][0]=2;
		
		while(true) {
			//시간 증가
			time++;
		
			int hd = map[headX][headY];
			int hx = headX + dir[hd-1][0];
			int hy = headY + dir[hd-1][1];
			
			// 머리가 몸통이나 벽에 부딪히면 종료
			if(!(0<=hx && hx<N && 0<=hy && hy<N) || (1<=map[hx][hy] && map[hx][hy]<=4)) break;
			
			//이동한 칸에 사과가 없는 경우
			if(map[hx][hy]==0) {
				int td = map[tailX][tailY];
				map[tailX][tailY]=0;
				tailX = tailX + dir[td-1][0];
				tailY = tailY + dir[td-1][1];
			}
			
			headX=hx;
			headY=hy;
			map[headX][headY]=hd;
			
			Direction turn = que.peek();
			if(turn!=null && turn.time==time) {
				que.poll();
				if(turn.dir.equals("L")) {
					map[headX][headY]--;
					if(map[headX][headY]==0) map[headX][headY]=4;
				}else {
					map[headX][headY]++;
					if(map[headX][headY]==5) map[headX][headY]=1;
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y]=-1;
		}
		
		L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			que.add(new Direction(x,c));
		}
		play();
		System.out.println(time);
	}
}
