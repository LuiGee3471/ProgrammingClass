import java.util.Scanner;

public class Starex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		sc.nextLine();
		
		String[][] star = new String[a][a];
		
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				star[i][j] = "*";
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
	}
}
