package swea;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_상호의배틀필드 {
	
	static char[][]map;
	static int H;
	static int W;
	static int tankX;
	static int tankY;
	
	public static void play(char c) { //명령어에 따라 명령 수행
		switch(c) {
		case 'U': //U인 경우 위로 돌리고 이동할 수 있으면 이동
			map[tankX][tankY]='^';
			if(0<=tankX-1 && map[tankX-1][tankY]=='.') {
				map[tankX--][tankY]='.';
				map[tankX][tankY]='^';
			}
			break;
		case 'D'://D인 경우 아래로 돌리고 이동할 수 있으면 이동
			map[tankX][tankY]='v';
			if(tankX+1 < H && map[tankX+1][tankY]=='.') {
				map[tankX++][tankY]='.';
				map[tankX][tankY]='v';
			}
			break;
		case 'L'://L인 경우 왼쪽으로 돌리고 이동할 수 있으면 이동
			map[tankX][tankY]='<';
			if(0<=tankY-1 && map[tankX][tankY-1]=='.') {
				map[tankX][tankY--]='.';
				map[tankX][tankY]='<';
			}
			break;
		case 'R'://R인 경우 오른쪽으로 돌리고 이동할 수 있으면 이동
			map[tankX][tankY]='>';
			if(tankY+1 < W && map[tankX][tankY+1]=='.') {
				map[tankX][tankY++]='.';
				map[tankX][tankY]='>';
			}
			break;
		case 'S'://S인 경우 방향에 따라 포탄 발사
			if(map[tankX][tankY]=='^') {//위로 발사
				int bullet = tankX-1;
				while(0<=bullet) {
					if(map[bullet][tankY]=='#')
						break;
					else if(map[bullet][tankY]=='*') {
						map[bullet][tankY]='.';
						break;
					}else
						bullet--;
				}
				
			}else if(map[tankX][tankY]=='v') {//아래로 발사
				int bullet = tankX+1;
				while(bullet<H) {
					if(map[bullet][tankY]=='#')
						break;
					else if(map[bullet][tankY]=='*') {
						map[bullet][tankY]='.';
						break;
					}else
						bullet++;
				}
			}else if(map[tankX][tankY]=='<') {
				int bullet = tankY-1;
				while(0<=bullet) {
					if(map[tankX][bullet]=='#')
						break;
					else if(map[tankX][bullet]=='*') {
						map[tankX][bullet]='.';
						break;
					}else
						bullet--;
				}
			}else if(map[tankX][tankY]=='>') {
				int bullet = tankY+1;
				while(bullet<W) {
					if(map[tankX][bullet]=='#')
						break;
					else if(map[tankX][bullet]=='*') {
						map[tankX][bullet]='.';
						break;
					}else
						bullet++;
				}
			}
			break;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int T = parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			//값 입력받기
			H = parseInt(st.nextToken());
			W = parseInt(st.nextToken());
			//전장 정보를 저장할 배열
			map = new char[H][W];
			//전장 정보 입력
			for(int i=0;i<H;i++) {
				map[i]=br.readLine().toCharArray();
			}
			//탱크 좌표 찾기
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++)
					if(map[i][j]=='^'||map[i][j]=='<'||map[i][j]=='>'||map[i][j]=='v') {
						tankX = i;
						tankY = j;
						break;
					}
			}
			//명령어 길이 입력
			int N = parseInt(br.readLine());
			//명령 수행
			char []ch = br.readLine().toCharArray();
			//명령어 수행하기
			
			for(char c : ch) {
				play(c);
			}
			//결과 저장
			sb.append("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}