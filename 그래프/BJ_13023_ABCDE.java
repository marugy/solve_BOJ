package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_13023_ABCDE {
	
	static int N;
	static int M;
	static boolean[] visited;
	static ArrayList<Node> list;
	
	private static boolean check(int idx, int count) {
		//연속된 4개의 관계 있다면 true 반환
		if(count==4) {
			return true;
		}
		//현재 사람의 친구 목록
		for(Node temp = list.get(idx); temp.next!=null; temp=temp.next) {
			if(!visited[temp.next.v]) {//아직 방문 안했다면
				visited[temp.next.v]=true;//방문
				if(check(temp.next.v,count+1)) {//true반환하면 return true;
					return true;
				};
				visited[temp.next.v]=false;//복구
			}
		}
		return false;
	}
	//Node 클래스 생성
	public static class Node{
		int v;
		Node next;
		public Node(int v, Node next) {
			this.v = v;
			this.next = next;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//N, M 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		//헤더 생성
		for(int i=0;i<N;i++)
			list.add(new Node(i,null));
		//연결리스트 값 입력
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.get(A).next = new Node(B,list.get(A).next);
			list.get(B).next = new Node(A,list.get(B).next);
		}
		//경우의 수가 있는지 점검
		for(int i=0;i<N;i++) {
			visited = new boolean[N];
			visited[i]=true;
			if(check(i,0)) {//있다면 1 출력
				System.out.println(1);
				return;
			}
		}System.out.println(0);//없다면 0 출력
	}
}
