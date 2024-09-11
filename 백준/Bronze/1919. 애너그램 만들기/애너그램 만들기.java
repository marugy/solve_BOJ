import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		char []a = br.readLine().toCharArray();
		char []b = br.readLine().toCharArray();
		int[]infoA = new int[26];
		int[]infoB = new int[26];
		for(int i=0;i<a.length;i++) {
			infoA[a[i]-'a']++;
		}
		for(int i=0;i<b.length;i++) {
			infoB[b[i]-'a']++;
		}
		for(int i=0;i<26;i++) {
			if(infoA[i]!=infoB[i])answer+= Math.abs(infoA[i]-infoB[i]);
		}
		System.out.println(answer);
	}

}
