import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int A = 1;
		int B = 0;
		for(int i=0;i<K; i++) {
			int newA = B;
			int newB = A + B;
			A = newA;
			B = newB;
		}
		System.out.println(A+" "+B);
	}
}
