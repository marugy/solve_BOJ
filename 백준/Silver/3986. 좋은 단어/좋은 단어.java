import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static boolean isSame(String str1, String str2) {
		if(str1.equals(str2))return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			String []str = br.readLine().split("");
			Stack<String> stack = new Stack<>();
			for(int j=0;j<str.length; j++) {
				if(stack.isEmpty()) {
					stack.add(str[j]);
				}else {
					if(isSame(stack.peek(), str[j])) {
						stack.pop();
					}else {
						stack.add(str[j]);
					}
				}
			}
			if(stack.size()==0) answer++;
		}
		System.out.println(answer);
	}
}
