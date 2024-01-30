package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_4779_칸토어집합 {

	static StringBuilder sb = new StringBuilder();
	static void make(char []ch, int start, int end) {
		if(start>=end) {
			sb.append("-");
			return;
		}
		int leng = (end-start+1)/3;
		int middle = start+leng;

		make(ch,start,middle-1);
		
		for(int m = middle; m < start+2*leng; m++) {
			sb.append(" ");
		}
		
		make(ch,start+2*leng,end);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a=br.readLine();
		while(a!=null) {
			int n = Integer.parseInt(a);
			char[]ch = new char[(int)Math.pow(3,n)];
			make(ch,0,ch.length-1);
			sb.append("\n");
			a = br.readLine();
		}
		System.out.println(sb.toString());
	}
}
