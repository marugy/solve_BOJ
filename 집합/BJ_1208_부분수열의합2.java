package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class BJ_1208_부분수열의합2 {

	static int n;
	static int s;
	static long cnt = 0;
	static long[] arr;
	static ArrayList<Long> leftList = new ArrayList<>(); // 왼쪽 부분 합 저장
	static ArrayList<Long> rightList = new ArrayList<>();// 오른쪽 부분 합 저장
	
	static void getSubSet(int start, int end, long sum, ArrayList<Long> list) {
		if(start==end) {//끝에 도달하면 합 추가
			list.add(sum);
			return;
		}
		getSubSet(start+1,end,sum+arr[start],list);//현재 선택
		getSubSet(start+1,end,sum,list);//현재 선택 X
	}
	static void calSum() {
		int l = 0; //왼쪽 배열 포인터
		int r = rightList.size()-1;//오른쪽 배열 포인터
		
		while(l<leftList.size() && 0<=r) {//양 쪽 배열 더하기
			Long sum = leftList.get(l) + rightList.get(r);//투 포인트 합
			if(sum == s) {//합이 s라면
				Long a = leftList.get(l);
				int lCnt = 0;
				while(l<leftList.size() && leftList.get(l)==a) {//왼쪽 배열의 같은 갯수 세기
					l++;
					lCnt++;
				}
				Long b = rightList.get(r);
				int rCnt = 0;
				while(0 <= r && rightList.get(r)==b) {//오른쪽 배열의 같은 갯수 세기
					r--;
					rCnt++;
				}
				cnt+=lCnt*rCnt;//각 갯수의 곱을 더해준다
			}else if (sum < s) {//합보다 작으면 l 증가
				l++;
			}else {//합보다 크면 r감소
				r--;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//n, s 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		//배열 선언
		arr = new long[n];
		//배열 값 입력 받기
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		getSubSet(0,n/2,0, leftList);//왼쪽 배열의 부분 집합
		getSubSet(n/2,n,0, rightList);//오른쪽 배열의 부분 집합
		
		Collections.sort(leftList);// 왼쪽 배열 정렬
		Collections.sort(rightList);// 오른쪽 배열 정렬
		//합 계산
		calSum();
		//결과 출력
		if(s==0)//0이면 공집합도 포합되므로 -1
			cnt--;
		System.out.println(cnt);
	}
}

