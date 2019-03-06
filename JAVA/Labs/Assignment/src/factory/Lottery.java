package factory;

public abstract class Lottery {
	int prize;
	
	protected abstract Numbers getNumbers(); // factory method
	
	public void givePrize() {
		Numbers numbers = getNumbers();
		numbers.getWinner();
		numbers.giveMoney();
		System.out.println(prize + "원");
	}
}
