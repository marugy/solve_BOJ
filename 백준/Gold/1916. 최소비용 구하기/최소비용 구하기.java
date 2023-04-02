import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] distance;
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 값 입력
		N = Integer.parseInt(br.readLine()); // 도시 수
		M = Integer.parseInt(br.readLine()); // 버스 수
		map = new int[N][N]; // 가중치 정보
		visited = new boolean[N];// 방문 여부
		distance = new int[N];// 출발 정점에서 자신까지 오는 최소 비용
		Arrays.fill(distance, Integer.MAX_VALUE); // 최소비용을 최대값으로 설정

		// 버스 정보 입력받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken())+1;
			if(map[start][end]==0) {
				map[start][end] = weight;// 출발-도착 비용 저장
			}else {
				map[start][end] = Math.min(map[start][end], weight);
			}
		}
		
		// 출발, 도착 입력받기
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		distance[start] = 0; // 출발->출발은 0

		int min, current; // 최소 비용, 현재 위치
		// 도시 순회
		for (int i = 0; i < N; i++) { //도시 수만큼 반복
			// 아직 경유하지 않은 정점에서 최소 비용 정점 선택
			current = -1;
			min = Integer.MAX_VALUE; // 출발지에서 가장 가까운 값
			
			for(int j=0;j<N;j++) {
				if (!visited[j] && min > distance[j]) { //방문 안했고 최소이면
					min = distance[j]; // 최소 값
					current = j;// 최소 정점
				}
			}
			if (current == -1)
				break; // 더 갈 정점이 없다면 종료
			visited[current] = true;
			// 선택된 정점이 문제에서 요구하는 도착정점이면 종료
			if (current == end)
				break;

			// step 2 : 위에서 선택된 정점을 경유지로 해서 갈수 있는 다른 미방문 인접정점과의 비용 최소값 갱신
			for (int j = 0; j < N; j++) {
				//갈수 있고 최소 현재 도시를 경우하는 비용이 더 저렴한 경우
				if (!visited[j] && map[current][j] > 0 && distance[j] > min + map[current][j]-1) {
					distance[j] = min + map[current][j]-1; //비용 갱신
				}
			}
		}
		System.out.println(distance[end]);//결과 출력
	}
}
