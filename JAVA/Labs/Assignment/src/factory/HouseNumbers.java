package factory;

public class HouseNumbers extends Numbers {
	
	public HouseNumbers() {
		numbers = new int[4];
	}

	@Override
	public void getWinner() {
		System.out.println("번호 " + numbers.length + "개 맞춰서 우승!");
	}

	@Override
	public void giveMoney() {
		System.out.println("상금은 이 정도입니다.");
	}

}
