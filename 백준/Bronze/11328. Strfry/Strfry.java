import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine());

		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			String[] str1 = st.nextToken().split("");
			String[] str2 = st.nextToken().split("");
			Arrays.sort(str1);
			Arrays.sort(str2);
			if(str1.length!=str2.length) {
				System.out.println("Impossible");
				continue;
			}
			int j=0;
			for(;j<str1.length;j++) {
				if(!str1[j].equals(str2[j])) {
					System.out.println("Impossible");
					break;
				}
			}if(j==str1.length) System.out.println("Possible");
			
		}
	}
}
