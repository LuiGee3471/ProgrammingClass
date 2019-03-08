package bankio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

// 은행
class Bank {
  private FileInputStream fis;
  private FileOutputStream fos;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private Map<String, Account> accountsByName;
  private Map<String, Account> accountsByAccountNo;
  private String path;

  // 계좌를 생성한다

  public Map<String, Account> getAccountsByName() {
    return accountsByName;
  }

  public void setAccountsByName(Map<String, Account> accountsByName) {
    this.accountsByName = accountsByName;
  }

  public Map<String, Account> getAccountsByAccountNo() {
    return accountsByAccountNo;
  }

  public void setAccountsByAccountNo(Map<String, Account> accountsByAccountNo) {
    this.accountsByAccountNo = accountsByAccountNo;
  }

  public Bank() {
    accountsByName = new HashMap<String, Account>();
    accountsByAccountNo = new HashMap<String, Account>();
    path = "C:\\Temp\\bank.txt";
  }

  public void addAccount(String accountNo, String name) {
    // accounts = new ArrayList<Account>();
    Account newAccount = new Account(accountNo, name);
    accountsByName.put(name, newAccount);
    accountsByAccountNo.put(accountNo, newAccount);
  }

  // 계좌를 찾는다(계좌번호로)
  public void getAccount(String accountNo) {
    if (accountsByAccountNo.containsKey(accountNo)) {
      System.out.println(accountsByAccountNo.get(accountNo));
    }
  }

  // 계좌를 찾는다(소유자명으로)
  public void findAccount(String name) {
    if (accountsByName.containsKey(name)) {
      System.out.println(accountsByName.get(name));
    }
  }

  // 계좌목록을 본다
  public void getAccounts() {
    System.out.println("은행 계좌 목록");
    for (Map.Entry<String, Account> m : accountsByName.entrySet()) {
      System.out.println(m.getValue());
    }
  }

  // 총 계좌수를 반환한다
  public int getTotalAccount() {
    return accountsByAccountNo.size();
  }
  
  public void save() {
    try {
      fos = new FileOutputStream(path);
      out = new ObjectOutputStream(fos);
      
      out.writeObject(accountsByAccountNo);
      out.writeObject(accountsByName);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        out.close();
        fos.close();
        System.out.println("저장 완료");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void load() {
    try {
      fis = new FileInputStream(path);
      in = new ObjectInputStream(fis);
      
      accountsByAccountNo = (Map<String, Account>) in.readObject();
      accountsByName = (Map<String, Account>) in.readObject();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        in.close();
        fis.close();
        System.out.println("불러오기 완료");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}


// 계좌
class Account implements Serializable {
  private String accountNo; // 계좌번호
  private String name; // 소유자명
  private long balance; // 잔고
  private ArrayList<Transaction> transaction; // 거래내역(0개이상)
  private Calendar cal; // 캘린더
  private SimpleDateFormat dateFormat; // 현재 날짜
  private SimpleDateFormat timeFormat; // 현재 시간

  public Account(String accountNo, String name) {
    this.accountNo = accountNo;
    this.name = name;
    this.balance = 0;
    this.transaction = new ArrayList<Transaction>();
    cal = Calendar.getInstance();
    dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    timeFormat = new SimpleDateFormat("HH:mm:ss");
  }

  public String getAccountNo() {
    return accountNo;
  }

  public String getName() {
    return name;
  }

  // 입금한다
  public void deposit(long amount) {
    this.balance += amount;
    transaction.add(new Transaction(dateFormat.format(cal.getTime()),
        timeFormat.format(cal.getTime()), "입금", amount, balance));
  }

  // 출금한다
  public void withdraw(long amount) {
    if (balance < amount) {
      System.out.println("잔고가 부족합니다");
    } else {
      this.balance -= amount;
      transaction.add(new Transaction(dateFormat.format(cal.getTime()),
          timeFormat.format(cal.getTime()), "입금", amount, balance));
    }
  }

  // 잔고를 확인한다
  public long getBalance() {
    return balance;

  }

  // 거래내역을 본다
  public ArrayList<Transaction> getTransactions() {
    return transaction;

  }

  @Override
  public String toString() {
    return "계좌번호 = " + accountNo + ", 소유자 = " + name + ", 잔고 = " + balance + ", "
        + getTransactions() + "\n";
  }
}


// 거래내역
class Transaction {
  private String transactionDate; // 거래일
  private String transactionTime; // 거래시간
  private String kind; // 구분(입금 또는 출금)
  private long amount; // 거래금액
  private long balance; // 잔고

  public Transaction(String transactionDate, String transactionTime, String kind, long amount,
      long balance) {
    this.transactionDate = transactionDate;
    this.transactionTime = transactionTime;
    this.kind = kind;
    this.amount = amount;
    this.balance = balance;
  }

  @Override
  public String toString() {
    return "거래일 = " + transactionDate + ", 거래시간 = " + transactionTime + ", 구분 = " + kind
        + ", 거래금액 = " + amount + ", 잔고 = " + balance + "\n";
  }

}


public class BankIO {

  public static void main(String[] args) {
    Bank bank = new Bank();
//    bank.addAccount("110398349277", "권태환");
//    bank.addAccount("110234598373", "정진호");
//    bank.addAccount("110859342648", "김동민");
//    bank.addAccount("110759835759", "우세림");
//    bank.addAccount("110874950438", "장지훈");
//    bank.addAccount("110847247358", "윤종석");

    bank.getAccount("110398349277"); // 계좌번호로 계좌찾기
    bank.findAccount("권태환"); // 예금주로 계좌찾기
    bank.getAccounts();
//    bank.save();
    bank.load();
    bank.getAccounts();
    System.out.println("총 계좌수 : " + bank.getTotalAccount()); // 등록되어있는 계좌 개수
//    bank.getAccounts().get(0).deposit(1000);
//    bank.getAccounts().get(0).withdraw(200);
//    System.out.println(bank.getAccounts().get(0).getBalance());
//    System.out.println(bank.getAccounts().get(0).getTransactions());

  }

}
