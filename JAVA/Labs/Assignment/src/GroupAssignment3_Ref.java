import java.util.Scanner;
public class GroupAssignment3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int player;
		int computer = (int)(Math.random() * 3) + 1;
		
		System.out.println("가위, 바위, 보를 입력하세요.");
		String rpsPlayer = sc.nextLine();
		String rpsCom;
		
		if (computer == 1)
			rpsCom = "가위";
		else if (computer == 2) 
			rpsCom = "바위";
		else
			rpsCom = "보";
		
		if (rpsPlayer.equals("가위")) {
			player = 1;
		} else if (rpsPlayer.equals("바위")) {
			player = 2;
		} else if (rpsPlayer.equals("보")) {
			player = 3;
		} else {
			System.out.println("가위, 바위, 보를 제대로 입력하세요.");
			return;
		}
		
		if (player == computer) {
			System.out.printf("사용자 : %s, 컴퓨터 : %s\n", rpsPlayer, rpsCom);
			System.out.println("비겼습니다.");
		} else if (player - computer == 1 || player - computer == -2) {
			System.out.printf("사용자 : %s, 컴퓨터 : %s\n", rpsPlayer, rpsCom);
			System.out.println("이겼습니다.");
		} else {
			System.out.printf("사용자 : %s, 컴퓨터 : %s\n", rpsPlayer, rpsCom);
			System.out.println("패배했습니다!");
		}
	}
}
