import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 공장 수
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] fac = new int[N + 2];
		// 공장 값 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			fac[i] = Integer.parseInt(st.nextToken());
		
		long sum = 0;
		if (B <= C) {
			for (int i = 0; i < N; i++) {
				sum+=(long)fac[i]*B;
			}
		}else {
			// 갯수파악
			for (int i = 0; i < N; i++) {
				// 가운데가 더 클때
				if (fac[i + 1] > fac[i + 2]) {
					// 2개씩 최대로 뽑기 -> i+1, i+2 동일하게 만들기
					int a = Math.min(fac[i], fac[i + 1] - fac[i + 2]);
					sum += (long)(B + C) * a;
					fac[i] -= a;
					fac[i + 1] -= a;
					// 3개씩 최대로 뽑기 위해i+1, i+2의 차와 fac[i]비교
					int b = Math.min(fac[i], Math.min(fac[i + 1], fac[i + 2]));
					sum += (long)(B + 2 * C) * b;
					fac[i] -= b;
					fac[i + 1] -= b;
					fac[i + 2] -= b;
					// 남은 fac[i]처리
					sum += (long)B * fac[i];
				} else { // 오른쪽이 크거나 같을 때
							// 3개씩 최대로 뽑기
					int a = Math.min(fac[i], fac[i + 1]);
					sum += (long)(B + 2 * C) * a;
					fac[i] -= a;
					fac[i + 1] -= a;
					fac[i + 2] -= a;
					// 2개씩 최대 뽑기
					int b = Math.min(fac[i], fac[i + 1]);
					sum += (long)(B + C) * b;
					fac[i] -= b;
					fac[i + 1] -= b;
					// 남은 fac[i]처리
					sum += (long)B * fac[i];
				}
			}
		}
		System.out.println(sum);
	}
}
