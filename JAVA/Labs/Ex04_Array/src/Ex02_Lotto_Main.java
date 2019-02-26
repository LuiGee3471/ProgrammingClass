/*
 * 1. 1 ~ 45까지의 난수를 발생시켜 6개의 배열에 담으세요.
 * 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안돼요.
 * 3. 배열에 있는 6개의 값은 낮은 순으로 정렬시키세요.
 * 4. 위 결과를 담고 있는 배열을 출력하세요.
 * 
 * 조별 과제
 */
public class Ex02_Lotto_Main {

	public static void main(String[] args) {
		int[] lotto = new int[6];

		// 1번
		// for (int i = 0; i < lotto.length; i++) {
		// lotto[i] = (int)(Math.random() * 45 + 1);
		// System.out.println(lotto[i]);
		// }

		// 2번
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--; // 중복되면 다시 이번 루프를 돌기 위해
					break;
				}
			}
			System.out.println(lotto[i]);
		}
		System.out.println();

		// 3번
		// 강사님 코드랑 알고리즘이 다르니까 헷갈리지 말자

		for (int i = 0; i < lotto.length; i++) {         // 몇 번째 항부터 시작할지 정하는 i for 루프
			for (int j = i + 1; j < lotto.length; j++) { // 앞뒤로 비교해서 바꾸는 for
				int first = lotto[i];
				int second = lotto[j];
				if (first > second) {                    // """""if 안에 있는 break는 if가 아니라 그 위의 for나 while을 break한다!"""""
					lotto[i] = second;
					lotto[j] = first;
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%d번째 번호 : %s\n", i + 1, lotto[i]);
		}
	}
}
