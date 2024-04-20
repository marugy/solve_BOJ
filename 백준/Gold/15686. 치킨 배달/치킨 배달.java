import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int[][]map;
	static ArrayList<Pos> home = new ArrayList<>();
	static ArrayList<Pos> chicken = new ArrayList<>();
	static ArrayList<Pos> choice = new ArrayList<>();
	
	static int minDis = Integer.MAX_VALUE;
	
	static class Pos{
		int x;
		int y;
		Pos (int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void findMin(int idx, int cnt) {
		if(cnt==M) {
			int totalDis = 0;
			
			for(int i=0; i<home.size(); i++) {
				Pos house = home.get(i);
				int dis = Integer.MAX_VALUE;
				for(int j=0; j<choice.size(); j++) {
					Pos cho = choice.get(j);
					if(dis > Math.abs(house.x - cho.x) + Math.abs(house.y - cho.y))
						dis = Math.abs(house.x - cho.x) + Math.abs(house.y - cho.y);
				}
				totalDis+=dis;
			}
			if(minDis > totalDis) minDis = totalDis;
			return;
		}
		
		for(int i=idx; i< chicken.size(); i++) {
				choice.add(chicken.get(i));
				findMin(i+1, cnt+1);
				choice.remove(chicken.get(i));
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st  = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				int info = Integer.parseInt(st.nextToken());
				
				if(info == 1) home.add(new Pos(i,j));
				else if(info == 2) chicken.add(new Pos(i,j));

				map[i][j] = info;
			}
		}
		findMin(0, 0);
		System.out.println(minDis);
	}
	
}
