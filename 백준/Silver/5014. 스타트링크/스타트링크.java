import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken()); // 꼭대기 층
		int S = Integer.parseInt(st.nextToken()); // 현재 위치
		int G = Integer.parseInt(st.nextToken()); // 스타트링크 위치
		int U = Integer.parseInt(st.nextToken()); // 위로
		int D = Integer.parseInt(st.nextToken()); // 아래로


		boolean []visited = new boolean[F+1];
		Queue<Integer> que = new LinkedList<>();
		que.add(S);
		visited[S]=true;
		
		int button = 0;
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				int now = que.poll();
				if(now==G) {
					System.out.println(button);
					return;
				}
				int up = now+U;
				if(up<=F && !visited[up]) {
					visited[up]=true;
					que.add(up);
				}
				int down = now-D;
				if(down>=1 && !visited[down]) {
					visited[down]=true;
					que.add(down);
				}
			}
			button++;
		}
		System.out.println("use the stairs");
	}
}
