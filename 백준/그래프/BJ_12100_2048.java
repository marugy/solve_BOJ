package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12100_2048 {

	static int N;
	static int totalMax = Integer.MIN_VALUE;

	static void play(int[][] arr, int count) {
		// 5번 이동을 수행 했다면 최댓값을 찾고 종료
		if (count == 5) {
			int max = findMax(arr);
			if (max > totalMax)
				totalMax = max;
			return;
		}
		// 깊은 복사
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			copy[i] = arr[i].clone();
		}
		//각 방향이동 재귀 시작
		play(moveTop(copy), count + 1);
		play(moveRight(copy), count + 1);
		play(moveBottom(copy), count + 1);
		play(moveLeft(copy), count + 1);
	}

	static int[][] moveTop(int[][] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<>());

		for(int j=0;j<N;j++) {
			for(int i=N-1;i>=0;i--)
				if(arr[i][j]!=0)
					list.get(j).add(arr[i][j]);//열 기준 숫자 채우기
		}
		for(int j=0;j<N;j++) {
			for(int i=list.get(j).size()-1;i>=1; i--) {
				if(list.get(j).get(i).equals(list.get(j).get(i-1))) {
					list.get(j).set(i-1, list.get(j).get(i)*2);
					list.get(j).remove(i);
					i--;
				}
			}
		}
		int [][]temp = new int[N][N];
		for(int i=0;i<N;i++) {
			for (int j = 0; j < N; j++) {
				if(list.get(i).size()!=0) {
					temp[j][i] = list.get(i).get(list.get(i).size()-1);
					list.get(i).remove(list.get(i).size()-1);
				}
			}
		}
		return temp;
	}

	static int[][] moveRight(int[][] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<>());

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				if(arr[i][j]!=0)
					list.get(i).add(arr[i][j]);//열 기준 숫자 채우기
		}
		for(int j=0;j<N;j++) {
			for(int i=list.get(j).size()-1;i>=1; i--) {
				if(list.get(j).get(i).equals(list.get(j).get(i-1))) {
					list.get(j).set(i-1, list.get(j).get(i)*2);
					list.get(j).remove(i);
					i--;
				}
			}
		}
		int [][]temp = new int[N][N];
		for(int i=0;i<N;i++) {
			for (int j = N-1; j >=0; j--) {
				if(list.get(i).size()!=0) {
					temp[i][j] = list.get(i).get(list.get(i).size()-1);
					list.get(i).remove(list.get(i).size()-1);
				}
			}
		}
//		for(int i=0; i<N;i++)
//			System.out.println(Arrays.toString(temp[i]));
		return temp;
	}

	static int[][] moveBottom(int[][] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<>());

		for(int j=0;j<N;j++) {
			for(int i=0;i<N;i++)
				if(arr[i][j]!=0)
					list.get(j).add(arr[i][j]);//열 기준 숫자 채우기
		}
		for(int j=0;j<N;j++) {
			for(int i=list.get(j).size()-1;i>=1; i--) {
				if(list.get(j).get(i).equals(list.get(j).get(i-1))) {
					list.get(j).set(i-1, list.get(j).get(i)*2);
					list.get(j).remove(i);
					i--;
				}
			}
		}
		int [][]temp = new int[N][N];
		for(int j=0;j<N;j++) {
			for (int i = N-1; i>=0; i--) {
				if(list.get(j).size()!=0) {
					temp[i][j] = list.get(j).get(list.get(j).size()-1);
					list.get(j).remove(list.get(j).size()-1);
				}
			}
		}
//		for(int i=0; i<N;i++)
//			System.out.println(Arrays.toString(temp[i]));
		return temp;
	}

	static int[][] moveLeft(int[][] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(new ArrayList<>());

		for(int i=0;i<N;i++) {
			for(int j=N-1;j>=0;j--)
				if(arr[i][j]!=0)
					list.get(i).add(arr[i][j]);//열 기준 숫자 채우기
		}
		for(int j=0;j<N;j++) {
			for(int i=list.get(j).size()-1;i>=1; i--) {
				if(list.get(j).get(i).equals(list.get(j).get(i-1))) {
					list.get(j).set(i-1, list.get(j).get(i)*2);
					list.get(j).remove(i);
					i--;
				}
			}
		}
		int [][]temp = new int[N][N];
		for(int i=0;i<N;i++) {
			for (int j = 0; j <N; j++) {
				if(list.get(i).size()!=0) {
					temp[i][j] = list.get(i).get(list.get(i).size()-1);
					list.get(i).remove(list.get(i).size()-1);
				}
			}
		}
//		for(int i=0; i<N;i++)
//			System.out.println(Arrays.toString(temp[i]));
		return temp;
	}

	// 배열의 가장 큰 값 찾기
	static int findMax(int[][] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play(arr, 0);
		System.out.println(totalMax);
	}

}

