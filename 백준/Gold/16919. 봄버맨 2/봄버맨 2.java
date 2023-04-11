import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, N, bCnt;
	static Pos[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static class Pos {
		int x;
		int y;
		int t;
		Pos(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static void boom() {
		int time = 1;
		
		while (time < N) {
			time++;
			if(time%2==0) {
				// 폭탄 설치
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] == null) {
							map[i][j] = new Pos(i, j, time+3);
						}
					}
				}
			}
			if(time>N)
				break;
			// 폭발
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					Pos tmp = map[i][j];
					if (tmp!=null && tmp.t == time) {
						map[i][j]=null;
						for (int d = 0; d < 4; d++) {
							int xx = tmp.x + dir[d][0];
							int yy = tmp.y + dir[d][1];
							if (0 <= xx && xx < R && 0 <= yy && yy < C) {
								if(map[xx][yy]!=null && map[xx][yy].t!=time) {
									map[xx][yy]=null;
								}
							}
						}
					}
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new Pos[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (tmp[j] == 'O') {
					map[i][j] = new Pos(i, j,3);
				}
			}
		}
		
		if(N==1) {
			for(int i=0;i<R;i++) {
				for (int j = 0; j < C; j++) {
					if(map[i][j]==null)
						System.out.print(".");
					else
						System.out.print("O");
				}
				System.out.println();
			}
		}else {
			if(N>4) {
			N=N%4+4;
			}
		boom();
		
		for(int i=0;i<R;i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==null)
					System.out.print(".");
				else
					System.out.print("O");
			}
			System.out.println();
		}
		}
	}
}