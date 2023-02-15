package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙_신규람 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//N입력
		int N = Integer.parseInt(br.readLine());
		
		//수를 담을 우선순위큐 생성
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			if(Math.abs(a)!=Math.abs(b)) //절댓값이 같지 않다면 오름차순
				return Math.abs(a)-Math.abs(b);
			else//절댓값이 같다면 작은게 앞으로
				return a-b;
		});
		//N번 입력받기
		for(int i=0;i<N;i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) { //수가 0일떄
				if(pq.isEmpty())//큐가 비어있으면
					sb.append(0+"\n");//0추가
				else//비어있지 않다면 가장 작은 값 출력
					sb.append(pq.poll()+"\n");
			}else {//0이 아니면 값 추가
				pq.add(x);
			}
		}
		System.out.println(sb.toString());//결과 출력
	}
}
