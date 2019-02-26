import java.util.Scanner;

class VendingMachine {
	String manufacturer; // 제조사
	String model; // 모델명
	int receivedMoney; // 넣은 금액
	int[] inventory; // 담배 잔고 관리
	int changeAmount; // 잔돈잔액 (일단 이렇게)
	Cigarettes[] cigar; // 담배의 종류가 여러가지이므로 배열 선언
	
	public VendingMachine() {
		Scanner scanner = new Scanner(System.in);
		manufacturer = "자판기코리아";
		model = "담배자판기";
		changeAmount = 100000; // 잔돈 10만원 입력
		cigar = new Cigarettes[] { new Cigarettes("필립모리스", "말보로", 4700), new Cigarettes("BAT", "던  힐", 4500),
				new Cigarettes("필립모리스", "팔리아멘트", 4300), new Cigarettes("KT&G", "레  종", 5000),
				new Cigarettes("KT&G", "에  쎄", 4200) };
		inventory = new int[cigar.length];
		for (int i = 0; i < cigar.length; i++) { // 담배 수량 30개 초기화
			inventory[i] = 30;
		}
	}
	public void operation() {
		while (true) {
			displayMenu();
			while (isAdult() == true) {
				payMenu();
				displayMenu();
				selectCigarettes();
			}
		}
	}
	// 담배메뉴출력
	private void displayMenu() {
		System.out.println("======================================");
		System.out.println("===============담배자판기===============");
		for (int i = 0; i < this.cigar.length; i++) {
			// 재고가 있으면서 잔금보다 작은 담배 버튼 on
			if (this.receivedMoney >= this.cigar[i].cigarPrice && this.inventory[i] > 0) {
				System.out.printf((1 + i) + ". %s (%d원) [o]\n", cigar[i].cigarName, cigar[i].cigarPrice);
			} else {
				System.out.printf((1 + i) + ". %s (%d원) [ ]\n", cigar[i].cigarName, cigar[i].cigarPrice);
			}
		}
		System.out.println("현재 금액 : " + receivedMoney + "원");
	}
	// 성인확인
	private boolean isAdult() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("성인인증이 필요합니다. 출생년도를 입력해주세요!");
		int year = Integer.parseInt(scanner.nextLine());
		boolean adult;
		if (year <= 2000) {
			System.out.println("성인 인증이 완료되었습니다.");
			adult = true;
		} else if (year == 9999) { // 9999입력시 관리자 모드
			adminMenu();
			adult = false;
		} else {
			System.out.println("미성년자는 판매할 수 없습니다.");
			adult = false;
		}
		return adult;
	}
	// 잔돈 반환
	private void changeReturn() { // 반환될잔돈
		System.out.println(receivedMoney + "배출");
		changeAmount -= receivedMoney; // 잔돈계산
		receivedMoney = 0; // 금액 0으로 초기화
	}
	// 담배 선택
	private void selectCigarettes() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("[반환레버0번]\n담배 번호를 선택해주세요>");
			int number = Integer.parseInt(scanner.nextLine());
			if (number == 0) { // 0을 누르면 잔돈 반환
				changeReturn();
				return;
			} else if (number < 0 || number > cigar.length) { // 잘못된 번호 입력시
				System.out.println("번호를 다시 입력해주세요");
			} else {
				if (receivedMoney >= cigar[number - 1].cigarPrice) {
					receivedMoney -= cigar[number - 1].cigarPrice; // 받은돈에서 담배값차감
					inventory[number - 1]--; // 담배 개수 -1
					displayMenu();
					System.out.println(cigar[number - 1].cigarName + "배출!");// 담배배출
				} else {
					displayMenu();
					System.out.println("돈을 더 넣어 주세요!");
				}
			}
		}
	}
	// 돈 투입
	private void payMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("돈을 넣어주세요!");
		receivedMoney = Integer.parseInt(scanner.nextLine());
	}
	// 관리자메뉴
	private void adminMenu() {
		while (true) {
			System.out.println("============================");
			System.out.println("======  관리자 모드 메뉴 ======");
			System.out.println(" 1. 담배재고 확인                   ");
			System.out.println(" 2. 담배채우기                      ");
			System.out.println(" 3. 잔돈재고 확인                   ");
			System.out.println(" 4. 잔돈채우기                      ");
			System.out.println(" 5. 종료                            ");
			Scanner scanner = new Scanner(System.in);
			int menu = Integer.parseInt(scanner.nextLine());
			switch (menu) {
			case 1:
				checkInventory();
				break;
			case 2:
				fillInventory();
				break;
			case 3:
				checkChange();
				break;
			case 4:
				fillChange();
				break;
			case 5:
				return;
			default:
			}
		}
	}
	// 담배수량확인
	private void checkInventory() {
		for (int i = 0; i < inventory.length; i++) {
			System.out.printf("%s : %d \n", cigar[i].cigarName, inventory[i]);
		}
	}
	// 담배채우기
	private void fillInventory() {
		System.out.println("담배가 채워졌습니다.");
		for (int i = 0; i < cigar.length; i++) {
			inventory[i] = 30;
			System.out.printf("%s : %d \n", cigar[i].cigarName, inventory[i]);
		}
	}
	// 잔돈확인
	private void checkChange() {
		System.out.printf("잔돈 : %d \n", this.changeAmount);
	}
	// 잔돈충전
	private void fillChange() {
		this.changeAmount = 100000;
		System.out.printf("잔돈을 %d원으로 충전했습니다.\n", this.changeAmount);
	}
}
class Cigarettes {
	public String cigarMaker; // 제조 회사
	public String cigarName; // 담배 이름
	public int cigarPrice; // 가격
	public Cigarettes(String cigarMaker, String cigarName, int cigarPrice) {
		this.cigarMaker = cigarMaker;
		this.cigarName = cigarName;
		this.cigarPrice = cigarPrice;
	}
}
public class Team1 {
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		vm.operation();
	}
}



