package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992_쿼드트리 {

	static int N;
	static char[][]arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void makeanswer(int size, int x, int y) {
		//시작 위치 값 t
		char t = arr[x][y];
		//순회하면서 시작 위치와 값이 같은지 확인
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				//다른부분이 있다면
				if (arr[i][j] != t) {
					//괄호를 삽입하고
					sb.append("(");
					//4영역으로 나누어 재귀
					makeanswer(size / 2, x, y);
					makeanswer(size / 2, x, y + size / 2);
					makeanswer(size / 2, x + size / 2, y);
					makeanswer(size / 2, x + size / 2, y + size / 2);
					//닫는 괄호
					sb.append(")");
					return;
				}
			}
		}
		//같았다면 시작 t값 삽입
		sb.append(t);
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//N입력
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		//배열 입력 받기
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			arr[i]=st.nextToken().toCharArray();
		}
		//함수 호출
		makeanswer(N,0,0);
		//결과 출력
		System.out.println(sb.toString());
	}
}
