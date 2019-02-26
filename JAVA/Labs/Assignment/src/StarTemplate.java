
public class StarTemplate {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			for (int j = i; j < 10; j++) {
				System.out.print("A");
			}
			for (int k = 10 - i; k <= 10; k++) {
				System.out.print("B");
			}
			for (int j = 10 - i; j < 10; j++) {
				System.out.print("C");
			}
			for (int k = i; k <= 10; k++) {
				System.out.print("D");
			}
			System.out.println();
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 10 - i; j < 10; j++) {
				System.out.print("E");
			}
			for (int k = i; k <= 10; k++) {
				System.out.print("F");
			}
			for (int j = i; j < 10; j++) {
				System.out.print("G");
			}
			for (int k = 10 - i; k <= 10; k++) {
				System.out.print("H");
			}
			
			System.out.println();
		}
		System.out.println();
	}
}
