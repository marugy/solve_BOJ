import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int calDis(String a, String b, String c) {
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		char[] cArr = c.toCharArray();
		int dis = 0;
		for(int i=0;i<4;i++) {
			if(aArr[i]!=bArr[i])dis++;
			if(aArr[i]!=cArr[i])dis++;
			if(bArr[i]!=cArr[i])dis++;

		}
		return dis;
	}
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] data = br.readLine().split(" ");
			if(N>32) {
				System.out.println(0);
				continue;
			}
			int minNum = Integer.MAX_VALUE;
			for(int i=0; i<data.length-2; i++) {
				if(minNum==0)break;
				for(int j=i+1; j<data.length-1; j++) {
					if(minNum==0)break;
					for(int k=j+1; k<data.length; k++) {
						int dis = calDis(data[i], data[j], data[k]);
						if(dis==0) {
							minNum=0;
							break;
						}
						if(dis<minNum) minNum=dis;
					}
				}
			}
			System.out.println(minNum);
		}
	}
}
