package factory;

public class HouseLottery extends Lottery {

	public HouseLottery() {
		prize = 2000000;
	}
	
	@Override
	protected Numbers getNumbers() {
		return new HouseNumbers();
	}

}
