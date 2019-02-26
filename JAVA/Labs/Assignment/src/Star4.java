// *
// **
// ***
// ****
// *****
// ****
// ***
// **
// *



public class Star4 {
	public static void main(String[] args) {
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 6; j++) {
				if (i < 6 && j <= i) {
					System.out.print("*");
				} else if (i >= 6 && 11 - j > i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
