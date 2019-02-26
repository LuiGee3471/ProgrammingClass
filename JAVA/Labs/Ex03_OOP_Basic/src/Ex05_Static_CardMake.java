import kr.or.bit.Card;

public class Ex05_Static_CardMake {

	public static void main(String[] args) {
		// 53장의 카드 생성
		Card c = new Card();
		c.number = 1;
		c.shape = "heart";
		
		// 변경사항
		c.height = 500;
		c.width = 200;
		c.cardInfo();
		
		Card c2 = new Card();
		c2.number = 10;
		c2.shape = "heart";
		c2.cardInfo();
		// ......
		// 이 때 고객이 요구사항을 변경
		// 카드 크기를 늘려주세요. 높이 : 500, 너비 : 200
		// 53번의 각각의 카드를 수정 작업 필요
		// static
		// 카드 한 장의 변경을 통해서 53장 모든 카드 반영
	}
}
