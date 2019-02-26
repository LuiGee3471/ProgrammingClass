import kr.or.bit.AirPlane;

/*
 * 우리 회사는 비행기를 주문제작판매하는 회사입니다.
 * 우리 회사는 비행기를 생산하는 설계도를 작성하려고 합니다.
 * 
 * 사장님의 요구사항
 * 1. 비행기를 생산하면 비행기에 이름과 번호를 부여해야 한다. (ex.대한항공 707, 아시아나 808)
 * 2. 비행기가 생산되면 비행기의 이름과 맞게 부여됐는지 확인하는 기능이 필요하다. (출력)
 * 3. 비행기가 출고될 때마다 비행기의 누적 대수를 확인할 수 있다.
 * 
 * 비행기를 만든다 = (AirPlane air = new AirPlane();)
 * 
 * 설계도는 지금까지 배운 코드로만 작성... (최소한 3대)
 * kr.or.bit.AirPlane 이름으로 작성
 * 
 */
public class Ex06_Static_AirPlane {

	public static void main(String[] args) {
//		AirPlane p = new AirPlane();
//		p.name = "대한항공";
//		p.number = 707;
//		p.complete();
//		
//		AirPlane p2 = new AirPlane();
//		p2.name = "아시아나";
//		p2.number = 808;
//		p2.complete();
//		
//		AirPlane p3 = new AirPlane();
//		p3.name = "제주항공";
//		p3.number = 1007;
//		p3.complete();
		
		AirPlane p = new AirPlane("대한항공", 707);
		p.airPlaneInfo();
		AirPlane p2 = new AirPlane("아시아나", 808);
		p2.airPlaneInfo();
		p2.totalCount();
	}
}
