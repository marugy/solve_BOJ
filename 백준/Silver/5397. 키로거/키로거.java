import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		for(int i=0;i<tc;i++) {
			String []L = br.readLine().split("");
			Stack<String> stackA = new Stack<>();
			Stack<String> stackB = new Stack<>();
			for(int l=0; l<L.length; l++) {
				if(L[l].equals("<")) {
					if(!stackA.isEmpty()) stackB.add(stackA.pop());
				}else if(L[l].equals(">")) {
					if(!stackB.isEmpty()) stackA.add(stackB.pop());					
				}else if(L[l].equals("-")) {
					if(!stackA.isEmpty()) stackA.pop();
				}else {
					stackA.add(L[l]);
				}
			}
			StringBuilder sb = new StringBuilder();
			while(!stackA.isEmpty()) {
				sb.append(stackA.pop());
			}
			sb.reverse();
			while(!stackB.isEmpty()) {
				sb.append(stackB.pop());
			}
			System.out.println(sb.toString());
		}
	}

}
