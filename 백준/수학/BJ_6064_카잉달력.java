package bj;
import static java.lang.Integer.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6064_카잉달력 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int M = parseInt(st.nextToken());
			int N = parseInt(st.nextToken());
			int x = parseInt(st.nextToken())-1;
			int y = parseInt(st.nextToken())-1;
			
			boolean make = false;
			for (int i = x; i < (N * M); i += M) {
				if (i % N == y) {
					sb.append(i+1).append("\n");
					make = true;
					break;
				}
			}
			if (!make) {
				sb.append(-1+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
