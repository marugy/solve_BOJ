package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D5_1247_최적경로 {
	
	static int N; //고객
	static int [][]arr;//위치
	static boolean []customer;//방문 여부
	static int minDis;//최소거리
	static int dis;//현재이동거리
	static int cX;
	static int cY;
	static int hX;
	static int hY;
	
	public static void DFS(int count, int now) {
		//모든 고객을 방문했다면 집까지 가는 거리를 더하고 최소값 갱신
		if(count == N) {
			dis+=Math.abs(arr[now][0]-arr[1][0])+Math.abs(arr[now][1]-arr[1][1]);
			if(minDis>dis)
				minDis=dis;
			dis-=Math.abs(arr[now][0]-arr[1][0])+Math.abs(arr[now][1]-arr[1][1]);
			return;
		}
		for(int i=2;i<N+2;i++) {
			//아직 방문 안했다면 거리 추가 후 재귀
			if(customer[i]==false) {
				customer[i]=true;
				dis+=Math.abs(arr[now][0]-arr[i][0])+Math.abs(arr[now][1]-arr[i][1]);
				DFS(count+1, i);
				dis-=Math.abs(arr[now][0]-arr[i][0])+Math.abs(arr[now][1]-arr[i][1]);
				customer[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		//테스트 수
		int T = Integer.parseInt(br.readLine());
		//테케 반복
		for (int tc = 1; tc <= T; tc++) {
			//고객 수
			N = Integer.parseInt(br.readLine());
			customer = new boolean[N+2];
			minDis = Integer.MAX_VALUE;
			dis = 0;

			st = new StringTokenizer(br.readLine());
			
			//첫 위치 회사, 1번부터 고객
			arr = new int[N+2][2];
			
			//입력 받기
			for(int i=0;i<N+2;i++) {
				arr[i][0]=Integer.parseInt(st.nextToken());
				arr[i][1]=Integer.parseInt(st.nextToken());
			}
			//실행 및 결과 추가
			DFS(0,0);
			sb.append("#"+tc+" "+minDis+"\n");
		}
		//최종 결과 출력
		System.out.println(sb.toString());
	}
}
