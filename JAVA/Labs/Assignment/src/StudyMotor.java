
public class StudyMotor {
	private String brand;
	private int modelNumber;
	private static int totalMotor;
	
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setNumberBrand(int a, String b) {
		setModelNumber(a);
		setBrand(b);
		totalMotor++;
		System.out.printf("모터의 브랜드 : %s, 모델번호 : %d\n", b, a);
		System.out.println("지금까지 만들어진 모터는 총 " + totalMotor + " 개");
	}

	public static void howManyMotor() {
		System.out.println("지금까지 만들어진 모터는 총 " + totalMotor + " 개");
	}
}
