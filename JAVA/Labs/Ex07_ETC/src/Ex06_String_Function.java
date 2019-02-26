import java.util.StringTokenizer;

// String 클래스 (다양한 함수)
// 개발에서 많이 사용 (우리가 사용하는 데이터는 대부분 문자열 데이터)

public class Ex06_String_Function {

	public static void main(String[] args) {
		String str = ""; // 문자열 초기화
		
		String[] strarr = { "aaa", "bbb", "ccc" };
		for (String s : strarr) {
			System.out.println(s);
		}
		// String 클래스의 함수
		String ss = "hello";
		String concatstr = ss.concat("world");
		System.out.println(concatstr); //helloworld
		
		// boolean bo = ss.contains("el"); // true
		boolean bo = ss.contains("ele");   // false
		System.out.println(bo);
		
		String ss2 = "a b c d"; // [a][ ][b][ ][c][ ][d]
		System.out.println(ss2.length()); // 7
		
		String filename = "hello java, world";
		System.out.println(filename.indexOf(",")); // 10
		System.out.println(filename.indexOf("java")); // 6
		
		// 활용 : 문장 내에서 내가 원하는 단어가 포함되어 있는지 검증
		// indexOf(단어) >= 0 : 최소한 하나의 단어는 포함
		System.out.println(filename.lastIndexOf("a")); // 9
		System.out.println(filename.lastIndexOf("kglim")); // -1
		// 배열에 값이 없다 >> -1
		// return -1;
		
		// 주로 많이 쓰는 함수
		// length(), indexOf(), substring(), replace(), split()
		String result = "superman";
		System.out.println(result.substring(0)); // superman
		System.out.println(result.substring(5)); // man
		System.out.println(result.substring(0, 0));
		System.out.println(result.substring(0, 1));
		System.out.println(result.substring(1, 1));
		System.out.println(result.substring(2, 3));
		
		// Quiz
		String filename2 = "홍길동.jpg"; // 파일명은 변경될 수 있다
		// 파일명 >> 홍길동
		// 확장자 >> jpg
		// 위에서 배운 것만
		
		System.out.println(filename2.substring(0, filename2.lastIndexOf(".")));
		System.out.println(filename2.substring(filename2.lastIndexOf(".") + 1));
		
		// replace
		String s2 = "ABCD";
		String result4 = s2.replace("A", "안녕");
		System.out.println(result4);
		
		System.out.println(s2.charAt(0));
		System.out.println(s2.charAt(3)); // return char
		System.out.println(s2.endsWith("CD"));
		System.out.println(s2.equalsIgnoreCase("AbCd"));
		
		// POINT
		// split()
		String s6 = "슈퍼맨,팬티,노랑색,우하하,우하하";
		String[] namearray = s6.split(",");
		for (String s : namearray) {
			System.out.println(s);
		}
		
		String filename3 = "bit.hwp";
		String[] array = filename3.split("\\.");
		System.out.println(array.length);
		for (String s : array) {
			System.out.println(s);
		}
		
		// Java, JavaScript, DB >> 정규표현식
		// 000-{\d4}-0000
		// 000-1111-0000 제공 : true
		// 000-11-0000 제공 : false
		
		// 과제 (조당 정규표현식 5개 만들어오기)
		// 주로 많이 쓰이는 것
		// 주민번호, 우편번호, 전화번호, 이메일, ....
		
		String s7 = "a/b,c.d-f";
		StringTokenizer sto = new StringTokenizer(s7, "/,.-");
		while (sto.hasMoreTokens()) {
			System.out.println(sto.nextToken());
		}
		
		// 넌센스 quiz
		String s8 = "홍            길             동";
		// 저장 "홍길동"
		String s8_2 = s8.replace(" ", "");
		System.out.println(s8_2);
		
		String s9 = "          홍길동          ";
		System.out.println(">" + s9 + "<");
		System.out.println(">" + s9.trim() + "<");
		
		String s10 = "        홍         길        동         ";
		String s11 = s10.trim().replace(" ", "");
		System.out.println(s11);
		
		// 여러 개의 함수를 사용할 경우 method chain 기법 사용
		
		// Quiz-1
		int sum = 0;
		String[] numarr = { "1", "2", "3", "4", "5" };
		// 문제: 배열에 있는 문자값들의 합을 sum 변수에 담아서 출력하세요
		for (String number : numarr) {
			sum += Integer.parseInt(number);
		}
		System.out.println(sum);
		
		// Quiz-2
		int sum2 = 0;
		String jumin = "123456-1234567";
		// 위 주민번호의 합을 구하세요
		
		jumin = jumin.replace("-", "");
		
		for (int i = 0; i < jumin.length(); i++) {
			sum2 += Integer.parseInt(jumin.substring(i, i + 1));
		}
		
		System.out.println(sum2);
		
//		for (String s : jumin.split("-")) {
//			for (int i = 0; i < s.length(); i++) {
//				sum2 += Integer.parseInt(s.substring(i, i + 1));
//			}
//		}
//		System.out.println(sum2);
		
//		String[] jumin2 = jumin.split("");
//		for (String number : jumin2) {
//			sum2 += Integer.parseInt(number);
//		}
//		System.out.println(sum2);
	}
}
