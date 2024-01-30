package BJ;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1071_소트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//값 입력
		int N = parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N-1; i++) {
			// 다음 값이 연속되는 값
			if (arr[i] + 1 == arr[i + 1]) {
				int idx = i+2;
				//i+1보다 큰 값 찾기
				while(idx < N &&arr[idx]==arr[i+1])
					idx++;
				if(idx==N) {//i+1 위치의 값보다 큰게 없으면
					int start = i-1;
					while (start >= 0 &&arr[start] == arr[i]) {
						start--;
					}
					arr[start + 1]++;
	        		arr[i + 1]--;
				}else if(idx<N){//i+1 위치의 값보다 큰게 있으면
					//i+1 위치와 idx위치 값 swap
					int temp = arr[idx];
	        		arr[idx] = arr[i + 1];
	        		arr[i + 1] = temp;
				}
			}
		}
		for(int i=0;i<N; i++)
			System.out.print(arr[i] +" ");
	}
}

