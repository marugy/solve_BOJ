package bj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6987_월드컵 {
	
	static int win[],lose[],draw[],t1[],t2[];
	static boolean avail;
	
	static void dfs(int idx) {
		if(avail) return;
		//depth가 15경기라면
		if(idx==15) {
			avail=true;//경기가 가능한 것
			return;
		}
		int a = t1[idx]; //첫번째 매칭 team1
		int b= t2[idx]; //첫번째 매칭 상대 team2
		
		//a가 이기는 경우
		if(win[a]>0 && lose[b]>0) {
			win[a]--;
			lose[b]--;
			dfs(idx+1);
			win[a]++;
			lose[b]++;
		}
		//a와 b가 비기는 경우
		if(draw[a]>0 && draw[b]>0) {
			draw[a]--;
			draw[b]--;
			dfs(idx+1);
			draw[a]++;
			draw[b]++;
		}
		//a가 지는 경우
		if(lose[a]>0 && win[b]>0) {
			lose[a]--;
			win[b]--;
			dfs(idx+1);
			lose[a]++;
			win[b]++;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt=0;
		//경기를 하는 두 팀
		t1 = new int[15];
		t2 = new int[15];
		//15개의 매칭 생성
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<6;j++) {
				t1[cnt]=i;
				t2[cnt++]=j;
			}
		}
		//4가지 정보 입력받기
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//배열 초기화
			win = new int[6];		
			lose = new int[6];		
			draw = new int[6];	
			avail=false;		
			//초기값 조건 확인
			int w=0,l=0,d=0;
			for(int j=0;j<6;j++) {
				w += win[j] = Integer.parseInt(st.nextToken());
				d += draw[j] = Integer.parseInt(st.nextToken());
				l += lose[j] = Integer.parseInt(st.nextToken());
			}
			//총경기의 합이 30이 아니면 잘못된 것
			if(w+d+l!=30)
				avail=false;
			else//정상 경기 수라면 dfs 진행
				dfs(0);
			//결과 입력하기
			if(avail) sb.append(1+" ");
			else sb.append(0+" ");
		}
		System.out.println(sb.toString());
	}
}
