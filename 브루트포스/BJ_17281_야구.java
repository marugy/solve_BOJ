package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17281_야구 {
	static int N;
	static int[][] bp;
	static int[] order;
	static boolean[] isCheck;
	static int maxScore = Integer.MIN_VALUE;
	
	static void play() {
		order = new int[10]; // 타석 순서
		order[4]=1;//4번째는 1번 선수
		isCheck = new boolean[10]; //idx 선수가 뽑혔는지
		isCheck[1]=true;//1번 기용
		makeTeam(1);//순서 만들기
	}
	static void makeTeam(int count) {
		if(count==4) {//4번째 선수는 이미 뽑았으니 생략
			makeTeam(5);
			return;
		}
		if(count==10) {//다 뽑았으면 점수 계산
			countScore();
			return; 
		}
		for(int i=1;i<=9;i++) {//선수 선택하기
			if(!isCheck[i]) {//선택 되지 않으면 
				isCheck[i]=true;
				order[count]=i;
				makeTeam(count+1);//반복
				isCheck[i]=false;
			}
		}
	}
	static void countScore() {
		int now = 1;
		int score = 0;
		for(int inning=0;inning<N;inning++) { //이닝 수만큼 반복
			int out = 0;
			boolean []arr = new boolean[3];
			while(out<3) {//3아웃이면 종료
				if(bp[inning][order[now]]==1) { //안타이면
					boolean last = arr[2];
					arr[2]=arr[1];
					arr[1]=arr[0];
					arr[0]=true;
					if(last)
						score++;
				}
				else if(bp[inning][order[now]]==2) {//2루타
					if(arr[2]) {
						score++;
						arr[2]=false;
					}
					if(arr[1]) {
						score++;
						arr[1]=false;
					}
					if(arr[0]) {
						arr[2]=true;
						arr[0]=false;
					}
					arr[1]=true;
				}
				else if(bp[inning][order[now]]==3) {//3루타
					if(arr[2]) {
						score++;
						arr[2]=false;
					}
					if(arr[1]) {
						score++;
						arr[1]=false;
					}
					if(arr[0]) {
						score++;
						arr[0]=false;
					}
					arr[2]=true;
				}
				else if(bp[inning][order[now]]==4) {//홈런
					for(int i=0;i<3;i++) {
						if(arr[i])
							score++;
						arr[i]=false;
					}
					score++;
				}
				else out++;//아웃
				//현재 타격 타자
				now++; 
				if(now==10)
					now = 1;
			}
		}
		//갱신
		if(score>maxScore)
			maxScore =score;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		// 입력
		N = Integer.parseInt(br.readLine());
		bp = new int[N][10];
		// 점수 입력 받기
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++)
				bp[i][j]=Integer.parseInt(st.nextToken());
		}
		//게임 진행
		play();
		//결과 출력
		System.out.println(maxScore);
	}
}
