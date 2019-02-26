/*
 * 오류 발생
 * 1. 에러 (error) : 개발자가 해결하지 못하는 문제 ex) 네트워크 장애, 메모리 누수, 하드웨어 이상
 * 2. 예외 (exception) : 로직 제어(0으로 나누기) 등 >> 개발자의 코드 처리 문제 >> 해결 가능..?
 * 2.1 예외가 발생되면 프로그램이 강제 종료
 * 2.2 목적 : 잘못된 코드를 수정하는 것이 아니고 문제 발생 시 비정상적인 종료를 못하게 하는 것
 * 
 * try {
 *     실행 코드
 *     문제 발생
 * } catch (Exception e) {
 *     문제가 발생했으니 문제의 원인을 
 *     1. 출력...
 *     2. 로그에 기록 남기기
 *     3. 관리자에게 이메일 보내기
 * } finally {
 *     예외가 발생하든 안하든 무조건 실행
 *     의무적으로 실행되어야 하는 구문
 *     ex) DB연결 작업 >> 연결 종료
 * }
 * 
 * 개발자는 실행 시 발생할 수 있는 예외에 대해서 처리 (RuntimeException을 처리)
 */

public class Ex01_Exception {
	public static void main(String[] args) {
		/*
		System.out.println("Main Start");
		    System.out.println("Main Logic 처리...");
		        System.out.println(0 / 0); // 비정상 종료
		    System.out.println("Main Logic 처리...");
	    System.out.println("Main End");
	    */
		
		System.out.println("Main Start");
	        System.out.println("Main Logic 처리...");
		try {
			System.out.println(0 / 0);
		} catch (Exception e) { // e 변수가 주소값을 받는다
			// 예외 처리
			// System.out.println("예외 메시지 출력 : " + e.getMessage());
			e.printStackTrace();
			
			// System.out.println(0 / 0); 예외에 맞는 객체가 자동 생성
			// ArithmeticException arithmetic = new ArithmeticException();
			// arithmetic.set(....)
			// java.lang.ArithmeticException : / by zero
		}
		    System.out.println("Main Logic 처리...");
	    System.out.println("Main End");
	}
}
