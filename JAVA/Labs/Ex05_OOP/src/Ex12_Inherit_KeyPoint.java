class Product {
	int price;
	int point;
	
	Product(int price) {
		this.price = price;
		this.point = (int) (price * 0.1);
	}
}

class KtTv extends Product {
	KtTv() {
		super(5000);
	}

	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() {
		super(100);
	}

	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook extends Product {
	Notebook() {
		super(200);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
}

class Buyer {
	int money = 10000;
	int point = 0;
	
	/*
	 * 구매행위
	 * 구매행위(잔액 - 제품의 가격, 포인트 정보 갱신)
	 * 구매자는 매장에 있는 모든 제품을 구매할 수 있어야 한다.
	 * 구매 행위하는 함수
	 * KtTv, Audio, NoteBook 구매 가능
	 */
	
	void buy(Product product) {
		if (product.price <= this.money) {
			this.money -= product.price;
			this.point += product.point;
			System.out.printf("%s 구매 완료\n", product.toString());
			System.out.printf("남은 돈 : %d원\n", this.money);
			System.out.printf("누적 포인트 : %dP\n", this.point);
		} else {
			System.out.println("돈이 부족합니다.");
		}
	}
}

public class Ex12_Inherit_KeyPoint {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		KtTv kttv = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();

		buyer.buy(kttv);
		System.out.println();
		buyer.buy(audio);
		System.out.println();
		buyer.buy(notebook);
		System.out.println();
		buyer.buy(kttv);
	}
}
