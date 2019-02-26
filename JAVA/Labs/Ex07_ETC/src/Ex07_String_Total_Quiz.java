import java.util.Scanner;

// main 함수 scanner 사용 주민번호 입력받고
// 앞 6자리 뒤 7자리
// 입력값 : 123456-12345678
// 1. 자리수 체크 기능 함수 (14 OK)
// 2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능
// 3. 뒷번호 첫번째 자리값을 가지고 1,3 남자, 2,4 여자 출력 기능 함수
// 3개의 함수 static으로

public class Ex07_String_Total_Quiz {
	static String ssnSecond(String ssn) {
		return ssn.substring(ssn.indexOf("-") + 1);
	}
	
	static boolean ssnCheck(String ssn) {
		String ssnFirst = ssn.substring(0, ssn.indexOf("-"));
		return (ssn.length() == 14 && ssnFirst.length() == 6 && ssnSecond(ssn).length() == 7);
	}
	
	static boolean secondCheck(String ssn) {
		int check = Integer.parseInt(ssnSecond(ssn).split("")[0]);
		return check >= 1 && check <= 4;
	}
	
	static void genderPrint(String ssn) {
		switch (ssnSecond(ssn).charAt(0)) {
		case '1':
		case '3':
			System.out.println("남자");
			break;
		case '2':
		case '4':
			System.out.println("여자");
			break;
		}
	}

	public static void main(String[] args) {
	    String ssn;
	    do {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("번호 입력");
	    	ssn = sc.nextLine();
	    	if (ssnCheck(ssn) && secondCheck(ssn))
	    	    genderPrint(ssn);
	    	else
	    		System.out.println("올바른 주민번호가 아닙니다.");
		} while (!(ssnCheck(ssn) && secondCheck(ssn)));
	}
}
