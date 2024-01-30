package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {
	
	static char[]arr;
	static boolean[]visited;
	static int L;
	static int C;
	
	static int consonants;
	static int vowels;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<String> list = new ArrayList<>();
	
	private static void make(int count,char last) {
		//갯수 채우면 출력준비
		if(count == L) {
			if(consonants>=2 && vowels>=1) {
				list.add(sb.toString());
			}
			return;
		}
		
		for(int i=0;i<C;i++) {
			//아직 추가 안한거
			if(!visited[i]) {
				if(last>arr[i])continue;
				
				visited[i]=true;
				sb.append(arr[i]);
				if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') {
					vowels++;
					make(count+1,arr[i]);
					vowels--;
				}
				else {
					consonants++;
					make(count+1,arr[i]);
					consonants--;
				}
				sb.delete(sb.length()-1, sb.length());
				visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//선언
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		//초기화
		arr = new char[C];
		visited = new boolean[C];
		//입력
		arr = br.readLine().replace(" ","").toCharArray();
		//암호만들기
		make(0,'0');
		//만들고 정렬
		Collections.sort(list);
		//출력하기
		for(String s : list)
			System.out.println(s);
	}
}
