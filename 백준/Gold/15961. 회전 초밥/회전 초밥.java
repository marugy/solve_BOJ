import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,d,k,c, dishes[], choice[];
	static int maxCnt = Integer.MIN_VALUE;
	
	static void countSushi() {
		int start = 0;
		int end = 0;
		int eatCnt = 0;//먹은 수
		int choiceCnt = 0; //선택 초밥 종류
		
		while(true) { //모든 경우의 수를 볼때까지 반복
			if(eatCnt<k) {//k개 선택할때까지
				eatCnt++;
				if(choice[dishes[end]]==0) {//처음 먹는 초밥이면 
					choiceCnt++;//초밥 종류 증가
				}
				choice[dishes[end]]++;//먹는 걸루
				end++;
				end%=N;
			}else {//k개 선택했으면 투 포인트 이동
				if(choice[c]==0) {//쿠폰 초밥을 안먹었으면 종류 추가
					if(maxCnt<choiceCnt+1) {//1개 더해서 갱신
						maxCnt=choiceCnt+1;
					}
				}else if(maxCnt<choiceCnt) {// 쿠폰 초밥을 이미 먹었으면 그냥 갱신 
					maxCnt=choiceCnt;
				}
				
				//시작 지점 이동
				if(choice[dishes[start]]==1) {//1개만 먹은거면 종류 감소
					choiceCnt--;
				}
				choice[dishes[start++]]--;//먹은 수 감소하고 이동
				if(start==N)
					break;

				if(choice[dishes[end]]==0)
					choiceCnt++;
				choice[dishes[end]]++;
				end++;
				end%=N;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//접시의 수
		N = Integer.parseInt(st.nextToken());
		dishes = new int[N];
		//초밥의 종류
		d = Integer.parseInt(st.nextToken());
		choice = new int[d+1];
		//연속해서 먹는 접시의 수
		k = Integer.parseInt(st.nextToken());
		//쿠폰 번호 (연속으로 k개 먹으면 c에 해당하는 초밥 공짜)
		c = Integer.parseInt(st.nextToken());
		//초밥 접시 입력
		for(int i=0;i<N;i++) {
			dishes[i]=Integer.parseInt(br.readLine());
		}
		countSushi();
		System.out.println(maxCnt);
	}
}
