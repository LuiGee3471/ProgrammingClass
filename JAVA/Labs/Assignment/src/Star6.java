import java.util.Scanner;

public class Star6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력");
		int value = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < value; i++) {
			int left = i+1;
			int right = value*2 - 1 - i;
			for (int j = 1; j < value*2; j++) {
				if (j >= left && j <= right) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
