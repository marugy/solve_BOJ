import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[][]paper = null;
	static boolean[][]visited = null;
	static int[][]dir = {{1,0},{-1,0},{0,1},{0,-1}};
	static int maxSum = Integer.MIN_VALUE;
	
	static void dfs(int x, int y, int sum, int cnt) {
		//4개일때 최대값 확인, 갱신
		if(cnt==4) {
			maxSum=Math.max(maxSum, sum);
			return;
		}
		//사방탐색
		for(int d=0;d<4;d++) {
			int xx = x + dir[d][0];
			int yy = y + dir[d][1];
			//예외
			if(!(0<=xx && xx<N && 0<=yy && yy<M)) continue;
			
			if(!visited[xx][yy]) {
				//ㅗ모양을 위해서 방문 처리 후 제자리 재귀
				if(cnt==2) {
					visited[xx][yy] = true;
					dfs(x,y,sum+paper[xx][yy],cnt+1);
					visited[xx][yy] = false;
				}
				visited[xx][yy] = true;
				dfs(xx,yy,sum+paper[xx][yy],cnt+1);
				visited[xx][yy] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 종이 사이즈 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];
		
		//종이 정보 입력받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				paper[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//dfs로 테트로미노 확인
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j]=true;
				dfs(i,j,paper[i][j],1);
				visited[i][j]=false;
			}
		}
		//결과 출력
		System.out.println(maxSum);
	}
}
