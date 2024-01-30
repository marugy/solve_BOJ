package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10026_적록색약 {
	
	static int N; //범위
	static char[][]map;
	static boolean[][][]visited; //방문 여부 0은 일반, 1은 색약
	static int[][] dir = {{1,0}, {-1,0},{0,1},{0,-1}};
	static int nomal;//정상인이 봤을때 영역 수
	static int cw;//색약인 사람이 봤을때 영역 수
	
	private static void colorWeakness(int type, int x, int y) {
		visited[type][x][y]=true;
		//사방탐색
		for(int d=0;d<4;d++) {
			int xx = x+ dir[d][0];
			int yy = y+ dir[d][1];
			
			//범위 벗어나면 통과
			if(!(0 <= xx && xx < N && 0 <= yy && yy < N)) continue;
			//일반 사람의 경우
			if(type==0) {//아직 확인 안했고 같은 색이면 재귀
				if(!visited[type][xx][yy] && map[x][y] == map[xx][yy]) {
					colorWeakness(type,xx,yy);
				}
			}else {//적록색약인 사람의 경우
				//아직 확인 안했고 색이 같거나 둘다 파랑이 아닌 경우 재귀
				if(!visited[type][xx][yy] && (map[x][y]==map[xx][yy] || (map[x][y]!='B'&& map[xx][yy]!='B'))) {
					colorWeakness(type,xx,yy);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//변수 할당 및 배열 초기화
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visited = new boolean[2][N][N];
		//배열 값 입력
		for(int i=0;i<N;i++)
			map[i]=br.readLine().toCharArray();
		//순회하면서 check
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[0][i][j]) {//정상의 경우 확인
					colorWeakness(0,i,j);
					nomal++;
				}
				if(!visited[1][i][j]) {//적록색약인 경우 확인
					colorWeakness(1,i,j);
					cw++;
				}
			}
		}
		//결과 출력
		System.out.println(nomal+" "+cw);
	}
}
