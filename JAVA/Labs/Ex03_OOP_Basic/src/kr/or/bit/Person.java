package kr.or.bit;

// class == type (큰 타입 : 여러 개를 포함) == 설계도
// 설계도의 기본 구성 요소 : 속성 + 행위
// 속성 : 변수(고유, 상태, 객체), 행위 : 함수
// ** 주의 ** 속성이 하나의 값으로 표현되지 않으면 클래스를 만들어 표현 (ex.자동차 - 엔진)

public class Person {
    public String name; // instance variable (member field)
    public int age;
    
    public void print() { // method (call 호출에 의해서만 동작)
        System.out.println(name + " / " + age);	
    }
}
