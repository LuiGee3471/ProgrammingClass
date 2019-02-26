/*
 * 여러 개의 설계도 작성 시 각각을 연결시켜야 한다(관련성)
 * 
 * 기준점
 * 
 * 상속 관계(Inheritance) : A is B >> ~은 ~이다 (부모가 b, 뒤)
 * - 경찰은 권총이다(X), 원은 도형이다(O), 사각형은 도형이다(O)
 * 
 * class A extends B {}
 * 
 * 포함 관계(Composite)   : A has B >> ~은 ~을 가지고 있다
 * - 경찰은 권총을 가지고 있다(O), 원은 도형을 가지고 있다(X), 사각형은 도형을 가지고 있다(X)
 * 
 * class A {
 *     B b;
 * }
 * 
 * ------------------------------------------------------
 * 
 * class 원
 * 
 * class 도형
 * 
 * >> 상속 관계 (원 extends 도형)
 * 
 * 원은 점이다 (X)
 * 점의 정의(x,y)
 * 원은 점을 가지고 있다 (O) >> 포함 관계
 * 
 * class 원 { 점 변수명; }
 * 
 * class 경찰
 * class 총
 * 
 * 경찰은 총이다 (X)
 * 경찰은 총을 가지고 있다 (O)
 * 
 * >> 포함 관계
 * class 경찰 { 총 gun; }
 * ----------------------------------------------------
 * ex)
 * 
 * 원, 사각형, 삼각형을 만드는 설계도를 작성하고 싶다
 * 
 * 원: 한 점, 반지름, 그리다, 색상
 * 삼각형 : 점 세 개, 그리다, 색상
 * 사각형 : 점 네 개, 그리다, 색상
 * 점: (x,y)
 * 
 * 정의
 * 원은 도형이다
 * 삼각형은 도형이다
 * 사각형은 도형이다
 * 
 * 도형 : 일반화되고 추상화된 자원 => 공통분모 : 색상, 그리다
 * 원 : 구체화되고 특수화된 자원 => 원의 특성 : 점과 반지름
 * 
 * 점 정의 (x,y)
 * 원은 점이다 (X)
 * 삼각형은 점이다 (X)
 * 원은 점을 가지고 있다 (O)
 * 삼각형은 점을 가지고 있다 (O)
 * 사각형은 점을 가지고 있다 (O)
 * 
 * 일반화, 추상화(공통 분모) : shape (색상, 그리다)
 *                           : point (x, y)
 * 
 * class Shape {}
 * class Point {}
 * 
 * 구체화, 특수화 (circle, triangle, square)
 * 
 */

class Shape {
	String color = "gold";
	
	void draw() {
		System.out.println("도형을 그리다");
	}
	
	public void printPoint(Point point) {
		System.out.println("(" + point.x + ", " + point.y + ")");
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		this(1, 2);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 원을 만드세요 (한 점과 반지름을 가지고 있다)
// 원은 도형이다
// 원은 점을 가지고 있다

class Circle extends Shape {
	Point center; // member field(부품) >> 포함 관계
	double r; // member field (특수성, 구체화)
	
	public Circle() {
		this(new Point(5, 8), 10);
	}

	public Circle(Point center, double r) {
		this.center = center;
		this.r = r;
	}
}

// 문제 1)
// 삼각형 클래스를 만들어라
// 정의 : 삼각형은 세 개의 점과 색상, 그리다라는 기능을 가지고 있다
// Shape와 Point 활용
// 3개의 (x,y)
// default 삼각형 그리기 + 3개의 좌표값 받고 그리기
// Triangle

class Triangle extends Shape {
	Point[] points;
	
	public Triangle() {
		this(new Point[] { new Point(0, 0), new Point(3, 0), new Point(3, 3) });
	}
	
	public Triangle(Point[] points) {
		this.points = points;
	}
}

public class Ex02_Inherit_Composite {

	public static void main(String[] args) {
		Circle c = new Circle();
		c.draw();
		System.out.println(c.color);
		System.out.println(c.r);
		System.out.println(c.center.x);
		System.out.println(c.center.y);
		
		Point point = new Point(10, 15);
		Circle c2 = new Circle(point, 20);
		c2.draw();
		System.out.println(c2.color);
		System.out.println(c2.r);
//		System.out.println(c2.center.x);
//		System.out.println(c2.center.y);
		c2.printPoint(c2.center);
		
		Triangle t = new Triangle();
		t.draw();
		System.out.println(t.color);
//		System.out.println("(" + t.point1.x + ", " + t.point1.y + ")");
//		System.out.println("(" + t.point2.x + ", " + t.point2.y + ")");
//		System.out.println("(" + t.point3.x + ", " + t.point3.y + ")");
		for (int i = 0; i < t.points.length; i++) {
			t.printPoint(t.points[i]);
		}
		
		Point[] points = { new Point(0, 5), new Point(5, 0), new Point(5, 5) };
		Triangle t2 = new Triangle(points);
		t2.draw();
		System.out.println(t2.color);
//		System.out.println("(" + t2.point1.x + ", " + t2.point1.y + ")");
//		System.out.println("(" + t2.point2.x + ", " + t2.point2.y + ")");
//		System.out.println("(" + t2.point3.x + ", " + t2.point3.y + ")");
		for (Point p : t2.points) {
			t2.printPoint(p);
		}
	}
}
