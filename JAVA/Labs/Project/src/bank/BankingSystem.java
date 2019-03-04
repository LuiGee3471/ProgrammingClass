package bank;

import java.util.Iterator;
import java.util.Scanner;

public class BankingSystem {
	private Scanner sc;
	private Bank bank;

	public BankingSystem(Bank bank) {
		sc = new Scanner(System.in);
		this.bank = bank;
	}

	public void bankingSystem() {
		while (true) {
			showMenu();
			switch (selectMenuNumber()) {
			case "1":
				createAccount();
				break;
			case "2":
				deleteAccount();
				break;
			case "3":
				findAccount();
				break;
			case "4":
				getAccountList();
				break;
			case "5":
				System.out.println("총 계좌 수 : " + bank.getAccounts().size());
				break;
			case "6":
				getAccountTransaction();
				break;
			case "7":
				return;
			default:
				System.out.println("잘못된 값을 입력하셨습니다.");
				break;
			}
		}
	}

	private void showMenu() {
		System.out.println("은행 관리 시스템");
		System.out.println("1. 계좌 생성");
		System.out.println("2. 계좌 삭제");
		System.out.println("3. 계좌 찾기");
		System.out.println("4. 계좌 목록 보기");
		System.out.println("5. 총 계좌 수 보기");
		System.out.println("6. 계좌 거래 내역 보기");
		System.out.println("7. 종료");
	}

	private String selectMenuNumber() {
		System.out.print("메뉴를 선택해주세요. >> ");
		String menuNumber = sc.nextLine();
		return menuNumber;
	}

	private void createAccount() {
		String accountNo = String.valueOf(10000 + bank.getAccounts().size() + 1);
		System.out.println("생성하는 계좌의 소유자명을 입력해주세요.");
		String name = sc.nextLine();
		bank.addAccount(accountNo, name);
		System.out.println("만들어진 계좌 정보");
		System.out.println("계좌번호 : " + accountNo + " | 계좌 소유자명 : " + name);
	}

	private void deleteAccount() {
		Account accountToDelete = getAccount();
		if (accountToDelete == null) {
			System.out.println("올바른 계좌가 아닙니다.");
		} else {
			System.out.println("선택한 계좌가 삭제되었습니다.");
			bank.getAccounts().remove(accountToDelete);
		}

	}

	private void findAccount() {
		System.out.println("계좌를 찾을 방법을 선택해주세요.");
		System.out.println("1. 계좌번호 2. 소유자명");
		String selectAccountNoOrName = sc.nextLine();
		switch (selectAccountNoOrName) {
		case "1":
			System.out.println("계좌번호를 입력하세요");
			String accountNo = sc.nextLine();
			Account account = bank.getAccount(accountNo);
			if (account == null) {
				System.out.println("계좌가 존재하지 않습니다.");
			} else {
				System.out.println("일치하는 계좌");
				System.out.println(account);
			}
			break;
		case "2":
			System.out.println("계좌 소유자명을 입력하세요");
			String name = sc.nextLine();
			Iterator<Account> i = bank.findAccounts(name).iterator();
			if (!i.hasNext()) {
				System.out.println("계좌가 존재하지 않습니다.");
			} else {
				while (i.hasNext()) {
					System.out.println(i.next());
				}
			}
			break;
		default:
			System.out.println("올바른 값을 입력하세요.");
			break;
		}
	}

	private void getAccountList() {
		if (bank.getAccounts().size() == 0) {
			System.out.println("계좌가 없습니다.");
		}
		Iterator<Account> i = bank.getAccounts().iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

	private void getAccountTransaction() {
		Account accountToGetTransaction = getAccount();
		if (accountToGetTransaction == null) {
			System.out.println("올바른 계좌가 아닙니다.");
		} else {
			Iterator<Transaction> i = accountToGetTransaction.getTransactions().iterator();
			if (accountToGetTransaction.getTransactions().size() == 0) {
				System.out.println("거래 내역이 없습니다.");
				return;
			}
			while (i.hasNext()) {
				System.out.println(i.next());
			}
		}
	}

	private Account getAccount() {
		Account account = null;
		System.out.println("계좌를 찾을 방법을 선택해주세요.");
		System.out.println("1. 계좌번호 2. 소유자명");
		String selectAccountNoOrName = sc.nextLine();
		switch (selectAccountNoOrName) {
		case "1":
			System.out.println("계좌번호를 입력하세요");
			String accountNo = sc.nextLine();
			account = bank.getAccount(accountNo);
			if (account == null) {
				System.out.println("계좌가 존재하지 않습니다.");
			} else {
				System.out.println("일치하는 계좌");
				System.out.println(account);
			}
			break;
		case "2":
			System.out.println("계좌 소유자명을 입력하세요");
			String name = sc.nextLine();
			Iterator<Account> i = bank.findAccounts(name).iterator();
			if (!i.hasNext()) {
				System.out.println("계좌가 존재하지 않습니다.");
			} else {
				while (i.hasNext()) {
					System.out.println(i.next());
				}
				System.out.println("선택할 계좌의 번호를 입력해주세요.");
				String accountNo2 = sc.nextLine();
				Iterator<Account> i2 = bank.findAccounts(name).iterator();
				while (i2.hasNext()) {
					Account temp = i2.next();
					if (temp.getAccountNo().equals(accountNo2)) {
						account = temp;
					}
				}
			}
			break;
		default:
			System.out.println("올바른 값을 입력하세요.");
		}
		return account;
	}
}
