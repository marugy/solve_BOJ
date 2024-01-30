package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1753_최단경로 {

	static class Vertex{
		int v;//연결된 간선 정보
		int w;//간선 가중치
		Vertex next;//연결된 다음 edge
		Vertex(int v, int w, Vertex next) {
			this.v = v;
			this.w = w;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());// 정점 수
		int E = Integer.parseInt(st.nextToken());// 간선 수
		
		ArrayList<Vertex> edges = new ArrayList<>();
		//헤더 삽입
		for(int i=0;i<V;i++) {
			edges.add(new Vertex(i,0,null));
		}
		
		int start = Integer.parseInt(br.readLine())-1;// 시작 정점
		//간선 정보 입력 받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			edges.get(u).next = new Vertex(v, w, edges.get(u).next);
		}

		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V];// 출발정점에서 자신까지 오는 최소비용
		boolean[] visited = new boolean[V]; // 경유지로 고려된 정점여부
		Arrays.fill(distance, INF);// 최소값이 갱신 로직을 반영해야하므로 큰값으로 초기화
		distance[start] = 0; // 출발지에서 출발지는 0

		int min, current;
		for (int c = 0; c < V; c++) {
			// step 1 : 경유지 처리되지 않은 정점 중 출발 지에서 가장 가까운 정점 선택
			current = -1;
			min = INF; // 출발지에서 가장 가까운 값
			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > distance[i]) {// 갱신하기
					min = distance[i];
					current = i;
				}
			}
			if (current == -1) break; // 더 갈 정점이 없다면
			visited[current] = true; // 방문처리
			
			Vertex v = edges.get(current);
			while(v.next != null) {
				v=v.next;
				if (!visited[v.v] && distance[v.v] > min + v.w) { //다음 노드를 방문하며
					distance[v.v] = min + v.w; //distance 갱신
				}
			}
		}
		for(int i=0;i<V;i++) {
			if(distance[i]==INF)
				System.out.println("INF"); //경로가 존재하지 않는 경우
			else
				System.out.println(distance[i]);//경로가 존재한 경우
		}
	}
}