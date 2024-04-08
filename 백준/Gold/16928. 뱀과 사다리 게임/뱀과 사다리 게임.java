import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	static int minCnt = 0;
	static HashMap<Integer, Integer> ladder;
	static boolean[] visited = new boolean[101];
	
	static void playGame(int start) {
		
		int count = 0;
		ArrayDeque<Integer> que = new ArrayDeque<>();
		que.add(start);
		visited[1]=true;
		
		while(!que.isEmpty()) {
			int size = que.size();
//			System.out.println(count+"----------------------------------");
			
			while(--size>=0) {
				int now = que.poll();
//				System.out.println("now :"+now);
				
				if(now==100) {
					minCnt = count;
					return;
				}
				if(ladder.containsKey(now)) {
//					if(!visited[ladder.get(now)]) {
						que.addFirst(ladder.get(now));
						visited[ladder.get(now)]=true;
//						System.out.println("move ladder : "+ladder.get(now));
						size++;
//					}
					continue;
				}
				for(int dice=1; dice<=6; dice++) {
					if(now+dice<=100 && !visited[now+dice]) {
						que.add(now+dice);
//						System.out.println("add : "+(now+dice));
						visited[now+dice]=true;
					}
				}
			}
			count++;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ladder = new HashMap<>();
		
		for(int i=0;i<n+m;i++) {
			st = new StringTokenizer(br.readLine());
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		playGame(1);
		System.out.println(minCnt);
	}
}
