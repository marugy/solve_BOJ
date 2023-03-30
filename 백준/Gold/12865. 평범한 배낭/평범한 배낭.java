import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        //갯수, 최대 무게 입력
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		// 물건의 무게, 이윤을 담을 배열 선언
		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];
        //값 입력 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
		}

		// 초기값 세팅 : int[][] 베열의 자동초기화를 이용
		int[][] D = new int[N+1][W + 1];

		for (int i = 1; i <= N; i++) {// i는 물건
			for (int w = 1; w <= W; w++) { // w는 가방의 목표무게(1부터 목표 무게까지)
				// 해당 물건의 무게가 w를 초과하는지
				if (weights[i] > w) { //현재 물건의 무게가 총 무게를 초과하면 
					D[i][w] = D[i-1][w];
				}else {//초과 X, 이전값 vs 포함 안했을때 하나 빼고 현재 물건 추가
					D[i][w] = Math.max(D[i-1][w], profits[i] + D[i - 1][w - weights[i]]);
				}
			}
		}
		System.out.println(D[N][W]);
	}
}
