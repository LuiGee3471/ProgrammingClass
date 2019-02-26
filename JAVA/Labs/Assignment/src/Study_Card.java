class Card {
	public int number;
	public String shape;
	
	public static int width = 10;
	public static int height = 15;
	
	private static int howManyCard;
	
	private void cardInfo() {
		System.out.printf("번호 : %d, 모양 : %s, 너비 : %d, 높이 :%d\n", number, shape, width, height);
	}
	
	public static void setWidthHeight(int newWidth, int newHeight) {
		width = newWidth;
		height = newHeight;
	}
	
	public static void makeCard(int a, String b) {
		Card card = new Card();
		card.number = a;
		card.shape = b;
		card.cardInfo();
		howManyCard++;
	}
}


public class Study_Card {

	public static void main(String[] args) {
		Card.makeCard(10, "heart");
		Card.makeCard(1, "spade"); 
		Card.makeCard(3, "clover");
		Card.makeCard(11, "diamond");
		
		Card.setWidthHeight(30, 45);
		
		Card.makeCard(10, "heart");
		Card.makeCard(1, "spade"); 
		Card.makeCard(3, "clover");
		Card.makeCard(11, "diamond");

	}

}
