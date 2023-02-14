package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_신규람 {

	static int N;
	static int M;
	static int R;
	static int[] arr;

	static void turnArr(int index) {
		int now = index;
		int next, prev;
		prev = arr[index];
		next = arr[index];

		int count = 0;
		// 위에서 아래로
		while (count < N - 1 - 2 * (index / M)) {
			next = arr[now + M];
			arr[now + M] = prev;
			now += M;
			prev = next;
			count++;
		}
		count = 0;
		// 왼쪽에서 오른쪽
		while (count < M - 1 - 2 * (index % M)) {
			next = arr[now + 1];
			arr[now + 1] = prev;
			now += 1;
			prev = next;
			count++;
		}
		count = 0;
		// 아래에서 위로
		while (count < N - 1 - 2 * (index / M)) {
			next = arr[now - M];
			arr[now - M] = prev;
			now -= M;
			prev = next;
			count++;
		}
		count = 0;
		// 왼쪽에서 오른쪽
		while (count < M - 1 - 2 * (index % M)) {
			next = arr[now - 1];
			arr[now - 1] = prev;
			now -= 1;
			prev = next;
			count++;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 값 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 배열 선언
		arr = new int[N * M];
		// 배열 값 입력받기
		int index = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[index++] = Integer.parseInt(st.nextToken());
		}
		
		//회전 시키기
		for (int j = 0; j < R; j++) {
			for (int i = 0; i / M < N / 2 && i%M < M/2; i += (M + 1)) {
				turnArr(i);
			}
		}
		
		//배열 출력하기
		for (int i = 0; i < N * M; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % M == 0)
				System.out.println();
		}

	}
}
