package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BJ_10163_색종이_신규람 {

	static int[][] paperArr;
	static int []area;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		//색종이 영역
		paperArr = new int[1001][1001];
		area = new int[N+1];//넓이 배열
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//좌표
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			//영역
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			//색종이 번호 입력해주기
			for (int x = x1; x < x1+width; x++) {
				for (int y = y1; y <y1+height; y++) {
					paperArr[x][y] = i+1;
				}
			}
		}
		//넓이 구하기
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001; j++) {
				area[paperArr[i][j]]++;
			}
		}
		//결과출력하기
		for(int i=1;i<=N;i++) {
			System.out.println(area[i]);
		}
	}
}
