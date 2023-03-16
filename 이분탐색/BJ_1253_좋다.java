package bj;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1253_좋다 {
	static int N;
	static int []arr;
	static int cnt = 0;
	static void countGood(int now, int start, int last) {
		if(now>=N)
			return;
		while(start<last) {
			if(arr[start]+arr[last] < arr[now]) {
				start++;
			}else if(arr[start]+arr[last] > arr[now]) {
				last--;
			}else {
				if(start==now) {
					start++;
					continue;
				}
				if(last==now) {
					last--;
					continue;
				}
//				System.out.println("start : "+arr[start]+" end : "+arr[last]+" now :"+arr[now]);
				cnt++;
				break;
			}
		}
		countGood(now+1,0,N-1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = parseInt(br.readLine());
		arr = new int[N];
		//배열 값 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			arr[i]=parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		countGood(0,0,N-1);
		System.out.println(cnt);
	}
}
