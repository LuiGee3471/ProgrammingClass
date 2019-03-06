package factory;

public class LottoNumbers extends Numbers {
	
	public LottoNumbers() {
		numbers = new int[6];
	}

	@Override
	public void getWinner() {
		System.out.println("번호 " + numbers.length + "개 맞춰서 우승!");
	}

	@Override
	public void giveMoney() {
		System.out.println("상금은 무려 이만큼");
	}

}
