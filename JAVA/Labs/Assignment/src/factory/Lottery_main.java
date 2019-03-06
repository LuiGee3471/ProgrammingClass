package factory;

public class Lottery_main {

	public static void main(String[] args) {
		Lottery l1 = new Lotto();
		Lottery l2 = new HouseLottery();
		
		l1.givePrize();
		l2.givePrize();
	}
}
