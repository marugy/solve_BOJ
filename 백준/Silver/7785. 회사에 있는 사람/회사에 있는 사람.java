import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		TreeSet<String> list = new TreeSet<>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String log = st.nextToken();
			if(log.equals("enter")) {
				list.add(name);
			}else {
				list.remove(name);
			}
		}
		for (String name : list) {
			sb.append(name+"\n");
		}
		System.out.println(sb.toString());
	}
}
