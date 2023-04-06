import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new ArrayDeque<>();
		int sum=64;
		q.add(64);
		while(sum>X) {
			int a = q.poll();
			if(sum-a/2 >=X) { //하나 절반 없어도 X보다 크다면
				sum-=a/2;
			}else {
				q.addFirst(a/2);
			}
			q.addFirst(a/2);
		}
		System.out.println(q.size());
	}
}
