import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int K;
	static char[][] map;
	static boolean[][][] visited;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }};
	static int minDis = Integer.MAX_VALUE;
	static boolean pass;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수들 값 입력 받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//배열 초기화
		map = new char[N][M];
		visited = new boolean[N][M][K+1];

		// 맵 입력받기
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 경로찾기 실행
		visited[0][0][0] = true;
		goMN(0, 0);
		
		//경로를 찾지 못했으면 -1
		if (minDis == Integer.MAX_VALUE)
			minDis = -1;
		
		//결과 출력
		System.out.println(minDis);
	}

	public static class Pos { //x 좌표, y 좌표, 움직인 거리, 부수고 온 벽
		int x;
		int y;
		int dis;
		int broken;
		public Pos(int x, int y, int dis, int broken) {
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.broken = broken;
		}
	}

	public static void goMN(int x, int y) {
		
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(x, y, 1, 0)); //x:0, y:0, Dis:1, Broken:0 시작
		boolean day = true;
		
		while (!que.isEmpty()) {
			int size = que.size();
			
			while(--size>=0) {
				
				Pos now = que.poll();
				
				//도착하면 거리 갱신 후 종료
				if (now.x == N - 1 && now.y == M - 1) {
					minDis = minDis > now.dis ? now.dis : minDis;
					return;
				}
				//사방탐색
				for (int i = 0; i < 4; i++) {
					int xx = now.x + dir[i][0];
					int yy = now.y + dir[i][1];
					
					// 범위를 넘어가면 pass
					if (!(0 <= xx && xx < N && 0 <= yy && yy < M)) continue;
	
					// 이동할 곳이 벽인 경우
					if (map[xx][yy] == '1') {
						// 지금까지 부수고 온 횟수가 K보다 작고 아무도 k번 부수고 방문하지 않았다면??
						if (day && now.broken < K && !visited[xx][yy][now.broken + 1]) {
							visited[xx][yy][now.broken + 1] = true;//한번 더 부수고
							que.add(new Pos(xx, yy, now.dis + 1, now.broken + 1));//방문
						}else if(!day && now.broken < K && !visited[xx][yy][now.broken + 1]) {
							que.add(new Pos(now.x, now.y, now.dis + 1, now.broken));//방문
						}
					} else {// 벽이 아닌 경우
						if (!visited[xx][yy][now.broken]) {//지금까지 부순거만큼 방문한 적이 없다면
							visited[xx][yy][now.broken] = true;
							que.add(new Pos(xx, yy, now.dis + 1, now.broken));//방문
						}
					}
				}
			}
			day=!day;
		}
	}
}
