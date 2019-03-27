package team1;

public class ArrayEx {
	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5 };
		int[] B = new int[A.length * 2];
		for (int i = 0; i < B.length; i++) {
			if (i < A.length) {
				B[i] = A[i];
			} else {
				B[i] = i + 1;
			}
			System.out.println(B[i]);
		}
	}
}
