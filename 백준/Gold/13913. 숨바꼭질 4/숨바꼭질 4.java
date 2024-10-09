import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static boolean []already = new boolean[100001];
	static int[]parent = new int[100001];
	static int time = 0;
	
	
	static void findAnswer(int N, int K) {
		Queue<Integer> que = new LinkedList<>();
		que.add(N);
		already[N]=true;
		
		while(!que.isEmpty()) {
			int size = que.size();
			while(--size>=0) {
				int now = que.poll();
				
				if(now==K) return;
				
				int next1 = now-1;
				if(0<=next1 && next1<=100000 && !already[next1]) {
					already[next1]=true;
					parent[next1]=now;
					que.add(next1);
				}
				
				int next2 = now+1;
				if(0<=next2 && next2<=100000 && !already[next2]) {
					already[next2]=true;
					parent[next2]=now;
					que.add(next2);
				}
				
				int next3 = now*2;
				if(0<=next3 && next3<=100000 && !already[next3]) {
					already[next3]=true;
					parent[next3]=now;
					que.add(next3);
				}
				
			}
			time++;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		findAnswer(N, K);
		sb.append(time+"\n");
		
		int idx = K;
		Stack<Integer> stack = new Stack<>();
		while(N!=idx) {
			stack.add(idx);
			idx=parent[idx];
		}
		sb.append(N+" ");
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			sb.append(tmp+" ");
		}
		System.out.println(sb.toString());
	}
}
