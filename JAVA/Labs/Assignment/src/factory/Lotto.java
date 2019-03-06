package factory;

public class Lotto extends Lottery {
	
	public Lotto() {
		prize = 1000000000;
	}

	@Override
	protected Numbers getNumbers() {
		return new LottoNumbers();
	}
}
