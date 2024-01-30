package bj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1158_요세푸스_신규람 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		//여는 괄호
		sb.append("<");
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer>q = new LinkedList<>();
		//큐에 n까지 삽입
		for(int i=1;i<=N;i++)
			q.add(i);
		//큐가 빌떄까지 반복
		while(q.size()>0) {
			//k-1만큼 뒤로 보내고
			for(int i=0;i<K-1;i++) {
				q.add(q.poll());
			}
			//k번쨰는 내보내면서 StringBuilder에 추가
			if(q.size()==1)//마지막은 그냥 추가
				sb.append(q.poll());
			else//마지막이 아니면 ", "과 함께 append
				sb.append(q.poll()+", ");
		}
		//닫는 괄호
		sb.append(">");
		System.out.println(sb.toString());//결과출력
	}
}
