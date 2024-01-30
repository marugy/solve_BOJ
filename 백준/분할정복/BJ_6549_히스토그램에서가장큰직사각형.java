package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class BJ_6549_히스토그램에서가장큰직사각형 {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N;
		while (true) {
			st = new StringTokenizer(br.readLine());
			//N 입력
			N = Integer.parseInt(st.nextToken());
			if (N == 0) break;
			arr = new int[N];
			// 히스토그램 입력
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(getArea(N)).append('\n');
		}
		System.out.println(sb);
	}

	public static long getArea(int len) {
		Stack<Integer> stack = new Stack<Integer>();
		long maxArea = 0;
		for (int i = 0; i < len; i++) { //왼쪽부터 진행
			while ((!stack.isEmpty()) && arr[stack.peek()] >= arr[i]) { //큐에 있는 값이 현재 위치의 값보다 크거나 같으면
				int height = arr[stack.pop()]; // 이전 체인의 높이
				long width = stack.isEmpty() ? i : i - 1 - stack.peek();
				maxArea = Math.max(maxArea, height * width); // 최대 넓이 값 갱신
			}
			stack.push(i);//스택이 비었거나 현재 위치의 값이 더 크면 스택에 삽입
		}
		while (!stack.isEmpty()) { //남은게 있을 수 있기에 같은 방식으로 처리
			int height = arr[stack.pop()];
			long width = stack.isEmpty() ? len : len - 1 - stack.peek();
			maxArea = Math.max(maxArea, width * height);
		}
		return maxArea;
	}
}