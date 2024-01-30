package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630_색종이만들기 {
	//배열과 색종이 수
	static int [][]arr;
	static int blueCnt = 0;
	static int whiteCnt = 0;
	
	public static void checkPaper(int size, int startX, int startY) {// 체크할 색종이 사이즈, 시작 위치
		//모두 색종이인지 여부
		boolean pass = true;
		//시작 위치 색종이
		int a = arr[startX][startY];

		for(int i = startX; i < startX + size; i++) {
			for(int j = startY; j < startY + size; j++) {
				if(arr[i][j]!=a) {//다른 색이 나오면 중단
					pass=false;
					break;
				}
			}
		}
		if(pass&&a==1) { //한가지 색이고 1일 경우 파란색 추가
			blueCnt++;
		}
		else if(pass&&a==0) {//한가지 색이고 0일경우 흰색 추가
			whiteCnt++;
		}
		else {
			checkPaper(size/2,startX,startY);//2사분면 검사
			checkPaper(size/2,startX,startY+size/2);//1사분면 검사
			checkPaper(size/2,startX+size/2,startY);//3사분면 검사
			checkPaper(size/2,startX+size/2,startY+size/2);//4사분면 검사
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//색종이 변 길이 입력
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		//색종이 정보 입력
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//색종이 check
		checkPaper(n,0,0);
		//결과출력
		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}
}

