package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3109_빵집 {

	static int R;
	static int C;
	static char [][]map;
	static boolean [][]visited;
	static int pipe;
	static int [][]dir= {{-1,1},{0,1},{1,1}};

	public static boolean makePipe(int x, int y) {
		//끝에 도달하면 true 파이프 증가, true반환
		if(y==C-1) {
			pipe++;
			return true;
		}
		while(canMove(x,y)) { //움직일 수 있을때 반복
			for(int d=0;d<3;d++) {
				int xx = x + dir[d][0];
				int yy = y + dir[d][1];
				if(0<=xx && xx<R && 0<=yy && yy<C && map[xx][yy]!='x' && visited[xx][yy]==false) {
					visited[xx][yy] = true;//xx,yy true로
					if(makePipe(xx,yy)) //재귀 및 끝이라면 true 반환
						return true;
				}
			}
		}
		return false;//그 외 false 반환
	}
	//움직일 수 있는지 확인하는 함수
	public static boolean canMove(int i, int j) {
		for(int d=0;d<3;d++) {
			int x = i + dir[d][0];
			int y = j + dir[d][1];
			if(0<=x && x<R && 0<=y && y<C && map[x][y]!='x' && visited[x][y]==false)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		//초기화
		map = new char[R][C];
		visited = new boolean[R][C];
		//값 입력
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine());
			map[i]=st.nextToken().toCharArray();
		}
		//행별로 함수 실행
		for(int i=0;i<R;i++) {
			makePipe(i,0);
		}
		//결과 수행
		System.out.println(pipe);
	}
}
