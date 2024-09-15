import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		int val;
		int idx;
		Node(int val, int idx){
			this.val = val;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		Deque<Node> deque = new ArrayDeque<>();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(!deque.isEmpty() && deque.getLast().val > num) {
				deque.removeLast();
			}
			deque.add(new Node(num, i));
			if(deque.getFirst().idx<i-L+1){
				deque.removeFirst();
			}
			
			sb.append(deque.getFirst().val+" ");
		}
		System.out.println(sb.toString());
	}
}