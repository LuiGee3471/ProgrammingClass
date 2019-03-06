package bank;

public class Transaction {
	private String transactionDate; // 거래일
	private String transactionTime; // 거래시간
	private String kind; // 구분 (입금, 출금)
	private long amount; // 거래금액
	private long balance; // 잔고
	
	public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
		this.transactionDate = transactionDate;
		this.transactionTime = transactionTime;
		this.kind = kind;
		this.amount = amount;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "거래 내역 | 거래 날짜 : " + transactionDate + " | 거래 시간 : " + transactionTime + " | 거래 구분 : "
				+ kind + " | 거래 금액 : " + amount + " | 잔고 : " + balance + "\n";
	}
}
