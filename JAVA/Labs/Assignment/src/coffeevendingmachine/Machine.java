package coffeevendingmachine;

import java.util.Scanner;

public class Machine { // 자판기
	private Scanner sc = new Scanner(System.in);
	private int password;
	private boolean power; // 전원
	private static int sales; // 매출(누적)
	private static int[] maxRecipe = new int[] { 200, 1000, 50, 1000 };; // 최대 재료량(재료가 많아서 배열선택)
	private int changeMoney; // 거스름돈 단위
	private int inputMoney; // 받는돈 단위
	private int[] size; // 사이즈
	private int[][] recipes;
	private Coffee[] coffees;

	public Machine() {
		password = 1234;
//    	changeMoney = new int[] { 5000, 1000, 500, 100 };
//    	inputMoney = new int[] { 5000, 1000, 500, 100 };
		size = new int[] { 5, 10, 5, 10 };
		recipes = new int[][] { // 원두, 우유, 설탕, 물
				{ 20, 0, 0, 100 }, { 20, 100, 5, 100 }, { 20, 80, 5, 100 } };
		coffees = new Coffee[] { new Coffee("아메리카노", 1, recipes[0], 1500), new Coffee("카푸치노", 2, recipes[1], 2000),
				new Coffee("카페라떼", 3, recipes[2], 2500) };
	}

	public void Coffee() {
		Coffee c = displayMenu();
		c = setUserRecipe(c);
		displaySum(c);
		refund(c);
	}

	public void admin() { // 관리자모드
		setRecipe();
		setCoffeeName();
		displaySales();
	}

	public void setRecipe() { // 재료량 설정
		System.out.println("바꾸실 재료의 커피를 선택해주세요.");
		System.out.printf("1.[%s] ,2[%s] ,3[%s]", coffees[0].getCoffeeName(), coffees[1].getCoffeeName(),
				coffees[2].getCoffeeName());
		System.out.println();
		int coffee1 = Integer.parseInt(sc.nextLine());
		exit: while (true) {
			switch (coffee1) {
			case 1:
				System.out.println(coffees[0].getCoffeeName());
				for (int i = 0; i < recipes[0].length; i++) {
					System.out.printf("[%d] 원두 > 우유 > 설탕 > 물 순입니다.", i + 1);
					recipes[0][i] = Integer.parseInt(sc.nextLine());
				}
				System.out.printf("[%d],[%d],[%d],[%d] 바뀐 레시피입니다.", recipes[0][0], recipes[0][1], recipes[0][2],
						recipes[0][3]);
				break exit;
			case 2:
				System.out.println(coffees[1].getCoffeeName());
				for (int i = 0; i < recipes[1].length; i++) {
					System.out.printf("[%d] 원두 > 우유 > 설탕 > 물 순입니다.", i + 1);
					recipes[1][i] = Integer.parseInt(sc.nextLine());
				}
				System.out.printf("[%d],[%d],[%d],[%d] 바뀐 레시피입니다.", recipes[1][0], recipes[1][1], recipes[1][2],
						recipes[1][3]);
				break exit;
			case 3:
				System.out.println(coffees[2].getCoffeeName());
				for (int i = 0; i < recipes[2].length; i++) {
					System.out.printf("[%d] 원두 > 우유 > 설탕 > 물 순입니다.", i + 1);
					recipes[2][i] = Integer.parseInt(sc.nextLine());
				}
				System.out.printf("[%d],[%d],[%d],[%d] 바뀐 레시피입니다.", recipes[2][0], recipes[2][1], recipes[2][2],
						recipes[2][3]);
				break exit;
			default:
				System.out.println("잘못 입력하였습니다.");
			}

		}

	}

	public void setCoffeeName() {// 커피종류 변경
		System.out.printf("1.[%s], 2.[%s], 3.[%s]", coffees[0].getCoffeeName(), coffees[1].getCoffeeName(),
				coffees[2].getCoffeeName());
		System.out.println();
		System.out.println("변경할 커피 번호 입력 : ");
		int numbers = Integer.parseInt(sc.nextLine());
		if (numbers == 1) {
			System.out.println("변경할 이름을 입력해주세요 :");
			coffees[0].setCoffeeName(sc.nextLine());
			System.out.println("바뀐이름 :" + coffees[0].getCoffeeName());
			// admin();
		} else if (numbers == 2) {
			System.out.println("변경할 이름을 입력해주세요 :");
			coffees[1].setCoffeeName(sc.nextLine());
			System.out.println("바뀐이름 :" + coffees[1].getCoffeeName());
			// admin();
		} else if (numbers == 3) {
			System.out.println("변경할 이름을 입력해주세요 :");
			coffees[2].setCoffeeName(sc.nextLine());
			System.out.println("바뀐이름 :" + coffees[2].getCoffeeName());
			// admin();
		} else {
			System.out.println("잘못 입력하였습니다.");
			setCoffeeName();
		}
	}

	public void displaySales() { // 매출확인
		System.out.printf("현재까지 커피 매출은 [%d]입니다.", sales);
		// admin();
	}

	public Coffee displayMenu() { // 메뉴
		System.out.println("┌─────────────┐");
		System.out.println("│  커 피  메 뉴	  │");
		System.out.println("│=============│");
		System.out.println("│ 1.아메리카노	  │");
		System.out.println("│	          │");
		System.out.println("│ 2.카푸치노	  │");
		System.out.println("│			  │");
		System.out.println("│ 3.카페모카	  │");
		System.out.println("│-------------│");
		System.out.println("│ 4. 종  료	  │");
		System.out.println("└─────────────┘");

		int menu = 0;
		do {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("메뉴를 선택해 주세요.");
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <= 4) {
					break;
				} else {
					throw new Exception("문제발생");
				}
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("메뉴를 잘못 선택했어요");
				System.out.println("1,2,3,4 중에 선택해주세요");
			}
		} while (true);

		Coffee c = null;
		switch (menu) {
		case 1:
			c = coffees[0];
			break;
		case 2:
			c = coffees[1];
			break;
		case 3:
			c = coffees[2];
			break;
		case 4:
			System.exit(0);
			break;
		}
		
		return c;
	}

	public Coffee setUserRecipe(Coffee coffee) { // 재료량 조절
		String[] recipeName = { "원두", "우유", "설탕", "물" };
		int[] tempRecipe = new int[4];
		for (int i = 0; i < tempRecipe.length; i++) {
			tempRecipe[i] = coffee.getRecipe()[i];
		}
		Coffee tempCoffee = new Coffee(coffee.getCoffeeName(), coffee.getCoffeeId(), tempRecipe,
				coffee.getCoffeePrice());

		System.out.printf("%s 커피를 선택하셨습니다.\n", tempCoffee.getCoffeeName());
		System.out.println();
		for (int i = 0; i < tempRecipe.length; i++) {
			if (tempRecipe[i] != 0) {
				int sizeSelect = 0;
				do {
					System.out.printf("%s의 양을 선택해주세요.\n", recipeName[i]);
					System.out.println("1. 기본 2. 적게 3. 많게");
					try {
						sizeSelect = Integer.parseInt(sc.nextLine());
						if (sizeSelect >=1 && sizeSelect <= 3) {
							break;
						} else {
							throw new Exception();
						}
					} catch (Exception e) {
						sizeSelect = 0;
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
					tempRecipe[i] -= size[i];
					break;
				case 3:
					System.out.println("많은 양으로 설정했습니다.");
					System.out.println();
					tempRecipe[i] += size[i];
					break;
				default:
					System.out.println("올바른 값을 입력해주세요.");
					System.out.println();
					i--;
					break;
				}
			}
		}
		return tempCoffee;
	}

	public void displaySum(Coffee coffee) { // 금액 표시
		int result = coffee.getCoffeePrice();
		System.out.printf("가격은 %d원입니다\n", result);
		System.out.println();

	}

	public void refund(Coffee coffee) {
		int result;
		sc = new Scanner(System.in);
		System.out.println("돈을 넣으세용");

		do {
			try {
				inputMoney = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("다시 입력해주세요");
			}
		} while (true);

		if (inputMoney < coffee.getCoffeePrice()) {
			System.out.println("금액이 부족합니다");
			result = inputMoney;
		} else {
			System.out.println(inputMoney + "원을 넣으셨습니다.");
			result = inputMoney - coffee.getCoffeePrice();
			sales += coffee.getCoffeePrice();
			// 현재 재료량에서 레시피만큼 재료 빼주기
			System.out.println("잔액은 " + result + "입니다");
		}

		int unit = 10000;
		int num = 0;
		int sw = 0;

		while (true) {
			num = (int) (result / unit);
			System.out.printf("단위 :  %d   매수 : %d\n", unit, num);
			if (unit > 100) {
				result = result - unit * num;
				if (sw == 0) {
					unit = unit / 2;
					sw = 1;
				} else {
					unit = unit / 5;
					sw = 0;
				}
			} else {
				return;

			}
		}
	}
}