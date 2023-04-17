import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][]arr = new int[8][2];
		boolean[]use = new boolean[8];
		for(int i=0;i<8;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=i;
		}
		Arrays.sort(arr,(a,b)->b[0]-a[0]);
		int sum = 0;
		for(int i=0;i<5;i++) {
			sum+=arr[i][0];
			use[arr[i][1]]=true;
		}
		System.out.println(sum);
		for(int i=0;i<8;i++) {
			if(use[i])
				System.out.print(i+1+" ");
		}
	}
}
