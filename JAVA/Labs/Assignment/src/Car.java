
public class Car {
	private String name;
	private int price;
	private int maxSpeed;
	private int maxPower;
	private int oil;
	
	public Car() {
		name = "꼬마자동차 붕붕이";
		price = 100000000;
	}

	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public void setOil(int oil) {
		this.oil = oil;

	}
	
	public void carInfo() {
		System.out.printf("가격 : %d, 연비 : %d, 최고속도 : %d, 최대출력 : %d\n", price, oil, maxSpeed, maxPower);
	}
	
	public void playMusic(String str) {
		System.out.println(str + " 형식으로 음악을 출력합니다.");
	}
}