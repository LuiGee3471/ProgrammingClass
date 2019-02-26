
public class Vacuum {
	public String company;
	public String modelName;
	public String color;
	public String date;
	public int maxBattery;
	
	public int level;
	public boolean power;
	public int currentBattery;
	public int motorSpeed;
	
	Motor motor;
	Charger charger;
	Head head;
	
	public void powerOn() {
		power = true;
	}
	public void powerOff() {
		power = false;
	}
	
	public void showBattery() {
		int battery = (currentBattery / maxBattery) * 100;
		System.out.println("현재 배터리 : " + battery + "%");
	}
	
	public void setLevel(int buttonlevel) {
		System.out.println(buttonlevel+"단계로 설정되었습니다.");
	}
}