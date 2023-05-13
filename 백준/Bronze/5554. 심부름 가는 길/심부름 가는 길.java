import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int firstSec = scanner.nextInt();
		int SecondSec = scanner.nextInt();

		int ThirdSec = scanner.nextInt();

		int FourthSec = scanner.nextInt();

		int sum = (firstSec + SecondSec + ThirdSec + FourthSec);
		int resultMin = sum / 60;
		int resultSec = sum - (resultMin * 60);

		System.out.println(resultMin);
		System.out.println(resultSec);

	}
}