package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

// 설계도
// Lotto lotto = new Lotto();
// lotto.selectLottoNumber(); >> 메뉴 제공
// 1 입력 >> selectBasicNumber() 함수 호출 (번호 추출)
// 2 입력 >> 번호 출력
// 3 입력 >> 프로그램 종료 // System.exit(0);

public class Lotto {
	private Scanner scanner; // 부품
	private Random r; // 부품 r.nextInt(45) (0~44)
	private int[] numbers; // 상태
	private int[] count;

	// static{}, {}
	public Lotto() { // 생성자 함수(constructor) 특수한 목적 : member field의 초기화, 실행 시점 : new를 통해 heap 메모리에 올릴
						// 때
		scanner = new Scanner(System.in); // 참조 변수의 초기화 : 주소값을 가지는 것
		r = new Random();
		numbers = new int[6];
		count = new int[45];
	}

	private void countNumber() {
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			count[num - 1]++;
		}
	}
	
	private void countPrint() {
		System.out.println("번호 : 출현횟수");
		for (int i = 0; i < count.length; i++) {
			System.out.printf("%d : %d번\n", i + 1, count[i]);
		}
		for (int i = 0; i< count.length; i++) { // count 초기화
			count[i] = 0;
		}
	}
	
	private void countTimes() {
		System.out.println("시행 횟수를 입력해주세요.");
		int time = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < time; i++ ) {
			selectBasicNumber();
			countNumber();
		}
	}
		
	private int[] selectBasicNumber() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < numbers.length; i++) {
			int min = numbers[i];
			int index = i;
			for (int j = i + 1; j < numbers.length; j++) {
				if (min > numbers[j]) {
					min = numbers[j];
					index = j;
				}
			}
			numbers[index] = numbers[i];
			numbers[i] = min;
		}
		return numbers;
	}

	private void printNumbers() {
		System.out.printf("번호는 [%d, %d, %d, %d, %d, %d]\n", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4],
				numbers[5]);
	}

	private void showMenu() {
		System.out.println("/////////////////////");
		System.out.println("////로또번호 출력////");
		System.out.println("1. 로또 번호 생성");
		System.out.println("2. 생성된 번호 출력");
		System.out.println("3. 가상 로또 시행");
		System.out.println("4. 프로그램 종료");
		System.out.println("/////////////////////");
		System.out.println("/////////////////////");
	}
	
	private int menuNumber() {
		int menu;
		
		do {		
			try {
				menu = Integer.parseInt(scanner.nextLine());
				if (menu >= 1 && menu <= 4) {
					break;
				} else {
					throw new Exception("문제");
				}
			} catch (Exception e) {
				menu = 0;
				break;
			}
		} while (true);
		
		return menu;
	}

	public void selectLottoNumber() {
		MenuLoop: while (true) {
			showMenu();
			switch (menuNumber()) {
			case 1:
				selectBasicNumber();
				System.out.println("로또 번호를 생성했습니다.");
				System.out.println();
				break;
			case 2:
				printNumbers();
				System.out.println();
				break;
			case 3:
				countTimes();
				countPrint();
				break;
			case 4:
				System.out.println("로또 프로그램을 종료합니다.");
				break MenuLoop;
			default:
				System.out.println("1부터 4의 값을 입력해주세요.");
				System.out.println();
				break;
			}
		}
	}

	// 검증 기능 (6개의 합을 구해서 개수로 나눈 평균의 범위가 5<=평균<=10일 때 번호를 추출한다, 아니면 재추출)
}