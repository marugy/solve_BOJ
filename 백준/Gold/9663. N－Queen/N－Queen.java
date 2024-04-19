import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int[] arr;
	public static int N;
	public static int count = 0;
 
 
	public static void nQueen(int depth) {
		if (depth == N) {
			count++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			// 놓을 수 있는 위치일 경우 재귀호출
			if (pos(depth)) {
				nQueen(depth + 1);
			}
		}
 
	}
 
	public static boolean pos(int col) {
 
		for (int i = 0; i < col; i++) {
			// 같은 열에 있는지 확인
			if (arr[col] == arr[i]) {
				return false;
			} 
			
			// 대각선에 위치하는지 확인
			// 열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
 
		nQueen(0);
		
		System.out.println(count);
	}
}