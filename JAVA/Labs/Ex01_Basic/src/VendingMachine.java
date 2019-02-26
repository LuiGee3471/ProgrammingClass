//가격 300
//개수 3
//수중에 있는 돈 1000
//거스름돈 100

import java.util.Scanner;
public class VendingMachine {

	public static void main(String[] args) {
		while (true) {
		int price, qt, money, change;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사탕의 가격을 입력하세요.");
		price = Integer.parseInt(sc.nextLine());
		System.out.println("사탕의 개수를 입력하세요.");
		qt = Integer.parseInt(sc.nextLine());
		System.out.println("지금 가진 돈을 입력하세요.");
		money = Integer.parseInt(sc.nextLine());
		
		change = money - price*qt;
		
		if (change >= 0) {	
	
			System.out.println("잔돈은 " + change + "원입니다.");
		} else {
			System.out.println("돈이 모자랍니다.");
			break;
		}
		}
		
	}

}
