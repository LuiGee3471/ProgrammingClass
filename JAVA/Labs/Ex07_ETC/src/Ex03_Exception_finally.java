import java.io.IOException;

public class Ex03_Exception_finally {
	static void startInstall() {
		System.out.println("INSTALL");
	}
	
	static void copyFiles() {
		System.out.println("COPY FILES");
	}
	
	static void fileDelete() {
		System.out.println("DELETE FILES");
	}

	public static void main(String[] args) {
		
		try {
			copyFiles();
			startInstall();
			
			// 개발자가 임의로 예외를 생성할 수 있다
			// ex) A, B, C 정상 입력, D 비정상 입력
			// 사용자 예외 던지기 (예외 객체를 개발자가 직접 생성 : new )
			throw new IOException("Install 처리 중 문제 발생");
			
		} catch(Exception e) {
			System.out.println("예외 메시지 출력 : " + e.getMessage());
		} finally { // 예외가 발생하든 발생하지 않든 강제 실행
			fileDelete();
		}
		// 주의사항
		// 함수를 종료시키는 return이 있더라도 finally 블럭은 강제 실행
		
		System.out.println("MAIN END");
	}
}
