package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935_배열돌리기3_신규람 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	//1번 실행 위 아래 바꾸기
	public static void upDown() {
		int[][] resultArr = new int[N][M];
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<M;j++)
				resultArr[N-1-i][j] = arr[i][j];
		}
		arr=resultArr;
	}
	//2번 실행 좌우 반전
	public static void leftRight() {
		int[][] resultArr = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=M-1;j>=0;j--)
				resultArr[i][M-1-j] = arr[i][j];
		}
		arr=resultArr;
	}
	//3번 실행 상하 반전
	public static void turnRight() {
		int[][] resultArr = new int[M][N];
		for(int j=0;j<M;j++) {
			for(int i=N-1;i>=0;i--)
				resultArr[j][N-1-i] = arr[i][j];
		}
		arr=resultArr;
		int tmp = N;
		N = M;
		M = tmp;
	}
	//4번 실행 왼쪽 돌리기
	public static void turnLeft() {
		int[][] resultArr = new int[M][N];
		for(int j=M-1;j>=0;j--) {
			for(int i=0;i<N;i++)
				resultArr[M-1-j][i] = arr[i][j];
		}
		arr=resultArr;
		int tmp = N;
		N = M;
		M = tmp;
	}
	//5번 시계방향 옮기기
	public static void splitRight() {
		int[][] resultArr = new int[N][M];
		//1 -> 2
		for(int i=0;i<N/2;i++) {
			for(int j=0;j<M/2;j++)
				resultArr[i][j+M/2] = arr[i][j];
		}
		// 2-> 3
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++)
				resultArr[i+N/2][j] = arr[i][j];
		}
		//3->4
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++)
				resultArr[i][j-M/2] = arr[i][j];
		}
		//4->1
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++)
				resultArr[i-N/2][j] = arr[i][j];
		}
		arr=resultArr;
	}
	//6번 반시계 옮기기
	public static void splitLeft() {
		int[][] resultArr = new int[N][M];
		//1->4
		for(int i=0;i<N/2; i++) {
			for(int j=0;j<M/2; j++) {
				resultArr[i+N/2][j] = arr[i][j];
			}
		}
		//4->3
		for(int i=N/2;i<N;i++) {
			for(int j=0;j<M/2;j++)
				resultArr[i][j+M/2] = arr[i][j];
		}
		//3->2
		for(int i=N/2;i<N;i++) {
			for(int j=M/2;j<M;j++)
				resultArr[i-N/2][j] = arr[i][j];
		}
		//2->1
		for(int i=0;i<N/2;i++) {
			for(int j=M/2;j<M;j++)
				resultArr[i][j-M/2] = arr[i][j];
		}
		arr=resultArr;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 값 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		// 배열 선언
		arr = new int[N][M];
		// 배열 값 입력받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		//명령어 수행하기
		for (int i = 0; i < R; i++) {
			switch (Integer.parseInt(st.nextToken())) {
			case 1:
				upDown();
				break;
			case 2:
				leftRight();
				break;
			case 3:
				turnRight();
				break;
			case 4:
				turnLeft();
				break;
			case 5:
				splitRight();
				break;
			case 6:
				splitLeft();
				break;
			}
		}
		//결과 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
