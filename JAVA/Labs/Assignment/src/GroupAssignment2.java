
public class GroupAssignment2 {

	public static void main(String[] args) {
		System.out.println("주사위 눈의 짝");
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if (i + j == 6) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}
	}
}
