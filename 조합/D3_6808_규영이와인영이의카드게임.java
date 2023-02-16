package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_6808_규영이와인영이의카드게임_신규람 {

	static int []gyu; //규영이 카드
	static boolean []totalCard;//총카드
	static int totalWin; //총 승리 수
	static int totalLose;//총 패배 수
	static int gyuScore;//규영이 점수
	static int inScore;//인영이 점수
	
	public static void play(int count) {
		if(count==9) { //9번승부가 끝나면 결과 확인
			if(gyuScore>inScore) //규영이가 이겼을때
				totalWin++;
			else if(gyuScore<inScore)//규영이가 졌을때
				totalLose++;
			return;
		}
		
		for(int i=1;i<19;i++) {
			if(totalCard[i]==true) continue;//아직 사용하지 않은 카드만 인영이가 사용가능
			
			totalCard[i]=true;
			if(gyu[count+1]>i) {//규영이가 이겼을떄
				gyuScore+=gyu[count+1]+i;
				play(count+1);
				gyuScore-=gyu[count+1]+i;
			}else if(i>gyu[count+1]) {//규영이가 졌을떄
				inScore+=gyu[count+1]+i;
				play(count+1);
				inScore-=gyu[count+1]+i;
			}else//비겼을때
				play(count+1);
			totalCard[i]=false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//값 초기화
			gyu = new int[10];
			totalCard = new boolean[19];
			
			totalWin=0;
			totalLose=0;
			
			gyuScore=0;
			inScore=0;
			//카드 입력 받으면서 규영이 카드는 true로
			for(int i=1;i<=9;i++) {
				gyu[i]=Integer.parseInt(st.nextToken());
				totalCard[gyu[i]]=true;
			}
			//게임 진행
			play(0);
			sb.append("#"+tc+" "+totalWin +" "+ totalLose+"\n");
		}
		//결과 출력
		System.out.println(sb.toString());
	}
}
