
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int []seq = new int[N];
		int []LIS = new int[N];
		int now = 0;
		
		st  = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		LIS[0]=seq[0];
		
		for(int i=1;i<N; i++) {
			if(LIS[now] < seq[i]) {
				LIS[++now] = seq[i];
			}else {
				int low = 0;
				int high = now;
				while(low<high) {
					int mid = (low+high)/2;
					if(LIS[mid]<seq[i]) {						
						low = mid +1;
					}
					else {
						high = mid;
					}
				}
				LIS[low] = seq[i];
			}
		}
		System.out.println(now+1);
	}
}
