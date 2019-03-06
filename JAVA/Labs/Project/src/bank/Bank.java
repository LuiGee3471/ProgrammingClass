package bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Bank {
	private Scanner sc;
	private ArrayList<Account> accounts; // 계좌

	public Bank() {
		sc = new Scanner(System.in);
		accounts = new ArrayList<Account>();
	}

	public void addAccount(String accountNo, String name) { // 계좌 생성
		accounts.add(new Account(accountNo, name));
	}

	public Account getAccount(String accountNo) { // 계좌 찾기(번호)
		Iterator<Account> accIterator = accounts.iterator();
		Account account = null;

		while (accIterator.hasNext()) {
			Account nextAccount = accIterator.next();
			if (accountNo.equals(nextAccount.getAccountNo())) {
				account = nextAccount;
			}
		}

		return account;
	}

	public ArrayList<Account> findAccounts(String name) { // 계좌 찾기(소유자명)
		Iterator<Account> accIterator = accounts.iterator();
		ArrayList<Account> acclist = new ArrayList<Account>();
		
		while (accIterator.hasNext()) {
			Account nextAccount = accIterator.next();
			if (name.equals(nextAccount.getName())) {
				acclist.add(nextAccount);
			}
		}
		return acclist;
	}

	public ArrayList<Account> getAccounts() { // 계좌목록 보기
		return accounts;
	}
}
