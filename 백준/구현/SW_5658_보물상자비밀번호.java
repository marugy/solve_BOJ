package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class SW_5658_보물상자비밀번호 {
	static int N;
	static TreeSet<Integer> pwSet;
	
	static void makePW(String num) {
		// 큐에 각 자릿수 담기
		ArrayDeque<Character> q = new ArrayDeque();
		char[]nums = num.toCharArray();
		for (char c : nums) {
			q.add(c);
		}
		//크기 N만큼 회전 시키며 모든 경우의 수 구하기
		for(int kk=0; kk < N; kk++) {
			//자물쇠 4면의 비밀번호 구하기
			for(int ii=0;ii<4;ii++) {
				char[]temp = new char[N/4];
				for(int i=0;i<N/4;i++) {
					temp[i]=q.poll();
					q.add(temp[i]);
				}
				//16진수를 10진수로 변경하여 저장
				pwSet.add(Integer.decode("0x"+Arrays.toString(temp).replace("[", "").replace("]","").replace(", ","")));
			}
			//회전 시키기
			q.addFirst(q.pollLast());
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		//T 입력
		int T = Integer.parseInt(br.readLine());
		//테케 반복
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			//N, K 입력
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			//PW를 저장할 Treeset 생성
			pwSet = new TreeSet<>(Collections.reverseOrder());
			makePW(br.readLine());
			//K-1개 빼기
			for(int i=0;i<K-1;i++)
				pwSet.pollFirst();
			//k번째 저장
			sb.append(pwSet.pollFirst()+"\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
