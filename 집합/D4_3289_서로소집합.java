package swea;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3289_서로소집합 {

	static int N;
	static int[] parents;

	// 최소 단위 집합 생성
	static void makeSet() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	//집합의 루트 번호 찾기
	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	// 두 집합 합치기
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		parents[bRoot] = aRoot;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		// T 입력
		int T = parseInt(br.readLine());
		// 테케 반복
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = parseInt(st.nextToken());
			parents = new int[N];
			// 집합 초기화
			makeSet();

			// 연산자 수
			int m = parseInt(st.nextToken());

			// 연산자 입력 받기
			for (int op = 0; op < m; op++) {
				st = new StringTokenizer(br.readLine());

				int oper = parseInt(st.nextToken());
				int a = parseInt(st.nextToken()) - 1;
				int b = parseInt(st.nextToken()) - 1;

				if (oper == 0) {// 0이면 합집합
					union(a, b);
				} else {
					// 같은 집합일때
					if (findSet(a) == findSet(b))
						sb.append(1);
					// 다른 집합
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
