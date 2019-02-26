package coffeevendingmachine;

public class VM {

	public static void main(String[] args) {
		//Coffee c = new Coffee("아메리카노", 1, new int[] { 1,1,1,1 }, 1000);
		Machine m = new Machine();
		while (true) {
			Coffee c = m.displayMenu();
			if (c == null)
				continue;
			c = m.setUserRecipe(c);
			m.displaySum(c);
			m.refund(c);
		}
	}
}
