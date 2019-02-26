package coffeevendingmachine;

import java.util.Scanner;

public class Machine { // 자판기
	private Scanner sc;
	private int password; // 관리자 모드 비밀번호
	private int sales; // 매출(누적)
	private static final int[] MAXSTOCK = new int[] { 200, 1000, 50, 1000 }; // 최대 재료량(재료가 많아서 배열선택)
	private int[] currentStock; // 현재 재고
	private int[] size; // 사이즈에 따른 변화량
	private int[][] recipes; // 커피별 재료량
	private Coffee coffeeOrder; // 주문하는 커피
	private Coffee[] coffeeList; // 커피 정보 배열
	private String[] recipeName; // 재료 이름

	public Machine() { // 생성자 함수
		sc = new Scanner(System.in);
		password = 1234;
		currentStock = new int[] { 200, 1000, 50, 1000 };
		size = new int[] { 5, 10, 5, 10 };
		recipes = new int[][] { // 원두, 우유, 설탕, 물
				{ 20, 0, 0, 100 }, { 20, 100, 5, 100 }, { 20, 80, 5, 100 } };
		coffeeList = new Coffee[] { new Coffee1("아메리카노", recipes[0], 1500), new Coffee2("카페라떼", recipes[1], 2500),
				new Coffee3("카푸치노", recipes[2], 2000) };
		recipeName = new String[] { "원두", "우유", "설탕", "물" };
	}

	public void vendingMachine() { // 실행 함수
		while (true) {
			Coffee coffee = displayMenu();  // 메뉴 출력
			if (coffee == null)
				continue;                   // 메뉴에서 관리자모드에 갔다오면 다시 while 루프 처음으로 복귀
			coffee = setUserRecipe(coffee); // 메뉴에서 선택한 커피로 재료량 조절
			refund(coffee, inputMoney(coffee)); // 조절한 커피를 받아 금액 입력, 잔돈 환불
		}
	}

	private Coffee displayMenu() { // 메뉴
		System.out.println("┌──────────────");
		System.out.println("│  커 피  메 뉴   ");
		System.out.println("│=============");
		System.out.printf("│ 1  %s   \n", coffeeList[0].getCoffeeName());
		System.out.println("│             ");
		System.out.printf("│ 2  %s    \n", coffeeList[1].getCoffeeName());
		System.out.println("│             ");
		System.out.printf("│ 3  %s     \n", coffeeList[2].getCoffeeName());
		System.out.println("│-------------");
		System.out.println("│ 4   종  료      ");
		System.out.println("└──────────────");

		int menu = 0;
		do {
			try {
				System.out.println("메뉴를 선택해주세요.");  // 메뉴 번호 1,2,3,4,비밀번호만 받게
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <= 4 || menu == password) {
					break;
				}
			} catch (Exception e) {
				System.out.println("메뉴를 잘못 선택했어요");
				System.out.println("1,2,3,4 중에 선택해주세요");
			}
		} while (true);

		coffeeOrder = null;
		
		if (menu >= 1 && menu <= 3) {
			coffeeOrder = coffeeList[--menu]; // 1,2,3을 입력하면 커피 리스트에서 (입력한 값 -1)번째 주소값을 할당
		} else if (menu == 4) {
			System.exit(0);            // 4 입력하면 프로그램 종료
		} else if (menu == password) { // password로 받기 위해 if-else if문 사용
			admin();                   // 관리자 모드 진입
		}
//		switch (menu) {
//		case 1:
//		case 2:
//		case 3:
//			coffeeOrder = coffees[--menu];
//			break;
//		case 4:
//			System.exit(0);
//		case 1234:
//			admin();
//			break;
//		}

		return coffeeOrder;
	}

	private Coffee setUserRecipe(Coffee coffee) { // 재료량 조절

		coffeeOrder = new Coffee(coffee.getCoffeeName(), new int[4], coffee.getCoffeePrice()); // 이름, 가격 똑같이 해주기

		for (int i = 0; i < coffee.getRecipe().length; i++) { // 재료량 똑같이 해주기
			coffeeOrder.getRecipe()[i] = coffee.getRecipe()[i];
		}

		System.out.printf("%s 커피를 선택하셨습니다.\n", coffeeOrder.getCoffeeName());
		System.out.println();
		
		for (int i = 0; i < coffeeOrder.getRecipe().length; i++) { // 기본, 적게, 많게를 선택하는 for 루프
			if (coffeeOrder.getRecipe()[i] != 0) { // 재료가 원래 0이면 아예 스킵
				int sizeSelect = 0;
				do {
					System.out.printf("%s의 양을 선택해주세요.\n", recipeName[i]);
					System.out.println("1. 기본 2. 적게 3. 많게");
					try {
						sizeSelect = Integer.parseInt(sc.nextLine()); // 1,2,3만 받기
						if (sizeSelect >= 1 && sizeSelect <= 3) {
							break;
						}
					} catch (NumberFormatException e) { // 숫자가 아니면 예외 catch
						break;
					}
				} while (true);

				switch (sizeSelect) {
				case 1:
					System.out.println("기본으로 설정했습니다.");
					System.out.println();
					break;
				case 2:
					System.out.println("적은 양으로 설정했습니다.");
					System.out.println();
					coffeeOrder.getRecipe()[i] -= size[i]; // 적게 하면 사이즈 변화량만큼 감소
					break;
				case 3:
					System.out.println("많은 양으로 설정했습니다.");
					System.out.println();
					coffeeOrder.getRecipe()[i] += size[i]; // 많게 하면 사이즈 변화량만큼 증가
					break;
				default:
					System.out.println("올바른 값을 입력해주세요.");
					System.out.println();
					i--; // 올바른 값을 입력하지 않으면 i 감소시켜 다시 재료량 선택하게
					break;
				}
			}
		}

		System.out.println("얼음을 추가하시겠습니까? (+500원) (예 / 아니오)");
		String answer = sc.nextLine();
		
		if (answer.equals("예")) {
			coffeeOrder.setIce(true); // 얼음 추가하면 Coffee 클래스의 ice를 true로
			coffeeOrder.setCoffeePrice(coffeeOrder.getCoffeePrice() + 500); // 가격 500원 추가
		}

		return coffeeOrder;
	}

	private void showOrder(Coffee coffee) { // 주문 내역 확인
		Coffee original = null; // 재료량 비교를 위한 원래 커피를 찾는 부분
		for (int i = 0; i < coffeeList.length; i++) {
			if (coffee.getCoffeeName().equals(coffeeList[i].getCoffeeName())) { // 이름을 비교해서 같으면 원래 커피로 할당
				original = coffeeList[i];
				break;
			}
		}

		System.out.println("주문 내용을 확인해주세요.");
		System.out.println();
		if (coffee.isIce()) {
			System.out.print("아이스 "); // 아이스면 아이스 커피, 아니면 그냥 커피
		}
		System.out.println(coffee.getCoffeeName());
		System.out.println();
		
		for (int i = 0; i < coffee.getRecipe().length; i++) { // 원래 재료량과 비교해 적으면 적게, 많으면 많게, 같으면 기본
			String sizeString = null;
			if (coffee.getRecipe()[i] == 0) {
				continue;
			} else if (coffee.getRecipe()[i] == original.getRecipe()[i]) {
				sizeString = "기본";
			} else if (coffee.getRecipe()[i] < original.getRecipe()[i]) {
				sizeString = "적게";
			} else if (coffee.getRecipe()[i] > original.getRecipe()[i]) {
				sizeString = "많게";
			}
			System.out.printf("%s : %s\n", recipeName[i], sizeString);
		}

		System.out.println();

		System.out.printf("가격 : %d원\n", coffee.getCoffeePrice());
		System.out.println();
	}

	private int inputMoney(Coffee coffee) { // 주문 확인, 취소, 입금

		showOrder(coffee);

		System.out.println("이대로 주문할까요? (예 / 아니오)");
		String answer = sc.nextLine();

		int inputMoney;
		if (answer.equals("예")) {
			System.out.println("금액을 투입하세요.");
			do {
				try {
					inputMoney = Integer.parseInt(sc.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("다시 입력해주세요");
				}
			} while (true);
		} else {
			inputMoney = 0;
		}
		return inputMoney;
	}

	private void refund(Coffee coffee, int inputMoney) { // 계산, 잔돈 반환
		int result;

		if (inputMoney == 0) {
			System.out.println("들어온 금액이 없어 주문을 취소합니다.");
			return;
		} else if (inputMoney < coffee.getCoffeePrice()) {
			System.out.println("금액이 부족합니다");
			result = inputMoney;
		} else {
			System.out.println(inputMoney + "원을 넣으셨습니다.");
			result = inputMoney - coffee.getCoffeePrice();

			System.out.println("잔돈은 " + result + "원입니다");
			makeCoffee(coffee);
		}

		int unit = 10000;
		int num = 0;
		int sw = 0;

		while (true) { // 잔돈 반환 코드
			num = (int) (result / unit);
			System.out.printf("%5d원  %4d개\n", unit, num);
			if (unit > 10) {
				result = result - unit * num;
				if (sw == 0) {
					unit = unit / 2;
					sw = 1;
				} else {
					unit = unit / 5;
					sw = 0;
				}
			} else {
				System.out.println("잔돈으로 나왔습니다.");
				return;
			}
		}
	}

	private void makeCoffee(Coffee coffee) { // 커피 제조
		for (int i = 0; i < currentStock.length; i++) { // 재료가 부족하면 못만든다고 출력하는 부분
			if (currentStock[i] < coffee.getRecipe()[i]) {
				System.out.println("죄송합니다. 재료가 부족합니다. 관리자에게 연락하세요.");
				return;
			}
		}

		for (int i = 0; i < currentStock.length; i++) { // 재료가 충분할 때
			currentStock[i] -= coffee.getRecipe()[i]; // 사용된 재료만큼 뺴주고
		}
		sales += coffee.getCoffeePrice(); // 가격만큼 매출을 올려주고
		System.out.println("주문한 커피가 나왔습니다."); // 커피를 준다
		System.out.println();
	}

	private void admin() { // 관리자 모드
		System.out.println("┌──────────────");
		System.out.println("│  관 리 자 메 뉴	  ");
		System.out.println("│=============");
		System.out.println("│ 1. 재료량 설정	  ");
		System.out.println("│	          ");
		System.out.println("│ 2. 커피 이름 변경  ");
		System.out.println("│			  ");
		System.out.println("│ 3. 매출 확인	  ");
		System.out.println("│");
		System.out.println("│ 4. 재고 확인");
		System.out.println("│-------------");
		System.out.println("│ 5. 종  료	  ");
		System.out.println("└──────────────");

		int menu = 0;
		do {
			try {
				System.out.println("메뉴를 선택해 주세요.");
				menu = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요");
			}
		} while (true);

		switch (menu) {
		case 1:
			setRecipe();
			break;
		case 2:
			setCoffeeName();
			break;
		case 3:
			displaySales();
			break;
		case 4:
			currentStock();
			break;
		case 5:
			break;
		}
	}

	private void setRecipe() { // 재료량 설정
		int selectCoffee;
		do {
			try {
				System.out.println("재료량을 바꾸실 커피를 선택해주세요.");
				System.out.printf("1. %s 2. %s 3. %s\n", coffeeList[0].getCoffeeName(), coffeeList[1].getCoffeeName(),
						coffeeList[2].getCoffeeName());
				selectCoffee = Integer.parseInt(sc.nextLine()) - 1;
				if (selectCoffee >= 0 && selectCoffee <= 2) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		} while (true);

		exit: while (true) {
			switch (selectCoffee + 1) {
			case 1:
			case 2:
			case 3:
				System.out.println(coffeeList[selectCoffee].getCoffeeName());
				for (int i = 0; i < recipes[selectCoffee].length; i++) {
					System.out.printf("%s의 양을 입력해주세요.", recipeName[i]);
					recipes[selectCoffee][i] = Integer.parseInt(sc.nextLine());
				}
				System.out.printf("변경된 재료량입니다.\n[%d, %d, %d, %d]\n", recipes[selectCoffee][0], recipes[selectCoffee][1],
						recipes[selectCoffee][2], recipes[selectCoffee][3]);
				break exit;
			default:
				System.out.println("잘못 입력하였습니다.");
			}

		}
		System.out.println();
		admin();
	}

	private void setCoffeeName() {// 커피 이름 변경
		int selectCoffee;
		do {
			try {
				System.out.println("이름을 변경할 커피를 선택해주세요.");
				System.out.printf("1. %s 2. %s 3. %s\n", coffeeList[0].getCoffeeName(), coffeeList[1].getCoffeeName(),
						coffeeList[2].getCoffeeName());
				selectCoffee = Integer.parseInt(sc.nextLine()) - 1;
				if (selectCoffee >= 0 && selectCoffee <= 2) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("올바른 값을 입력해주세요.");
			}
		} while (true);

		switch (selectCoffee + 1) {
		case 1:
		case 2:
		case 3:
			System.out.println("변경할 이름을 입력해주세요 :");
			coffeeList[selectCoffee].setCoffeeName(sc.nextLine());
			System.out.println("변경한 이름 :" + coffeeList[selectCoffee].getCoffeeName());
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			setCoffeeName();
		}
		System.out.println();
		admin();
	}

	private void displaySales() { // 매출 확인
		System.out.printf("현재까지의 매출은 %d원입니다.", sales);
		System.out.println();
		System.out.println("\t\t나가기 [0]");
		String exit = sc.nextLine();
		if (exit.equals("0")) {
			admin();
		} else {
			System.out.println("잘못 입력하였습니다.");
			displaySales();
		}
	}

	private void currentStock() { // 현재 재고량 확인
		for (int i = 0; i < MAXSTOCK.length; i++) {
			if ((float) currentStock[i] / MAXSTOCK[i] <= 0.3) {
				System.out.printf("%s 재료가 30%% 미만 남았습니다.\n", recipeName[i]);
			}
		}
		
		System.out.println("원두,  우유,  설탕,  물  - 최대");
		for (int remain : MAXSTOCK) {
			System.out.printf("[%4d]", remain);
		}
		
		System.out.println();
		
		System.out.println("원두,  우유,  설탕,  물  - 현재");
		for (int remain2 : currentStock) {
			System.out.printf("[%4d]", remain2);
		}
		
		System.out.println();
		
		System.out.println("\t\t나가기 [0]");
		String exit = sc.nextLine();
		if (exit.equals("0")) {
			admin();
		} else {
			System.out.println("잘못 입력하였습니다.");
			currentStock();
		}
	}
}