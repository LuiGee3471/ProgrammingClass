class HamburgerSet {
	private String potatoSize;
	private String drink;
	private int patty;
	
	HamburgerSet() {
		this("R", "coke", 1);
		System.out.println("기본");
	}
	
	HamburgerSet(String potatoSize, String drink) {
		this(potatoSize, drink, 1);
		System.out.println("감자튀김, 음료");
	}
	
	HamburgerSet(String drink) {
		this("R", drink, 1);
		System.out.println("음료");
	}
	
	HamburgerSet(String potatoSize, String drink, int patty) {
		this.potatoSize = potatoSize;
		this.drink = drink;
		this.patty = patty;
		System.out.println("전부");
	}
}


public class ThisPractice {

	public static void main(String[] args) {
		HamburgerSet hs = new HamburgerSet();
		HamburgerSet hs2 = new HamburgerSet("L", "soda");
		HamburgerSet hs3 = new HamburgerSet("lemon");
		HamburgerSet hs4 = new HamburgerSet("S", "soda", 3);

	}

}
