import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R, C;
	static char map[][];
	static int minTime;
	static boolean [][]visited;
	static boolean [][]waterVisited;
	static Queue<Pos> gosumList = new ArrayDeque<>();
	static Queue<Pos> waterList = new ArrayDeque<>();
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Pos {
		int x;
		int y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void run() {
		minTime = 0;
		while(!gosumList.isEmpty()) {
			minTime++;
			//고슴도치 움직이기
			if(moveGosum())//움직였을때만 물 퍼트리기
				spreadWater();
			//물 퍼트리기
		}
	}

	static boolean moveGosum() {
		// 물 번지기
		int size = gosumList.size();
		for (int w = 0; w < size; w++) {
			Pos gosum = gosumList.poll();
			//사방 탐색
			for (int d = 0; d < 4; d++) {
				int xx = gosum.x + dir[d][0];
				int yy = gosum.y + dir[d][1];
				//범위 안이고 방문 안한곳이고 돌이 아닐때
				if (0 <= xx && xx < R && 0 <= yy && yy < C && !visited[xx][yy] && map[xx][yy]!='X') {//범위 이내
					if(map[xx][yy]=='.') {//빈땅이고
						if(!willWater(xx,yy)) { //잠길 예정이 아니라면
							visited[xx][yy]=true;
							gosumList.add(new Pos(xx,yy));
						}
					}else if(map[xx][yy]=='D') {//도착이면 비우고 끝내기
						gosumList.clear();
						return false;
					}
				}
			}
		}
		if(gosumList.size()==0)
			minTime=-1;
		return true;
	}
	//물이 잠길 예정인 자리인지 확인
	static boolean willWater(int xx, int yy) {
		for (int dd = 0; dd < 4; dd++) { //사방에 물이 있는지 확인
			int xxx = xx + dir[dd][0];
			int yyy = yy + dir[dd][1];
			if (0 <= xxx && xxx < R && 0 <= yyy && yyy < C) {//범위 이내
				if(waterVisited[xxx][yyy]) {
					return true;
				}
			}
		}
		return false;
	}
	
	static void spreadWater() {
		// 물 번지기
		int size = waterList.size();
		for (int w = 0; w < size; w++) {
			Pos water = waterList.poll();
			for (int d = 0; d < 4; d++) {
				int xx = water.x + dir[d][0];
				int yy = water.y + dir[d][1];
				if (0 <= xx && xx < R && 0 <= yy && yy < C && !waterVisited[xx][yy]&& map[xx][yy] == '.') {
					waterVisited[xx][yy]=true;
					waterList.add(new Pos(xx, yy));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// map정보 입력 받기
		map = new char[R][C];
		visited = new boolean[R][C];
		waterVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			char[] ch = st.nextToken().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = ch[j];
				if (map[i][j] == 'S') {
					visited[i][j]=true;
					gosumList.add(new Pos(i, j));
				} else if (map[i][j] == '*') {
					waterVisited[i][j]=true;
					waterList.add(new Pos(i, j));
				}
			}
		}
		run();
		if(minTime==-1)
			System.out.println("KAKTUS");
		else
			System.out.println(minTime);
	}
}
