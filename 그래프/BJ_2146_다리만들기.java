package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146_다리만들기_신규람 {

	static int N;// 섬크기
	static int[][] island; //섬 정보
	static boolean[][] visited;//방문 여부

	static int minLength = Integer.MAX_VALUE;// 최소 다리길이

	static int length; // 건설한 다리 길이
	static int islandNum = 2; // 섬번호
	static int startIslandNum;//출발하는 섬 번호

	public static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static class Pos {//좌표를 저장할 클래스
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void checkBridge(int i, int j) {

		Queue<Pos> q = new LinkedList<>(); //bfs를 구현할 큐
		q.add(new Pos(i, j)); //시작 위치 추가
		visited[i][j] = true;

		while (!q.isEmpty()) { //큐가 비어있지 않을떄까지 반복
			
			int size = q.size(); //depth를 계산하기 위해 size만큼 반복
			
			while (--size >= 0) {
				Pos now = q.poll();
				int x = now.x;
				int y = now.y;

				for (int d = 0; d < 4; d++) { //현재 바다 주변에 방문하지 않은곳이 있는지 탐색
					int xx = x + dir[d][0];
					int yy = y + dir[d][1];
					if (0 <= xx && xx < N && 0 <= yy && yy < N && visited[xx][yy] == false) {
						if (island[xx][yy] == 0) {// 방문하지 않은 바다가 있다면 큐에 추가
							visited[xx][yy] = true;
							q.offer(new Pos(xx, yy));
						} else if (island[xx][yy] != startIslandNum) {// 방문하지 않은 다른 섬의 경우 minLength값 갱신
							if (minLength > length) {
								minLength = length;
							}
						}
					}
				}
			}
			length++; //size만큼 수행 후 depth 갱신
		}
	}

	public static void makeIsland(int i, int j) { // 섬마다 섬 번호로 수정하기
		// 연결되어 있는 땅=섬을 같은 번호로
		island[i][j] = islandNum;
		
		for (int d = 0; d < 4; d++) {//주변을 살펴 연결된 땅을 섬 번호로
			int xx = i + dir[d][0];
			int yy = j + dir[d][1];
			if (0 <= xx && xx < N && 0 <= yy && yy < N && island[xx][yy] == 1) {
				island[i][j] = islandNum;
				makeIsland(xx, yy);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 지도의 크기
		N = Integer.parseInt(br.readLine());
		// 섬 정보를 저장할 배열
		island = new int[N][N];
		// 섬 정보 입력 받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				// 땅 정보 입력
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) { // 섬번호 만들기
			for (int j = 0; j < N; j++) {
				if (island[i][j] == 1) { //1이라면 섬번호로 수정하기 시작
					makeIsland(i, j);
					islandNum++;
				}
			}
		}

		for (int i = 0; i < N; i++) { // 섬번호 만들기
			for (int j = 0; j < N; j++) {
				if (island[i][j] != 0) { // 바다가 아닌데
					for (int d = 0; d < 4; d++) { // 주변이
						int xx = i + dir[d][0];
						int yy = j + dir[d][1];
						// 바다라면??
						if (0 <= xx && xx < N && 0 <= yy && yy < N && island[xx][yy] == 0) {
							startIslandNum = island[i][j]; // 시작 섬위치를 바꾸고
							visited = new boolean[N][N];// 방문 초기화
							length = 1;
							checkBridge(xx, yy); // 다리 건설 시작
						}
					}
				}
			}
		}

		System.out.println(minLength); // 최소 길이 출력
	}
}
