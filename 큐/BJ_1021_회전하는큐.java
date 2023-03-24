package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayDeque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++)
			deque.addLast(i);

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			ArrayDeque<Integer> dequeA = deque.clone();
			ArrayDeque<Integer> dequeB = deque.clone();
			
			int lcnt=0;
			while (dequeA.getFirst() != num) {
				int a = dequeA.pollFirst();
				dequeA.addLast(a);
				lcnt++;
			}
			int rcnt=0;
			while (dequeB.getFirst() != num) {
				int a = dequeB.pollLast();
				dequeB.addFirst(a);
				rcnt++;
			}
			if(lcnt<rcnt) {
				cnt+=lcnt;
				deque = dequeA;
			}else {
				cnt+=rcnt;
				deque = dequeB;
			}
			deque.pollFirst();
		}
		System.out.println(cnt);
	}
}
