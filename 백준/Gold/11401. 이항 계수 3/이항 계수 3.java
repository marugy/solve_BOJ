import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 나눌 소수
	static long p = 1000000007;
	// 페르마의 정리
	static long fermat(long a, long b) {
		if (b == 1)
			return a;
		long tmp = fermat(a, b / 2);
		if (b % 2 == 1)
			return tmp * tmp % p * a % p;
		else
			return tmp * tmp % p;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 값 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		// nCr에서 분자를 나타낼 수
		long a = 1;
		// nCr에서 분모를 나타낼 수
		long b = 1;
		// nCr 분모의 (n-r)!과 r!에 해당하는것 중 작은거
		long t = Math.min(R, N - R);
		for (int i = 0; i < t; i++) {
			a = a * (N - i) % p;
			b = b * (t - i) % p;
		}
		// 나머지 정리
		long ans = (a % p * fermat(b, p - 2) % p) % p;
		// 결과 출력
		System.out.println(ans);
	}
}
