import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[] parent;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static class Pos implements Comparable<Pos> {
		int x;
		int y;
		int w;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
			this.w = 0;
		}

		Pos(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Pos o) {
			return Integer.compare(this.w, o.w);
		}
	}

	static void giveNum(int num, int x, int y) {
		map[x][y] = num;
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(x, y));
		while (!q.isEmpty()) {
			Pos now = q.poll();
			for (int i = 0; i < 4; i++) {
				int xx = now.x + dir[i][0];
				int yy = now.y + dir[i][1];
				if (0 <= xx && xx < N && 0 <= yy && yy < M && map[xx][yy] == 1) {
					map[xx][yy] = num;
					q.add(new Pos(xx, yy));
				}
			}
		}
	}

	static int findSet(int a) {
		if (a == parent[a])
			return a;
		return parent[a] = findSet(parent[a]); // 찾아온짱을 내 짱으로 바꿔버려 path compression
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// 이미 같은 집합
		if (aRoot == bRoot)
			return false;
		// bRoot의 부모를 aRoot로
		parent[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 크기 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 섬 정보 입력
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 섬 번호 만들기
		int islandNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					giveNum(islandNum++, i, j);
				}
			}
		}
		islandNum -= 2;

		// 섬과 섬 사이의 거리
		int[][] adj = new int[islandNum][islandNum];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {// 섬일 때
					int sI = map[i][j];// 시작 섬 번호
					int dis = 0;
					int jj = j;
					while (jj - 1 >= 0 && map[i][jj - 1] == 0) {// 좌가 바다
						dis++;
						jj--;
						if (jj - 1 >= 0 && dis >= 2 && map[i][jj - 1] != 0) {
							int eI = map[i][jj - 1];
							if ((adj[sI - 2][eI - 2] == 0 || adj[sI - 2][eI - 2] > dis )&& sI!=eI) {
								adj[sI - 2][eI - 2] = dis;
							}
							break;
						}
					}
					dis = 0;
					jj = j;
					while (jj + 1 < M && map[i][jj + 1] == 0) {// 우 바다
						dis++;
						jj++;
						if (jj + 1 < M && map[i][jj + 1] != 0 && dis >= 2) {
							int eI = map[i][jj + 1];
							if ((adj[sI - 2][eI - 2] == 0 || adj[sI - 2][eI - 2] > dis)&& sI!=eI) {
								adj[sI - 2][eI - 2] = dis;
							}
							break;
						}
					}
					dis = 0;
					int ii = i;
					while (ii - 1 >= 0 && map[ii - 1][j] == 0) {// 상 바다
						dis++;
						ii--;
						if (ii - 1 >= 0 && map[ii - 1][j] != 0 && dis >= 2) {
							int eI = map[ii - 1][j];
							if ((adj[sI - 2][eI - 2] == 0 || adj[sI - 2][eI - 2] > dis)&& sI!=eI) {
								adj[sI - 2][eI - 2] = dis;
							}
							break;
						}
					}
					dis = 0;
					ii = i;
					while (ii + 1 < N && map[ii + 1][j] == 0) {// 하 바다
						dis++;
						ii++;
						if (ii + 1 < N && map[ii + 1][j] != 0 && dis >= 2) {
							int eI = map[ii + 1][j];
							if ((adj[sI - 2][eI - 2] == 0 || adj[sI - 2][eI - 2] > dis)&& sI!=eI) {
								adj[sI - 2][eI - 2] = dis;
							}
							break;
						}
					}
				}
			}
		}
		ArrayList<Pos> pq = new ArrayList<>();
		
		for (int i = 0; i < islandNum; i++) {
			for (int j = 0; j < islandNum; j++) {
				if (adj[i][j] != 0)
					pq.add(new Pos(i, j, adj[i][j]));
			}
		}
		
		parent = new int[islandNum];
		for (int i = 0; i < islandNum; i++) {
			parent[i] = i;
		}
		Collections.sort(pq,(a,b)->a.w-b.w);
		int result = 0, count = 0;
		for (Pos e : pq) {
			if (union(e.x, e.y)) {
				result += e.w;
				if (++count == islandNum - 1)
					break;
			}
		}
		if(count!=islandNum-1 || result ==0) System.out.println(-1);
		else System.out.println(result);

	}
}