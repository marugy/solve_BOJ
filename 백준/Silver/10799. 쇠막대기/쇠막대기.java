import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []str = br.readLine().split("");
		Stack<String> stack = new Stack<>();
		int answer = 0;
		for(int j=0;j<str.length; j++) {
			if(str[j].equals("(")) {
				stack.add(str[j]);
			}else {
				stack.pop();
				if(str[j-1].equals(")")) answer++;
				else answer+=stack.size();
			}
		}
		System.out.println(answer);
	}
}
