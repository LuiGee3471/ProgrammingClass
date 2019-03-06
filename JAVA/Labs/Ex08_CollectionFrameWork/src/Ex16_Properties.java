import java.util.Properties;

/*
 * Map 인터페이스를 구현한 클래스
 * 특수한 목적 : 타입을 강제
 * <String, String> 타입 강제
 * 
 * 사용목적:
 * Application(웹사이트, 그룹웨어 등)의 공통 속성을 정의 (환경 변수, 상수)
 * 1. 프로그램의 버전
 * 2. 파일 경로
 * 3. 공통 변수
 * 4. 다국어 처리
 */

public class Ex16_Properties {
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("master_email", "bit@bit.or.kr");
		prop.setProperty("version", "1.0.0.0");
		prop.setProperty("default_path", "C:\\Temp\\images");
		
		// 사용방법
		System.out.println(prop.getProperty("master_email"));
		System.out.println(prop.getProperty("version"));
		System.out.println(prop.getProperty("default_path"));
		
		// System.out.println(prop.getProperty("master_email")); 코드가 100개 페이지에서 사용
		
	}
}
