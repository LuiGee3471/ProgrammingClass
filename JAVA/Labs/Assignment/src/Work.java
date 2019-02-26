public class Work {

	public static void main(String[] args) {

		int k = 1;
		while (k <= 10) {
			int t = 1;
			while (t <= 10) {
				if (t <= 10 - k)
				    System.out.print("*");
				t++;
			}
			System.out.println();
			k++;
		}
	}
}
