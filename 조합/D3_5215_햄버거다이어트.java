package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_5215_햄버거다이어트 {

	static int N; //재료의 수
	static int L; //제한 칼로리
	static int [][]foods; //재료 정보
	static boolean []isSelected;//사용 여부
	static int totalCal;//재료 총 칼로리
	
	static int maxTaste;//최대 맛점수
	static int tastesum;//현재 조합 맛 합
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//테스트케이스 수
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//재료의 수
			N = Integer.parseInt(st.nextToken());
			//제한칼로리
			L = Integer.parseInt(st.nextToken());
			
			//초기화
			foods = new int[N][2];
			isSelected = new boolean[N];
			maxTaste=Integer.MIN_VALUE;
			tastesum=0;
			totalCal=0;
			
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(br.readLine());
				//맛점수
				foods[i][0] = Integer.parseInt(st.nextToken());
				//칼로리
				foods[i][1] = Integer.parseInt(st.nextToken());
			}
			findBest(0);
			sb.append("#"+tc+" ").append(maxTaste).append("\n");
		}
		//결과출력
		System.out.println(sb.toString());
	}
	
	public static void findBest(int idx) {
		
		if(totalCal > L) {//마지막 재료를 추가해서 총 칼로리를 초과했다면
			if(maxTaste < tastesum-foods[idx-1][0]) {//뺀값으로 비교 후 return
				maxTaste = tastesum-foods[idx-1][0];
			}
			return;
		}else { //칼로리를 초과하지 않았을때 갱신
			if(maxTaste < tastesum) {
				maxTaste = tastesum;
			}
		}
		//재료 추가하며 재귀
		for(int i=idx;i<N;i++) {
			if(isSelected[i]) continue;
			isSelected[i]=true;
			tastesum+=foods[i][0];
			totalCal+=foods[i][1];
			
			findBest(i+1);
			
			totalCal-=foods[i][1];
			tastesum-=foods[i][0];
			isSelected[i]=false;
		}
	}
}
