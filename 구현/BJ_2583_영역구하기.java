package bj;

import static java.lang.Integer.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2583_영역구하기 {

	static int M;
	static int N;
	static int [][]arr;//모눈종이
	static int [][]dir= {{1,0},{-1,0},{0,1},{0,-1}};//사방 탐색
	static int count = 0;
	static ArrayList<Integer> areaList = new ArrayList<>();// 나머지 부분 넓이 리스트
	
	public static class Pos{ //x,y 좌표를 저장할 class
		int x;
		int y;
		public Pos(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
	public static void BFS(int x, int y) {
		arr[x][y]=1; //시작점 1로 만들고
		count++;//영역 수 증가
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(x,y));
		int area = 1;//넓이 1
		while(!q.isEmpty()) { //영역 채우기 시작
			Pos tmp = q.poll();
			for(int i=0;i<4;i++) {
				int xx = tmp.x+dir[i][0];
				int yy = tmp.y+dir[i][1];
				if(0<=xx && xx<M && 0<=yy && yy<N && arr[xx][yy]==0) {
					arr[xx][yy]=1;
					area++;
					q.add(new Pos(xx,yy));
				}
			}
		}
		areaList.add(area);//최종 넓이 추가
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//M,N입력
		M = parseInt(st.nextToken());
		N = parseInt(st.nextToken());
		//배열 선언
		arr = new int[M][N];
		//K개 직사각형 입력
		int K = parseInt(st.nextToken());
		for (int idx = 0; idx < K; idx++) {
			st = new StringTokenizer(br.readLine());
			int y1 = parseInt(st.nextToken());
			int x1 = parseInt(st.nextToken());
			int y2 = parseInt(st.nextToken())-1;
			int x2 = parseInt(st.nextToken())-1;
			//사각형 내부 채우기
			for(int i=x1;i<=x2;i++) {
				for(int j=y1;j<=y2;j++)
					arr[i][j]=1;
			}
		}
		//나머지 부분 BFS
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++)
				if(arr[i][j]==0) {
					BFS(i,j);
				}
		}
		//count 출력
		System.out.println(count);
		//영역 오름차순 정렬
		areaList.sort((a,b)->a-b);
		//넓이 출력
		for(int x: areaList)
			System.out.print(x+" ");
		
	}
}
