import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Time{
		int x;
		int t;
		Time(int x, int t){
			this.x=x;
			this.t=t;
		}
	}
	static int N;
	static int K;
	static int []visited;
	
	static void move() {
		Deque<Time> q = new ArrayDeque<>();
		q.add(new Time(N,0));
		while(!q.isEmpty()) {
			Time now = q.poll();
			if(0<=now.x*2 && now.x*2<=100000 && (visited[now.x*2]==-1 || visited[now.x*2]>now.t)) {
				visited[now.x*2]=now.t;
				if(now.x*2==K)
					break;;
				q.addFirst(new Time(now.x*2,now.t));
			}
			if(0<=now.x-1 && (visited[now.x-1]==-1 || visited[now.x-1]>now.t+1)) {
				visited[now.x-1]=now.t+1;
				if(now.x*-1==K)
					break;;
				q.addLast(new Time(now.x-1,now.t+1));
			}
			if(now.x+1<=100000 && (visited[now.x+1]==-1 || visited[now.x+1]>now.t+1)) {
				visited[now.x+1]=now.t+1;
				if(now.x+1==K)
					break;;
				q.addLast(new Time(now.x+1,now.t+1));
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N!=K) {
			visited = new int[100001];
			Arrays.fill(visited, -1);
			move();
			System.out.println(visited[K]);
		}else {
			System.out.println(0);
		}
	}
}