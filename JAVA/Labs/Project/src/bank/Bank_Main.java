package bank;

public class Bank_Main {

	public static void main(String[] args) {
		/*
		 * KB은행에서
		 * 윤종석 계좌가 생성되어
		 * 윤종석 계좌로 ATM을 이용한다
		 * 
		 * ATM 이용 종료 후 관리 시스템 동작
		 * 
		 */
		Bank KB = new Bank();
		KB.addAccount("10001", "윤종석");
		ATM atm = new ATM(KB.getAccounts().get(0));
		atm.useATM();
		BankingSystem bs = new BankingSystem(KB);
		bs.bankingSystem();
	}
}
