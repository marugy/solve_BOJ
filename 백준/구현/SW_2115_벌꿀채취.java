package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취 {

	static int N;
	static int M;
	static int C;
	static int [][]map; //벌통 정보
	static boolean [][]isget;//벌통 선택 여부
	static int [][]container;// 선택한 벌통
	static boolean [][]isCount;// 벌통 계산 선택 여부
	static int []answer; //일꾼 두명의 최댓값을 담을 배열
	static int maxHoney;
	
	//채취 시작하기
	static void start(int count) {
		if(count == 2) { //2마리 다 잡았으면
			answer = new int[2];
			countMax(0,0);
			countMax(1,0);
			if(maxHoney < answer[0]+answer[1]) {
				maxHoney = answer[0]+answer[1];
			}
			return;
		}
		for(int i=0; i<N; i++) { // 벌통 선택
			for(int j=0; j<=N-M; j++) {
				if(isPos(i,j)) {
					getCon(i,j,count); //벌통 선택으로 바꾸기
					start(count+1);
					putCon(i,j);//벌통 선택 해제
				}
			}
		}
	}
	//M만큼 벌통 선택이 가능한지 확인
	static boolean isPos(int x, int y) {
		for(int j=y; j< y+M; j++) {
			if(isget[x][j])
				return false;
		}
		return true;
	}
	//벌통 선택하기, 해당 벌통 꿀 정보 담기
	static void getCon(int x, int y, int worker) {
		for(int j=y; j< y+M; j++) {
			isget[x][j]=true;
			container[worker][j-y]=map[x][j];
		}
	}
	//벌통 해제하기
	static void putCon(int x, int y) {
		for(int j=y; j< y+M; j++) {
			isget[x][j]=false;
		}
	}
	//벌통 별로 최대 수 계산하기
	static void countMax(int worker, int sum) {
		if(sum>C) return; // C를 넘어가면 재껴
		if(sum<=C) { // C를 넘어가지 않는 선택일 시에
			int nowSum = 0;
			for(int i=0; i<M; i++) {//해당 선택들의 제곱의 합을 구하고
				if(isCount[worker][i])
					nowSum+=Math.pow(container[worker][i], 2); 
			}
			if(answer[worker] < nowSum) {//크다면 갱신
				answer[worker] = nowSum;
			}
		}
		for(int i=0;i<M;i++) { //선택한 벌통 중 꿀 채취하기
			if(isCount[worker][i]) continue;
			isCount[worker][i]=true;
			countMax(worker,sum+container[worker][i]);
			isCount[worker][i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			//값 입력 받기
			N = Integer.parseInt(st.nextToken()); // 벌통 크기
			M = Integer.parseInt(st.nextToken()); // 선택 벌통 개수
			C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
			map = new int[N][N];
			isget = new boolean[N][N];
			maxHoney = Integer.MIN_VALUE;
			container = new int[2][M];
			isCount = new boolean[2][M];
			// 벌통 정보 입력 받기
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++)
					map[i][j]=Integer.parseInt(st.nextToken());
			}
			//꿀 구하기
			start(0);
			//결과 출력
			sb.append(maxHoney).append("\n");
		}
		System.out.println(sb.toString());
	}
}