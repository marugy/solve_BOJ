
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static class Info{
        int num;
        long cnt;

        public Info(int num, long cnt){
            this.num = num;
            this.cnt = cnt;
        }
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long answer = 0;
		int N = Integer.parseInt(br.readLine());
		Stack<Info> stack = new Stack<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			Info now = new Info(num,1);
			
			while(!stack.isEmpty() && stack.peek().num <= num) {
				Info top = stack.pop();
				answer+=top.cnt;
				if(top.num==now.num) {
					now.cnt+=top.cnt;
				}
			}
			if(!stack.isEmpty())answer++;
			stack.add(now);
		}
		System.out.println(answer);
	}
}
