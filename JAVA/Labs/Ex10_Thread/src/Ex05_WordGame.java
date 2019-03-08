import javax.swing.JOptionPane;

/*
 * 문제
 * main 함수 제외한 Thread 2개 생성
 * 1. 시간(time) 제어하는 Thread
 * 2. 단어 입력을 처리하는 Thread
 * 
 * main 함수에서 2개의 Thread start()
 * 
 * 단, 단어를 하나라도 입력해서 확인 버튼을 누르면 시간을 멈추고
 * 프로그램이 종료되게 하세요
 * 
 * Hint : static 자원 활용
 */

class Timer extends Thread {
	@Override
	public void run() { // main() 역할
		for (int i = 10; i > 0; i--) {
			if (Ex05_WordGame.inputCheck) {
				return;
			}
			System.out.println("남은 시간 : " + i);
			try {
				Thread.sleep(1000); // CPU를 점유하는 너는 잠깐 쉬어
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class WordInput extends Thread {
	String inputData;

	@Override
	public void run() {
		inputData = JOptionPane.showInputDialog("값을 입력하세요");
		Ex05_WordGame.inputCheck = true;
		System.out.println("입력값 : " + inputData);
	}
}

public class Ex05_WordGame {
	static boolean inputCheck = false;

	public static void main(String[] args) {
		Timer t = new Timer();
		WordInput wi = new WordInput();
		
		wi.start();
		t.start();
	}
}
