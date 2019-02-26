/*
 * 출력

메뉴
1. 자리 예매
2. 내 자리 확인
3. 빈 자리 확인
4. 자리 변경
5. 종료

자리 예매
자리의 열을 선택해주세요 (1~3)
(입력)
자리의 번호를 선택해주세요 (1~3)
(입력)
[성공] : 선택한 자리가 예매되었습니다.
[실패] : 이미 예약된 자리입니다.

내 자리 확인
내 자리 있음 : 예매하신 자리는 [ ]열 [ ]번 자리입니다
내 자리 없음 : 예매하신 자리가 존재하지 않습니다.

빈 자리 확인
[1][2][3]
[X][X][6]
[7][8][9]

자리 변경
변경할 자리의 열을 선택해주세요
(입력)
변경할 자리의 번호를 선택해주세요
(입력)
[성공] : 선택한 자리로 변경되었습니다.
[실패] : 이미 예약된 자리입니다.


종료
예매 시스템을 종료합니다
 */
package movie;

import java.util.Scanner;

public class Reservation { // 예매 시스템
	private Scanner sc = new Scanner(System.in);
	private Seat mySeat;
	private static Seat[][] seats;

	static {
		seats = new Seat[3][3];
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				Seat seat = new Seat();
				seats[i][j] = seat;
				seat.setSeatRow(i + 1);
				seat.setSeatCol(j + 1);
			}
		}
	}

	private void reserveSeat() { // 자리 예매
		/*
		 * (내 자리 있음) // mySeat != null
         * "자리 변경을 이용하세요"
		 * 
		 * (없음) // mySeat == null 
		 * 자리 열 입력 
		 * 자리 줄 입력 
		 * seat[열][줄] => 여기로 예약 
		 * 내 자리 = 선택한 자리
		 */
		if (mySeat != null) {
			System.out.println("좌석 변경을 이용하세요. (1 ~ 3)");
		} else {
			try {
				System.out.println("원하는 좌석의 열을 입력하세요. (1 ~ 3)");
				int row = Integer.parseInt(sc.nextLine()) - 1;  // 1번 줄을 선택했을때 [0]번 줄을 선택하기 위한 -1
				System.out.println("원하는 좌석의 번호를 입력하세요.");
				int col = Integer.parseInt(sc.nextLine()) - 1;
				if ((row >= 0 && row <= 2) && (col >= 0 && col <= 2)) {
					if (seats[row][col].isReserved()) {
						System.out.println("이미 예약된 좌석입니다.");
					} else {
						mySeat = seats[row][col];
						mySeat.setReserved(true);
						System.out.printf("선택하신 좌석, %d열 %d번째 좌석 예매가 완료되었습니다.\n", mySeat.getSeatRow(), mySeat.getSeatCol());
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}		
	}

	private void mySeat() { // 내 자리 확인
		if (mySeat != null) {
			System.out.printf("예약하신 자리는 %d열 %d번째 자리입니다\n", mySeat.getSeatRow(), mySeat.getSeatCol());
		} else {
			System.out.println("예약하신 자리가 없습니다.");
		}
	}

	private void checkSeat() { // 빈 자리 확인
		/*
		 * (빈 자리)
		 * 번호 표시
		 * 
		 * (주인 있는 자리) 
		 * X 표시 
		 * "[1][2][X]" 
		 * "[1][2][3]" 
		 * "[X][2][3]"
		 */
		System.out.println("이미 예약된 자리는 X로 표시됩니다");
		System.out.println();
		System.out.println("     [=======Screen=======]");
		System.out.println();
		for (int i = 0; i < seats.length; i++) {
			System.out.printf("%d열\t   ", i + 1);
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].isReserved()) {
					System.out.print("[X]");
				} else {
					System.out.printf("[%d]", seats[i][j].getSeatCol());
				}
			}
			System.out.println();
		}
	}

	private void changeSeat() { // 자리 변경
		/*
		 * (내 자리 없음) 
		 * "좌석 예매를 먼저 해주세요"
		 * 
		 * (내 자리 있음) 
		 * 변경할 자리 선택하세요 
		 * 자리 열 입력 
		 * 자리 줄 입력 
		 * 원래 내 자리 주인 => 없음 
		 * 내 자리 = 새롭게 선택한 자리
		 */
		if (mySeat == null) {
			System.out.println("좌석 예매를 먼저 해주세요.");
		} else {
			try {
				System.out.println("변경할 좌석의 열을 입력하세요. (1 ~ 3)");
				int row = Integer.parseInt(sc.nextLine()) - 1;
				System.out.println("변경할 좌석의 번호를 입력하세요. (1 ~ 3)");
				int col = Integer.parseInt(sc.nextLine()) - 1;
				if ((row >= 0 && row <= 2) && (col >= 0 && col <= 2)) {
					if (seats[row][col].isReserved()) {
						System.out.println("이미 예약된 좌석입니다.");
					} else {
						mySeat.setReserved(false);
						mySeat = seats[row][col];
						mySeat.setReserved(true);
						System.out.printf("선택하신 좌석, %d열 %d번째 좌석으로 변경 완료되었습니다.\n", mySeat.getSeatRow(),
								mySeat.getSeatCol());
					}
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해주세요.");
			}
		}
	}

	private void menuUI() { // 메뉴 그림
		System.out.println("영화 예매");
		System.out.println();
		System.out.println("1. 좌석 예매");
		System.out.println("2. 내 자리 확인");
		System.out.println("3. 빈 자리 확인");
		System.out.println("4. 자리 변경");
		System.out.println("5. 종료");
		System.out.println();
	}

	private int menuSelect() { // 메뉴에서 입력한 번호 받는 함수
		int menu;
		do {
			try {
				menuUI();
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <= 5) {
					break;
				} else {
					throw new Exception("입력 값 문제");
				}
			} catch (Exception e) {
				System.out.println("올바른 숫자를 입력해주세요.");
				System.out.println();
			}
		} while (true);
		return menu;
	}

	public void reservation() { // 예매하기
		/*
		 * while() {
		 * 
		 * 1 입력: 자리 예매();
		 * 
		 * 2 입력: 내 자리 확인();
		 * 
		 * 3 입력: 빈 자리 확인();
		 * 
		 * 4 입력: 자리 변경();
		 * 
		 * 5 입력: 종료;
		 * 
		 * 다른 값 입력:1~5 를 입력하세요
		 */
		Main: while (true) {
			switch (menuSelect()) {
			case 1:
				reserveSeat();
				System.out.println();
				break;
			case 2:
				mySeat();
				System.out.println();
				break;
			case 3:
				checkSeat();
				System.out.println();
				break;
			case 4:
				changeSeat();
				System.out.println();
				break;
			case 5:
				System.out.println("예매를 종료합니다.");
				System.out.println();
				break Main;
			}
		}
	}
}
