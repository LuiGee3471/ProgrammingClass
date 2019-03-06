package bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ListIterator;

public class Account {
	private String accountNo; // 계좌번호
	private String name; // 소유자명
	private long balance; // 잔고
	private ArrayList<Transaction> transactions; // 거래내역
	private Calendar cal;
	private SimpleDateFormat dateFormat;
	private SimpleDateFormat timeFormat;
	
	@Override
	public String toString() {
		return "계좌번호 : " + accountNo + " | 계좌 소유자명 : " + name + "\n";
	}

	public Account(String accountNo, String name) {
		this.accountNo = accountNo;
		this.name = name;
		balance = 0;
		transactions = new ArrayList<Transaction>();
		cal = Calendar.getInstance();
		dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		timeFormat = new SimpleDateFormat("HH:mm:ss");
	}
	
	public void deposit(long amount) { // 입금
		balance += amount;
		//System.out.println(amount + "원 입금");
		transactions.add(new Transaction(dateFormat.format(cal.getTime()), timeFormat.format(cal.getTime()), "입금", amount, balance));
	}
	
	public void withdraw(long amount) { // 출금
		if (amount < balance) {
			balance -= amount;
			//System.out.println(amount + "원 출금");
			transactions.add(new Transaction(dateFormat.format(cal.getTime()), timeFormat.format(cal.getTime()), "출금", amount, balance));
		} else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	public String getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}
	
	public long getBalance() { // 잔고 확인
		return balance;
	}
	
	public ArrayList<Transaction> getTransactions() { // 거래내역 보기
		return transactions;
	}
}
