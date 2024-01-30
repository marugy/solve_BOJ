package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		str = str.replace("-", ",-,").replace("+", ",+,");
		
		int cal = 1;
		int sum = 0;
		for (String st : str.split(",")) {
			if(!st.equals("-") && !st.equals("+")) {
				int num = Integer.parseInt(st);
				sum+=cal*num;
			}if(st.equals("-"))
				cal= -1;
		}
		System.out.println(sum);
		
	}
}
