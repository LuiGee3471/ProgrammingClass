//import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] bubble = new int[] { 6, 5, 4, 3, 2, 1 };

		for (int i = 1; i <= bubble.length; i++) {
			for (int j = 0; j < bubble.length - i; j++) {
				if (bubble[j] > bubble[j + 1]) {
					int temp = 0;
					temp = bubble[j];
					bubble[j] = bubble[j + 1];
					bubble[j + 1] = temp;
					//System.out.println(Arrays.toString(bubble));
				}
			}
		}
	}
}
