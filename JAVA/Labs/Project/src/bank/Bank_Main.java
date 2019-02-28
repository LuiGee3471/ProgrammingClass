package bank;

public class Bank_Main {

	public static void main(String[] args) {
		Bank KB = new Bank();
		KB.addAccount("10001", "윤종석");
		KB.addAccount("10002", "윤종석");
		KB.addAccount("10003", "장지훈");
		KB.addAccount("10004", "김동민");
		
		System.out.println(KB.getAccount("10003"));
		System.out.println(KB.getAccount("10005"));
		
		System.out.println(KB.findAccounts("윤종석"));
		System.out.println(KB.findAccounts("김동민"));
		System.out.println(KB.findAccounts("우세림"));
		
//		KB.showAccounts();
		
		System.out.println(KB.getAccounts());
		
		KB.getTotalAccount();
		
		KB.getAccounts().get(0).deposit(1000);
		KB.getAccounts().get(0).deposit(1000);
		KB.getAccounts().get(0).deposit(3000);
		KB.getAccounts().get(0).deposit(1000);
		KB.getAccounts().get(0).deposit(5000);
		KB.getAccounts().get(0).withdraw(3000);
		KB.getAccounts().get(0).withdraw(10000);
		KB.getAccounts().get(0).getBalance();
		KB.getAccounts().get(1).deposit(1000);
		KB.getAccounts().get(1).getBalance();
		
		System.out.println(KB.getAccounts().get(0).getTransactions());

	}

}
