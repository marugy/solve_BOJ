package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_9019_DSLR {

	static int B;
	static boolean[] isMade;
	static StringBuilder sb = new StringBuilder();

	static class Alpha {//숫자와 문자열을 표현할 Alpha
		int num;
		String str;
		Alpha(int num, String str) {
			this.num = num;
			this.str = str;
		}
	}
	static void play(int A, String str) {
		ArrayList<Alpha> arr = new ArrayList<>();
		arr.add(new Alpha(A, str));
		
		while (!arr.isEmpty()) {
			int size = arr.size();
			while (--size >= 0) {//depth만큼 반복
				Alpha now = arr.get(0);
				arr.remove(0);
				//D 명령어 수행
				if(!isMade[now.num * 2 % 10000]) {//아직 만들지 않은 수라면
					arr.add(new Alpha(now.num * 2 % 10000, now.str + "D"));
					isMade[now.num * 2 % 10000]=true;
				}
				//S 명령어 수행
				if (now.num == 0) {
					if(!isMade[9999]) {
						arr.add(new Alpha(9999, now.str + "S"));
						isMade[9999]=true;
					}
				}
				else {
					if(!isMade[now.num-1]) {
						arr.add(new Alpha(now.num - 1, now.str + "S"));
						isMade[now.num-1]=true;
					}
				}
				//L 명령어 수행
				int n = now.num * 10;
				if(!isMade[n % 10000 + n / 10000]) {
					arr.add(new Alpha(n % 10000 + n / 10000, now.str + "L"));
					isMade[n % 10000 + n / 10000]=true;
				}
				//R 명령어 수행
				int m = now.num % 10;
				if(!isMade[now.num / 10 + m * 1000]) {
					arr.add(new Alpha(now.num / 10 + m * 1000, now.str + "R"));
					isMade[now.num / 10 + m * 1000]=true;
				}
			}
			//자식들 정렬 후
			Collections.sort(arr,(a,b)->{
				return  a.str.length()- b.str.length();
			});
			//정답이 있는지 확인
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i).num==B) {
					sb.append(arr.get(i).str).append("\n");
					return;
				}
			}
		}
	}
	//최대 자릿수를 표현할 deci만들기
	static int getDeci(int A) {
		int num = 0;
		while (A >= 10) {
			A /= 10;
			num++;
		}
		return (int) Math.pow(10, num);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 테케 입력
		int T = Integer.parseInt(br.readLine());
		//테케 반복
		for (int tc = 0; tc < T; tc++) {
			//값 입력 받기
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			//이미 만들어진 수인지 판단
			isMade = new boolean[10000];
			String str = "";
			//함수 시작
			play(A, str);
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
