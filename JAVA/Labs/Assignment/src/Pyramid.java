
public class Pyramid {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = i; j < 10; j++) {
				System.out.print("1");
			}
			for (int k = 11 - i; k <= 10; k++) {
				System.out.print("*");
			}
			for (int j = i; j < 10; j++) {
				System.out.print("@");
			}
			for (int k = 11 - i; k <= 10; k++) {
				System.out.print("3");
			}
			
			System.out.println();
		}
		System.out.println();
	}
}
