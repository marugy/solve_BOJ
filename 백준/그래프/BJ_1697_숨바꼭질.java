package bj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ_1697_숨바꼭질 {

	static int K;
	static boolean visited[];

	public static class Pos {
		int pos;//위치
		int time;//시간
		public Pos(int p, int t) {
			this.pos = p;
			this.time = t;
		}
	}
	
	public static int Bfs(int sb) {//수빈이 위치
		//위치와 시간을 담을 큐
		Deque<Pos> q = new ArrayDeque<>();
		q.add(new Pos(sb, 0));
		//큐가 빌떄까지 반복
		while (!q.isEmpty()) {
			int l = q.getFirst().pos; //현재 위치
			int t = q.getFirst().time;//현재 위치까지 걸린 시간
			q.poll();
			if (l == K)//도착하면 시간 반환
				return t;
			if (l + 1 < 100001 && !visited[l + 1]) {
				q.add(new Pos(l + 1, t + 1));
				visited[l + 1] = true;
			}
			if (l * 2 < 100001 && !visited[l * 2]) {
				q.add(new Pos(l * 2, t + 1));
				visited[l * 2] = true;
			}
			if (l - 1 >= 0 && !visited[l - 1]) {
				q.add(new Pos(l - 1, t + 1));
				visited[l - 1] = true;
			}
		}
		return 0;
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//위치 입력 받기
		int N = sc.nextInt();// 수빈이
		K = sc.nextInt();// 동생
		//방문 배열 선언
		visited = new boolean[100001];
		//Bfs 및 결과 출력
		System.out.println(Bfs(N));
	}
}
