package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656_벽돌깨기 {

	static int N;
	static int W;
	static int H;
	static int minSum;

	static class Pos { // 위치 정보와 폭발 범위를 저장할 클래스
		int x;// x 좌표
		int y;// y 좌표
		int v;// 폭발 범위

		Pos(int x, int y, int v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
	}

	// N개 벽돌을 부수는 함수
	static void breakBricks(int count, ArrayList<LinkedList<Integer>> list) {
		
		// N개를 모두 소모하면
		if (count == N) {
			int cnt = 0;
			for (int i = 0; i < W; i++) // 남아 있는 벽돌 수를 더해서
				cnt += list.get(i).size();
			if (minSum > cnt)// 최솟값 갱신
				minSum = cnt;
			return;
		}
		for (int i = 0; i < W; i++) {// 순열 진행
			ArrayList<LinkedList<Integer>> temp = new ArrayList<>();// 깊은 복사
			for(int j=0;j<W;j++) {
				temp.add((LinkedList<Integer>)list.get(j).clone());
			}
			breakBricks(count + 1, play(i, temp));//복사한 배열을 인자로 전달
		}
	}

	// 명중 시킬 위치를 기반으로 폭발을 진행할 함수
	static ArrayList<LinkedList<Integer>> play(int x, ArrayList<LinkedList<Integer>> list) { // 시작 지점과 현재 상태
		
		if(list.get(x).size()==0) //size가 0이면 그냥 반환 후 종료
			return list;
		int y = list.get(x).size() - 1;
		Queue<Pos> q = new ArrayDeque<Pos>();
		q.add(new Pos(x, y, list.get(x).get(y))); // 현재 위치, 폭발 범위 넣기
		// BFS로 진행
		while (!q.isEmpty()) {
			Pos boom = q.poll();
			list.get(boom.x).set(boom.y, 0);
			// 위
			for (int yy = boom.y + boom.v - 1; yy > boom.y; yy--) {
				if(yy>list.get(boom.x).size()-1) continue; //범위를 넘어 갔다면 pass
				if(list.get(boom.x).get(yy)!=0) { //0이 아니라면
					q.add(new Pos(boom.x, yy, list.get(boom.x).get(yy)));//큐에 담고 
					list.get(boom.x).set(yy, 0);//0으로 변경
				}
			}
			// 아래
			for (int yy = boom.y - boom.v + 1; yy < boom.y; yy++) {
				if(yy<0) continue; //범위를 넘어 갔다면 pass
				if(list.get(boom.x).get(yy)!=0) {//0이 아니라면
					q.add(new Pos(boom.x, yy, list.get(boom.x).get(yy)));//큐에 담고 
					list.get(boom.x).set(yy, 0);//0으로 변경
				}
			}
			// 왼쪽
			for(int xx = boom.x-boom.v +1; xx < boom.x; xx++) {
				if(xx<0 || list.get(xx).size()-1 < boom.y) continue;//범위를 넘어 갔다면 pass
				if(list.get(xx).get(boom.y)!=0) {//0이 아니라면
					q.add(new Pos(xx, boom.y, list.get(xx).get(boom.y)));//큐에 담고 
					list.get(xx).set(boom.y, 0);//0으로 변경
				}
			}
			// 오른쪽
			for(int xx = boom.x+boom.v -1; xx > boom.x; xx--) {
				if(xx>W-1 || list.get(xx).size()-1 < boom.y) continue;//범위를 넘어 갔다면 pass
				if(list.get(xx).get(boom.y)!=0) {//0이 아니라면
					q.add(new Pos(xx, boom.y, list.get(xx).get(boom.y)));//큐에 담고 
					list.get(xx).set(boom.y, 0);//0으로 변경
				}
			}
		}
		//0제거하기
		for(int i=0;i<W;i++) {
			for(int j=list.get(i).size()-1;j>=0;j--)
				if(list.get(i).get(j)==0)
					list.get(i).remove(j);
		}
		return list;//변경한 list 반환하기
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 떨어트릴 벽돌 수
			W = Integer.parseInt(st.nextToken());// 너비
			H = Integer.parseInt(st.nextToken());// 높이
			minSum = Integer.MAX_VALUE;// 최소 블럭 수
			// list 초기화
			ArrayList<LinkedList<Integer>> list = new ArrayList<>();
			for (int i = 0; i < W; i++)
				list.add(new LinkedList<Integer>());

			// 벽돌 정보 입력 받기
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int num = Integer.parseInt(st.nextToken());
					// 0이 아닌 숫자만 연결리스트에 넣어주기
					if (num != 0) {
						list.get(j).addFirst(num); // 나중에 넣은 값이 앞으로 오도록
					}
				}
			}
			// 벽돌 부수기
			breakBricks(0, list);
			//결과 추가
			sb.append(minSum+"\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}