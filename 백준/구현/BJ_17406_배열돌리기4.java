package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_17406_배열돌리기4 {
	
	static int N;
	static int M;
	static int K;
	static int[][]arr;//배열
	static int[][]kArr;//회전 정보를 담을 배열
	static boolean[]isUsed;//사용한 회전정보인지
	static int minSum=Integer.MAX_VALUE;
	static int sum;
	public static void makeTurn(int[][]array, int count) {
		//k번의 회전을 수행하면
		if(count==K) {
			//행별 최소합을 구하고
			int minLow=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				int sumLow=0;
				for(int j=0;j<M;j++) {
					sumLow+=array[i][j];
				}
				if(minLow>sumLow) {
					minLow=sumLow;
				}
			}
			//경우의 수의 최소합이 모든 경우의 수의 최소인지 확인하고 갱신
			if(minSum > minLow) {
				minSum=minLow;
			}
			return;
		}
		//연산 순서 조합
		for(int i=0;i<K;i++) {
			if(isUsed[i])continue;//사용된 연산은 pass
			isUsed[i]=true;
			//배열을 연산에 넣어 돌리고 결과배열로 재귀
			makeTurn(turnArr(array, kArr[i][0],kArr[i][1],kArr[i][2]), count+1);
			isUsed[i]=false;
		}
	}
	
	public static int[][] turnArr(int[][] array,int r, int c, int s) {
		//입력받은 배열 복사
		int[][]temp = new int[N][M];
		for(int i=0;i<N;i++) {
			temp[i]=Arrays.copyOf(array[i],M);
		}
		
		//변경 시작
		for(int x= r-s, y=c-s; x<r; x++,y++,s--) {
			//이동하며 값을 변경할 위치
			int startX;
			int startY;
			int startVal = temp[x][y];
			//왼라인 움직이기
			for(startX=x; startX < x+2*s; startX++) {
				temp[startX][y]=temp[startX+1][y];
			}
			//아래 라인 움직이기
			for(startY=y; startY < y+2*s; startY++) {
				temp[startX][startY]=temp[startX][startY+1];
			}
			// 오른쪽 움직이기
			for(;startX > x; startX--) {
				temp[startX][startY]=temp[startX-1][startY];
			}
			//윗라인 움직이기
			for(; startY > y+1; startY--) {
				temp[startX][startY]=temp[startX][startY-1];
			}
			//처음 값 집어넣기
			temp[startX][startY]=startVal;
		}
		//움직인 배열 반환
		return temp;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//값 입력 받기
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		//배열 생성
		arr=new int[N][M];
		kArr=new int[K][3];
		isUsed=new boolean[K];
		//배열 입력받기
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//회전 정보 입력
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			kArr[i][0]=Integer.parseInt(st.nextToken())-1;
			kArr[i][1]=Integer.parseInt(st.nextToken())-1;
			kArr[i][2]=Integer.parseInt(st.nextToken());
		}
		//회전 및 최소값 찾기
		makeTurn(arr,0);
		//결과 출력
		System.out.println(minSum);
	}
}
