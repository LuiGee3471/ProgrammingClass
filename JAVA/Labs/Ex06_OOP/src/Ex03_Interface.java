/*
 * 추상 클래스와 인터페이스의 공통점
 * 1. 스스로 객체 생성이 불가능하다 (new 연산자 사용 불가)
 * 2. 상속, 구현을 통해서만 사용 가능하다
 * 3. 재정의 통한 강제 구현이 목적
 * 
 * 추상 클래스와 인터페이스의 차이점
 * 1. 인터페이스는 유일하게 다중 상속이 가능
 *    ex) interface Ia, interface Ib
 *        class Child implements Ia, Ib, Ic
 * 2. 추상 클래스는 단일 상속이 원칙
 * 3. 추상 클래스 (완성된 코드 + 미완성된 코드)
 * 4. 인터페이스는 상수를 제외한 나머지는 미완성 코드
 * 
 * 인터페이스 간에는 상속이 가능 (다중도 가능)
 * interface Ia extends Ib, Ic, Id
 * 하나의 클래스는 여러 개의 인터페이스를 구현할 수 있다
 * class Child implements Ia, Ib, Ic
 * 
 * *********************************************************
 * 개발자 입장
 * 
 *   1. 인터페이스를 [다형성] 입장에서 접근 : 인터페이스는 무조건 부모 타입이다
 *   2. 서로 연관성이 없는 클래스에 대해서 하나로 묶는 기능 : 부모가 동일하다
 *   3. 인터페이스는 (~able) : 날 수 있는, 수리할 수 있는... (설계)
 *   4. 객체 간의 연결 고리 (객체 간 소통 역할)
 */

interface Irepairable {} // I~ , ~able(~할 수 있는)

class Unit2 {
	int hitpoint;
	final int MAX_HP;

	Unit2(int hp) {
		this.MAX_HP = hp;
		this.hitpoint = MAX_HP;
	}

}

// 지상 유닛
class GroundUnit extends Unit2 {

	GroundUnit(int hp) {
		super(hp);
	}

}

class AirUnit extends Unit2 {

	AirUnit(int hp) {
		super(hp);
	}

}

class Tank2 extends GroundUnit implements Irepairable {

	Tank2() {
		super(100);
	}

	@Override
	public String toString() {
		return "Tank2";
	}

}

class Marine2 extends GroundUnit {

	Marine2() {
		super(50);
	}

	@Override
	public String toString() {
		return "Marine2";
	}

}

class CommandCenter implements Irepairable {
	int hitpoint;
	final int MAX_HP;

	CommandCenter() {
		this.MAX_HP = 1500;
		this.hitpoint = this.MAX_HP;
	}

	@Override
	public String toString() {
		return "CommandCenter";
	}
}

class SCV extends GroundUnit implements Irepairable {

	SCV() {
		super(60);
	}

	@Override
	public String toString() {
		return "SCV";
	}

	// 특수하고 구체화되고 실체화된 기능
	// 수리할 수 있다 (repair)

//	void repair(Tank2 tank) {
//		if (tank.hitpoint != tank.MAX_HP) {
//			tank.hitpoint += 5;
//		}
//	}
//	
//	void repair(SCV scv) {
//		if (scv.hitpoint != scv.MAX_HP) {
//			scv.hitpoint += 5;
//		}
//	}

	// SCV는 유닛의 개수만큼 repair를 가지고 있어야 한다
	// unit 추가 시 repair 함수도 추가
	// 고민은 하나의 함수로 다른 모든 유닛을 수리
	// 1. 제시 : void repair(GroundUnit unit) ... Marine2, CommandCenter는 수리 불가능
	// 2. 제시 : void repair(Irepairable ir) {}
	//           Irepairable 부모타입 --> SCV, CommandCenter, Tank2
	//    고민 : ir 참조변수가 접근할 수 있는 자원이 없다

	void repair(Irepairable ir) {
		// 1. Tank2, Scv, CommandCenter
		// if (scv.hitpoint != scv.MAX_HP) { scv.hitpoint += 5 };
		
		// 부모 타입의 변수 = 자식 타입의 주소
		// Tv t = new TV();
		// Product product = (Product) t; // casting 생략
		// Tv t2 = (Tv) product; // 명시적 캐스팅
		
		/*
		 * Irepairable
		 *     ㅣ
		 *   Object
		 *     ㅣ
		 *   Unit2
		 *     ㅣ
		 * GroundUnit
		 *     ㅣ
		 *   Tank2
		 */
		
		// 들어오는 객체의 타입을 비교 판단
		
//		System.out.println(ir.toString() + " " + ir.getHitpoint() + "/" + ir.getMAX_HP());
//		if (ir.getHitpoint() != ir.getMAX_HP()) {
//			ir.plusHitpoint(5);
//			System.out.println(ir.toString() + " 체력 5 수리");
//		}
//		System.out.println(ir.toString() + " " + ir.getHitpoint() + "/" + ir.getMAX_HP());
		if (ir instanceof Unit2) { // 체크 안하면 CommandCenter에서 오류
			// downcasting Irepairable -> Unit2
			Unit2 unit = (Unit2) ir;
			System.out.println(unit.toString());
			System.out.println(unit.hitpoint + "/" + unit.MAX_HP);
			if (unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			}
			System.out.println(unit.toString());
			System.out.println(unit.hitpoint + "/" + unit.MAX_HP);
		} else if (ir instanceof CommandCenter){
			// CommandCenter 객체의 주소
			CommandCenter cc = (CommandCenter) ir;
			System.out.println(cc.toString());
			System.out.println(cc.hitpoint + "/" + cc.MAX_HP);
			if (cc.hitpoint != cc.MAX_HP) {
				cc.hitpoint = cc.MAX_HP;
			}
			System.out.println(cc.toString());
			System.out.println(cc.hitpoint + "/" + cc.MAX_HP);
		}
	}
}

public class Ex03_Interface {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		CommandCenter cc = new CommandCenter();
		SCV scv1 = new SCV();
		SCV scv2 = new SCV();
		
		tank.hitpoint -= 20;
		scv1.repair(tank);
		
		// scv1.repair(marine);
		
		cc.hitpoint -= 400;
		scv1.repair(cc);
		
		scv2.hitpoint -= 30;
		scv1.repair(scv2);
	}
}
