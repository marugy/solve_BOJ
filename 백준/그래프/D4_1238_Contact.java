package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_1238_Contact {

	static boolean[][] map;
	static boolean[] visited;
	static int last = 0;

	public static void call(int start) {
		ArrayList<Integer> list = new ArrayList<>();
		// 시작 노드 넣기
		list.add(start);
		while (!list.isEmpty()) {
			int size = list.size();
			// depth 관리
			while (--size >= 0) {
				int now = list.remove(0);
				// 연결된 사람들 모두 추가
				for (int i = 0; i < 100; i++) {
					//연결된 사람중에 전화 받지 않은 사람 큐에 담기
					if (map[now][i] && !visited[i]) {
						list.add(i);
						map[now][i] = false;
						visited[i] = true;
					}
				}
				if (list.isEmpty()) {//마지막 사람을 last로
					last = now;
				}
			}
			list.sort((a, b) -> a - b);// 동시에 연락 받은 사람중에 숫자가 큰 사람을 반환해야하기에 sort진행
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#" + tc + " ");
			map = new boolean[100][100];
			visited = new boolean[100];
			// 데이터 길이와 시작점
			StringTokenizer st = new StringTokenizer(br.readLine());
			int length = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 1;
			// 연결 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < length / 2; i++) {
				map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
			}
			//전화돌리기
			call(start);
			//결과 추가하기
			sb.append(last + 1 + "\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
