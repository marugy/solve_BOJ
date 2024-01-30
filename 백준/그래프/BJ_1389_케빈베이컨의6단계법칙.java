package bj;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1389_케빈베이컨의6단계법칙 {

	static int N;
	static int M;
	static Node[] friends;
	static boolean[] visited;
	static int minKevin = Integer.MAX_VALUE; //최소 케빈베이컨 수
	static int kevin;//현재 조사하는 케빈베이컨
	static int minPeople = Integer.MAX_VALUE;//최소 케빈베이컨을 가진 사람 번호

	public static class Node { //연결리스트를 만들 노드
		int num;
		Node next;
		public Node(int num, Node next) {
			this.num = num;
			this.next = next;
		}
	}

	public static void kevin(int start, int count) { //조사를 시작할 idx, depth
		Queue<Integer> q = new ArrayDeque<>();
		//시작 노드 헤더 삽입
		q.add(start);
		
		while (!q.isEmpty()) {
			int size = q.size();//depth 관리
			while(--size>=0) {//같은 depth에서
				Node n = friends[q.poll()];
				visited[n.num]=true;
				while (n.next != null) { // 해당 사람의 관계 중 아직 방문 안한사람 모두 집어넣기
					if (!visited[n.next.num]) {
						visited[n.next.num] = true;//방문 처리
						q.add(n.next.num);
						kevin += count; //count만큼 케빈 수 증가
					}
					n = n.next;
				}
			}
			count++;//depth가 끝나면 depth증가
		}
		if (minKevin > kevin) {//최솟값 갱신
			minKevin = kevin;
			minPeople = start;
		}else if(minKevin == kevin && minPeople > start) {//동일값에는 작은 번호의 사람으로
			minPeople=start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = parseInt(st.nextToken());// 유저 수
		M = parseInt(st.nextToken());// 관계 수
		friends = new Node[N + 1];// 관계를 담을 배열
		for (int i = 1; i <= N; i++) {
			friends[i] = new Node(i, null);
		}
		// 관계 정보 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = parseInt(st.nextToken());
			int B = parseInt(st.nextToken());
			friends[A].next = new Node(B, friends[A].next);
			friends[B].next = new Node(A, friends[B].next);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];// 연결된 여부를 확인할 배열
			kevin = 0;
			kevin(i, 1);//케빈베이컨 실시
		}
		System.out.println(minPeople);//결과 출력
	}
}
