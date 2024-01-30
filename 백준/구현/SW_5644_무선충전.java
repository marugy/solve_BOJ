package swea;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 	지금 충전 범위에 있는지 확인
 * 		같은 BC에 속해 있는지 확인
 * 			같은 범위라면 절반으로 나눴을때와, 각각 나눠서 받았을때 뭐가 더 큰지 비교
	이동하기
	이동이 모두 끝나면 충전값 확인
*/

public class SW_5644_무선충전 {

	static int M; //이동시간
	static int A; //BC 개수
	static int[][] BC;//BC 정보 저장 // BC의 좌표 x, y, 범위, 성능
	static int[][]posUser = new int[][]{{0,0},{9,9}};//유저A x,y || 유저B x,y
	static int[][] moving; //A와 B이동 저장
	static int []sum; //A, B충전량
	static int cnt;
	
	public static void calMax() {
		do {
			int bcA = isInBC(0); // A가 속한 BC id
			int bcB = isInBC(1); // B가 속한 BC id
			
			//둘다 범위 안에 있는 경우
			if(bcA!=-1 && bcB!=-1) { //둘 다 어떤 BC에 속한 경우
				if(bcA==bcB) {//같은 BC에 속한 경우
					int nextA = bcA;
					int nextB = bcB;
					
					for(int i=bcA+1;i<A;i++) {//A유저가 속한 다른 BC가 있는지 확인
						if(isInBC(0, i)) { //있다면 nextA로
							nextA=i;
							break;
						}
					}
					for(int i=bcB+1;i<A;i++) {//B유저가 속한 다른 BC가 있는지 확인
						if(isInBC(1, i)) {// 있다면 nextB로
							nextB=i;
							break;
						}
					}
					if(bcA!=nextA && bcB!=nextB) {//A,B 모두 다른 속한곳이 있다.
						if(BC[nextA][3]>=BC[nextB][3]) {//A다음 값이 B다음 값보다 크거나 같으면
							Charge(0, nextA, 1); //A는 다음 값으로
							Charge(1, bcB, 1); //B는 원래 값으로
						}else{//B의 다음 값이 더 크면
							Charge(0, bcA, 1);//A는 원래 값으로
							Charge(1, nextB, 1); //B는 다음 값으로
						}
					}else if(bcA!=nextA) {//A만 다른 곳에 속해 있으면
						Charge(0, nextA, 1);//A는 다른 곳으로
						Charge(1, bcB, 1);//B는 원래 값으로
					}else if(bcB!=nextB) {//B만 다른 곳에 속해 있어
						Charge(0, bcA, 1);//A는 원래 값
						Charge(1, nextB, 1);//B는 다음 값
					}
					else {//둘다 다음 값이 없어 그럼 나눠 가져
						Charge(0, bcA, 2);
						Charge(1, bcB, 2);
					}
				}else {//다른 곳에 있는 경우
					Charge(0,bcA,1);
					Charge(1,bcB,1);
				}
			}else if(bcB!=-1) {//B만 BC 범위에 있는 경우
				Charge(1,bcB,1);
			}else if(bcA!=-1) { //A만 BC에 있는 경우
				Charge(0,bcA,1);
			}
			move(cnt++);
		}while(cnt<=M);
	}
	
	//해당 유저의 BC기기 충전량 만큼 충전
	public static void Charge(int userNum, int bcNum, int devide) {
		sum[userNum]+=BC[bcNum][3]/devide;
	}
	
	public static int isInBC(int userNum) { //속해있는 가장 충전량이 큰 idx 반환
		//BC 목록 순회
		for(int i=0;i<A;i++) {
			//i번째 BC 범위 안에 있다면 가장 큰 출력의 해당 BC번호 출력
			if(Math.abs(posUser[userNum][0]-BC[i][0]) + Math.abs(posUser[userNum][1]-BC[i][1]) <= BC[i][2]) {
				return i;
			}
		}
		return -1;//범위에 있는게 없다면 -1반환
	}
	public static boolean isInBC(int userNum, int bcIdx) {
		//BC 목록 순회
		if(Math.abs(posUser[userNum][0]-BC[bcIdx][0]) + Math.abs(posUser[userNum][1]-BC[bcIdx][1]) <= BC[bcIdx][2]) {
			return true;
		}
		return false;//범위에 있는게 없다면 -1반환
	}
	
	
	
	//유저를 움직이는 함수
	public static void move(int time) {
		//유저 2명을 움직이기 위함
		for(int i=0;i<2;i++) {
			switch(moving[i][time]) {
			case 0:
				break;
			case 1: //1이면 위로
				posUser[i][0]--;
				break;
			case 2: //2면 우로
				posUser[i][1]++;
				break;
			case 3://3이면 아래로
				posUser[i][0]++;
				break;
			case 4://4면 좌로
				posUser[i][1]--;
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		//테스트 수
		int T = parseInt(br.readLine());
		//테케 반복
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine());
			//이동 시간 M, BC의 개수 A
			M = parseInt(st.nextToken());
			A = parseInt(st.nextToken());
			BC = new int[A][4]; //x, y, 범위, 성능
			moving = new int[2][M+1];
			posUser = new int[][]{{0,0},{9,9}};
			sum = new int[2];
			cnt = 0;
			//사용자 A와 B의 이동 정보
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					moving[i][j] = parseInt(st.nextToken());
				}
			}
			//BC 정보
			for(int i=0;i<A;i++) {
				st = new StringTokenizer(br.readLine());
				BC[i][1]=parseInt(st.nextToken())-1; //x좌표
				BC[i][0]=parseInt(st.nextToken())-1; //y좌표
				BC[i][2]=parseInt(st.nextToken()); //범위
				BC[i][3]=parseInt(st.nextToken()); //충전량
			}
			Arrays.sort(BC,(a,b)-> b[3]-a[3]);
			calMax();
			sb.append("#"+tc+" "+(sum[0]+sum[1])+"\n");
		}
		//최종 결과 출력
		System.out.println(sb.toString());
	}

}
