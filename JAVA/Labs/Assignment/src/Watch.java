
public class Watch {
	private String brand;
	private int price;
	private int hour;
	private int minute;
	private int second;
	private static int totalCount;
	
	public Watch(int h, int m, int s) {
		brand = "뻐꾸기";
		price = 15000;
		hour = h;
		minute = m;
		second = s;
		totalCount++;
	}
	
	public void setTime(int h, int m) {
		hour = (h >= 0 && h <= 12) ? h : 0;
		minute = (m >= 0 && h < 60) ? m : 0;
	}
	
	public void setTime(int h, int m, int s) {
		hour = (h >= 0 && h <= 12) ? h : 0;
		minute = (m >= 0 && h < 60) ? m : 0;
		second = (s >= 0 && h < 60) ? s : 0;
	}
	
	public void printTime() {
		System.out.printf("%d:%d:%d\n", hour, minute, second);
	}
}
