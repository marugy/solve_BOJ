package swea;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_3124_최소스패닝트리_크루스칼 {

	//간선 정보를 저장할 class
	static class Edge implements Comparable<Edge> {
		int from, to, weight; //출발, 도착, 가중치
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {//오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int V, E; //정점 수, 간선 수
	static Edge[] edgeList; // 간선 리스트
	static int[] parents; // 부모 정보 저장

	//자신을 루트로 집합 초기화
	static void makeSet() {
		parents = new int[V];
		edgeList = new Edge[E];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	//집합의 루트 반환
	static int findSet(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = findSet(parents[a]); // 찾아온짱을 내 짱으로 바꿔버려 path compression
	}

	//집합 합치기
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// 이미 같은 집합
		if (aRoot == bRoot)
			return false;
		// bRoot의 부모를 aRoot로
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		// 테케 수 입력
		int T = parseInt(br.readLine());
		//테케 반복
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			V = parseInt(st.nextToken());// 정점 수
			E = parseInt(st.nextToken());// 간선 수
			
			//집합 및 간선 리스트 생성
			makeSet();
			
			//간선 입력 받기
			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int A = parseInt(st.nextToken())-1;
				int B = parseInt(st.nextToken())-1;
				int C = parseInt(st.nextToken());
				//간선 리스트 삽입
				edgeList[i]=new Edge(A, B, C);
			}
			Arrays.sort(edgeList); //가중치 오름차순 정렬
			
			
			//가중치의 합, 간선 수
			long result = 0, count = 0;
			//오름차순으로 정렬된 간선 순회
			for (Edge e : edgeList) {
				if (union(e.from, e.to)) { //서로 다른 집합인데 합친 경우
					result += e.weight;//가중치 증가
					if (++count == V - 1)//싸이클이 되지 않도록 V-1개 합쳤으면 종료
						break;
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}
