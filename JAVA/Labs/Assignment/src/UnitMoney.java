import java.util.Scanner;

public class UnitMoney {

	public static void main(String[] args) {

		UnitMoneyLibrary u = new UnitMoneyLibrary();

		Scanner sc = new Scanner(System.in);
		System.out.println("금액을 입력하세요.");
		int money = Integer.parseInt(sc.nextLine());		
		
		while (u.unit >= 1) {
			u.printUnitNum(money);
			money = money - u.unit * u.num;
			if (u.sw == 0) {
				u.unit /= 2;
				u.sw = 1;
			} else {
				u.unit /= 5;
				u.sw = 0;
			}
		}
	}
}
