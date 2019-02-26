
public class StudyFan {
	private String brand;
	private String model;
	private String color;
	private static int price;
	
	private int level;
	private boolean power;
	
	StudyMotor mo;
	
	public void powerOn() {
		power = true;
		System.out.println("전원이 켜졌습니다.");
	}
	
	public void powerOff() {
		power = false;
		System.out.println("전원이 꺼졌습니다.");
	}
	
	public void change(int a) {
		if (a>=1 && a<=3) {
			level = a;
		}
		if (level == 1) {
			System.out.println("1단계입니다.");
		}
	}
	
	public void setMotor(int a, String b) {
		mo = new StudyMotor();
		mo.setNumberBrand(a, b);
	}
}
