package BJ;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[][]arr;
	static boolean visited[];
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//값 입력
		N = parseInt(st.nextToken());
		M = parseInt(st.nextToken());
		int V = parseInt(st.nextToken())-1;
		//배열 선언
		arr = new int[N][N];
		visited = new boolean[N];
		//배열 값 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = parseInt(st.nextToken())-1;
			int to = parseInt(st.nextToken())-1;
			arr[from][to] = 1;
			arr[to][from] = 1;
		}
		//dfs, bfs 수행
		dfs(V);
		sb.append("\n");
		//방문 초기화
		visited = new boolean[N];
		bfs(V);
		//결과 출력
		System.out.println(sb.toString());
	}
	//dfs 수행
	public static void dfs(int vertex) {
		sb.append(vertex+1+" ");
		visited[vertex]=true;
		for(int i=0;i<N;i++) {
			if(!visited[i] && arr[vertex][i]==1) {
				visited[i]=true;
				dfs(i);
			}
		}
	}
	//bfs 수행
	public static void bfs(int vertex) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(vertex);
		visited[vertex]=true;
		while(!q.isEmpty()) {
			int v = q.poll();
			sb.append(v+1+" ");
			for(int i=0;i<N;i++) {
				if(!visited[i] && arr[v][i]==1) {
					q.offer(i);
					visited[i]=true;
				}
			}
		}
	}
}
