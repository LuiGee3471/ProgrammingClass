
public class Ex02_Exception {
	public static void main(String[] args) {
		int num = 100;
		int result = 0;
		
		// 예외 처리
		try {
			for (int i = 0; i < 10; i++) {
				result = num / (int) (Math.random() * 10); // 0 ~ 9
				System.out.println("result : " + result + " i : " + i);
			}
		} catch (ArithmeticException e) { // 가독성이 떨어지는 코드 : 무슨 예외인지 알 수 없다
			System.out.println("연산 예외 : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("나머지 예외");
		}
		
		// 여러 개의 catch 블럭을 만들 수 있다
		// 하위 예외 블럭이 항상 상위 예외 블럭 위에 있어야 한다
		
		System.out.println("Main End");
	}
}
