package kr.or.bit;

public class AirPlane {
	private String name;
	private int number;
	private static int planesMade;
	
	public AirPlane(String name, int number) {
		this.name = name;
		this.number = number;
		planesMade++; // static은 가능하면 this를 붙이지 말자
	}
	
	public void airPlaneInfo() {
		System.out.printf("이름 : %s, 번호 : %d\n", this.name, this.number);
	}
	
	public void totalCount() {
		System.out.println(planesMade);
	}
	
//	public void planeInfo() {
//		System.out.printf("이름 : %s, 번호 : %d\n", name, number);
//	}
//	
//	public void complete() {
//		planesMade++;
//		planeInfo();
//		System.out.println("지금까지 만들어진 비행기 : " + AirPlane.planesMade + "대");
//	}

}
