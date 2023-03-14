package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16197_두동전 {

	static int N;
	static int M;
	static char[][] board;
	static int [][]coin = new int[2][2];
	static int minCount = Integer.MAX_VALUE;
	static int [][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void count(int cnt) {
		//기저조건
		if(cnt>10) {
			return;
		}
		
		for(int i=0;i<4;i++) {
			int x1 = coin[0][0] + dir[i][0];
			int y1 = coin[0][1] + dir[i][1];
			int x2 = coin[1][0] + dir[i][0];
			int y2 = coin[1][1] + dir[i][1];
			
			if(fallOnlyOne(x1,y1,x2,y2)) {
				if(minCount > cnt)
					minCount = cnt;
				return;
			}
			
			if(!(0<=x1 && x1<N && 0<= y1 && y1 < M) && !(0<=x2 && x2<N && 0<= y2 && y2 < M)) continue;
			
			if(board[x1][y1]!='#') {
				coin[0][0] += dir[i][0];
				coin[0][1] += dir[i][1];
			}
			if(board[x2][y2]!='#') {
				coin[1][0] += dir[i][0];
				coin[1][1] += dir[i][1];
			}
			count(cnt+1);
			if(board[x1][y1]!='#') {
				coin[0][0] -= dir[i][0];
				coin[0][1] -= dir[i][1];
			}
			if(board[x2][y2]!='#') {
				coin[1][0] -= dir[i][0];
				coin[1][1] -= dir[i][1];
			}
		}
	}
	
	static boolean fallOnlyOne(int x1, int y1, int x2, int y2){
		if(!(0<=x1 && x1<N && 0<=y1 && y1<M) ^ !(0<=x2 && x2<N && 0<=y2 && y2<M))
			return true;
		else return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		//board 값 입력받기
		int coinNum = 0;
		for(int i=0;i<N;i++) {
			board[i]=br.readLine().toCharArray();
			if(coinNum < 2) {
				//동전 위치 저장하기
				for(int j=0;j<M;j++) {
					if(board[i][j]=='o') {
						coin[coinNum][0]=i;
						coin[coinNum++][1]=j;
					}
				}
			}
		}
		//계산 실시
		count(1);
		//결과 출력
		if(minCount==Integer.MAX_VALUE)
			minCount = -1;
		System.out.println(minCount);
	}
}