package bank;

import java.util.ArrayList;
import java.util.Iterator;

public class Bank {
	private ArrayList<Account> accounts; // 계좌
	private int totalAccount;   // 총 계좌수
	
	public Bank() {
		accounts = new ArrayList<Account>();
		totalAccount = 0;
	}
	
	public void addAccount(String accountNo, String name) { // 계좌 생성
		accounts.add(new Account(accountNo, name));
//		System.out.println("계좌 생성 완료");
//		System.out.println("계좌 번호 : " + accountNo + " 계좌 소유자 : " + name);
		totalAccount++;
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
		
		if (account == null) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			// System.out.println("일치하는 계좌");
			// System.out.println(account);
		}
		
		return account;
	}
	
	public ArrayList<Account> findAccounts(String name) {  // 계좌 찾기(소유자명)
		Iterator<Account> accIterator = accounts.iterator();
		ArrayList<Account> acclist = new ArrayList<Account>();
		
		while (accIterator.hasNext()) {
			Account nextAccount = accIterator.next();
			if (name.equals(nextAccount.getName())) {
				acclist.add(nextAccount);
			}
		}
		
		if (acclist.size() == 0) {
			System.out.println("계좌가 존재하지 않습니다.");
		} else {
			// System.out.println("일치하는 계좌\n" + acclist.toString());
		}
		
		return acclist;
	}
	
//	public void showAccounts() {
//		Iterator<Account> accIterator = accounts.iterator();
//		while (accIterator.hasNext()) {
//			System.out.println(accIterator.next());
//		}
//	}
	
	public ArrayList<Account> getAccounts( ) { // 계좌목록 보기
		return accounts;
	}
	
	public int getTotalAccount() { // 총계좌수 반환
		// System.out.println("은행 총 계좌 수 : " + totalAccount);
		return totalAccount;
	}
}
