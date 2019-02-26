/*
 * Today's Point : [상속 관계]에서의 Override : 상속 관계에서의 method를 재정의***
 * - 상속 관계에서 자식 클래스가 부모 클래스의 메소드를 재정의
 * - 재정의 : 함수의 형태는 변화가 없고 내용만 바뀌는 것 (형태가 바뀌면 overload)
 *            틀의 변화가 아니라 내용의 변화다 { 함수의 실행 블럭을 변경 }
 *            
 * 문법)
 * 전제 : 상속 관계에서
 * 1. 부모 함수의 이름과 동일해야 한다.
 * 2. 부모 함수의 parameter가 동일해야 한다.
 * 3. 부모 함수의 return Type이 동일해야 한다.
 * 4. 결국에는 { } 안의 내용만 바뀐다.
 */

class Point2 {
	int x = 4;
	int y = 5;
	String getPosition() {
		return "x: " + this.x + " y: " + this.y;
	}
}

// 3개의 점이 필요하다
// 이미 2개의 점을 가지고 있는 설계도가 있다
class Point3D extends Point2 {
	int z = 6;
	// String getPosition3D() { return null; }
	// 또 하나의 이름을 가진 함수를 만들고 싶지 않아요
	// 부모가 출력하는 함수를 가지고 있다.

	@Override
	String getPosition() {
		// TODO Auto-generated method stub
		return "x: " + this.x + " y: " + this.y + " z: " + this.z;
	}

	// 재정의 강제하는 방법
	// @Override 선언(Annotation)
	// Annotation : Java에서 코드만으로 전달할 수 없는 부가적인 정보
	// 컴파일러나 개발 툴에게 전달
	
//	@Override // 재정의 검사 >> 컴파일러나 툴에게 정보 전달
//	String getPosition() {
//		return "x: " + this.x + " y: " + this.y + " z: " + this.z; 
//	}
	
}

public class Ex04_Inherit_Override {

	public static void main(String[] args) {
		Point3D point = new Point3D();
		point.x = 3;
		point.y = 6;
		point.z = 9;
		String result = point.getPosition();
		System.out.println(result);

	}

}
