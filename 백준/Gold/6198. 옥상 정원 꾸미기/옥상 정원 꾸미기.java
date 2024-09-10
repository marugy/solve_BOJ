import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long sum = 0;
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			int height = Integer.parseInt(br.readLine());
			while(!stack.isEmpty() && stack.peek()<=height) {
				stack.pop();
			}
			sum+=stack.size();
			stack.add(height);
		}
		System.out.println(sum);
	}

}
