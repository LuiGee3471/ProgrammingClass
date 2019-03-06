package bank;

import java.util.Iterator;
import java.util.Scanner;

public class ATM {
	private Scanner sc;
	private Account account;

	public ATM(Account account) {
		sc = new Scanner(System.in);
		this.account = account;
	}

	public void useATM() {
		main : while (true) {
			showMenu();
			switch (selectMenuNumber()) {
			case "1":
				deposit();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				checkTransactions();
				break;
			case "4":
				checkBalance();
				break;
			case "5":
				return;
			default:
				System.out.println("올바른 값을 입력하세요");
			}
		}
	}

	private void showMenu() {
		System.out.println("ATM");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 거래 내역 확인");
		System.out.println("4. 잔고 확인");
		System.out.println("5. 종료");
	}

	private String selectMenuNumber() {
		System.out.print("메뉴를 선택해주세요. >> ");
		String menuNumber = sc.nextLine();
		return menuNumber;
	}
	
	private void deposit() {
		System.out.println("금액을 입금해주세요.");
		long amount = Long.parseLong(sc.nextLine());
		account.deposit(amount);
	}
	
	private void withdraw() {
		System.out.println("얼마를 출금하시겠습니까?");
		long amount = Long.parseLong(sc.nextLine());
		account.withdraw(amount);
	}
	
	private void checkTransactions() {
		Iterator<Transaction> i = account.getTransactions().iterator();
		if (account.getTransactions().size() == 0) {
			System.out.println("거래 내역이 존재하지 않습니다");
			return;
		}
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	private void checkBalance() {
		System.out.println("현재 잔고 : " + account.getBalance() + "원");
	}

}
