package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {

	static int N; // 세로
	static int M; // 가로
	static int day= -1; // 익은 날짜
	static int badTomato; // 안익은 토마토
	static int[][] arr;// 토마토 저장 배열
	//사방 탐색 배열
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Pos> q = new ArrayDeque<>(); // 익은 토마토를 담을 큐

	static class Pos { // 좌표를 저장할 클래스
		int x;
		int y;
		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void BFS() { //BFS 반복하여 익은 토마토 옆에 있는 안익은 토마토 익히기
		while (!q.isEmpty()) {
			int size = q.size();
			while (--size >= 0) {
				Pos tomato = q.poll();
				int tx = tomato.x;
				int ty = tomato.y;
				for (int i = 0; i < 4; i++) { // 사방 탐색
					int xx = tx + dir[i][0];
					int yy = ty + dir[i][1];
					if (!(0 <= xx && xx < N && 0 <= yy && yy < M)) continue;
					if (arr[xx][yy] == 0) {
						q.add(new Pos(xx, yy));
						arr[xx][yy]=1;
						badTomato--;
					}
				}
			}
			day++; // depth에 따라 날짜 증가
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// M, N 입력 및 배열 선언
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		// 배열 입력 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j]==0)//안 익은 토마토
					badTomato++;
				if(arr[i][j]==1)//익은 토마토면 큐에 넣기
					q.add(new Pos(i,j));
			}
		}
		if(badTomato==0) // 이미 다 익어 있는 상태 0 출력
			System.out.println(0);
		else {
			// 토마토 숙성 시키기~
			BFS();
			if(badTomato!=0)//안익은게 있으면 -1
				System.out.println(-1);
			else
				System.out.println(day);
		}
	}
}
