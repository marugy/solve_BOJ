package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑_신규람 {

	public static void main(String[] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		//높은 값을 갱신하며 저장
		Stack<Integer> stack = new Stack<>();
		//높은 값을 가지는 index 저장
		Stack<Integer> highIdx = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N; i++) {
			//값 입력받음
			int num = Integer.parseInt(st.nextToken());
			//낮은 값들 비워내기
			while(!stack.isEmpty() && stack.peek()<num) {
				stack.pop();
				highIdx.pop();
			}
			if(stack.isEmpty()) {//스택이 비어있다면
				stack.add(num);//가장 높은 값으로 추가하고
				highIdx.add(i);//인덱스도 추가
				sb.append(0+" ");//스택이 비어있었다는 뜻은 내 신호를 받을 탑이 없다는 것이기에 0 추가
			}else{
				sb.append(highIdx.peek()+1+" ");//스택이 비어있지 않다면 가장 높은 탑이 내 신호를 받음
				stack.push(num);//스택에 추가
				highIdx.push(i);//idx도 추가
			}
		}
		System.out.println(sb.toString());
	}
}
