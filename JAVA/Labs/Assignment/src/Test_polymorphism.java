/*
요구사항
카트 (Cart)
카트에는 매장에 있는 모든 전자제품을 담을 수 있다 
카트의 크기는 고정되어 있다 (10개) : 1개  , 2개 담을 수 있고 최대 10개까지 담을 수 있다
고객이 물건을 구매 하면 ... 카트에 담는다

계산대에 가면 전체 계산
계산기능이 필요
summary() 기능 추가해 주세요
당신이 구매한 물건이름 과 가격정보 나열
총 누적금액 계산 출력

hint) 카트 물건을 담는 행위 (Buy())
hint) Buyer ..>> summary()  main 함수에서 계산할때

구매자는 default 금액을 가지고 있고 초기금액을 설정할 수도 있다
*/

class Product { // 전자제품
	int price;
	int bonuspoint;

	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
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
		super(100);
	}

	@Override
	public String toString() {
		return "Notebook";
	}
}

class Buyer {
	int money;
	int bonuspoint;
	
	Product[] cart = new Product[10];
	int productInCart = 0;

	Buyer() {
		this(20000, 0);
	}
	
	Buyer(int money, int bonuspoint) {
		this.money = money;
		this.bonuspoint = bonuspoint;
	}

	void Buy(Product product) {
		if (this.productInCart == this.cart.length) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}

		cart[this.productInCart++] = product;
		System.out.println("카트에 " + product.toString() + "를 담았습니다.");
//		this.productInCart++;
	}

	void summary() {
		int total = 0;
		int totalpoint = 0;
		
		System.out.println("계산서");
		
		for (int i = 0; i < this.productInCart; i++) {
			System.out.printf("%s : %d원\n", cart[i].toString(), cart[i].price);
			total += cart[i].price;
			totalpoint += cart[i].bonuspoint;
		}
		
		System.out.println();
		System.out.println("총 구매 물품 수 : " + this.productInCart + "개");
		System.out.println("총 금액 : " + total + "원");
		System.out.println();

		if (total > this.money) {
			System.out.println("잔액이 부족합니다.");
		} else {
			System.out.println("구매가 완료되었습니다.");
			this.money -= total;
			this.bonuspoint += totalpoint;
			System.out.println("잔액은 " + this.money + "원입니다.");
			System.out.println("누적 포인트는 " + totalpoint + "P입니다.");
		}
	}
}

public class Test_polymorphism {
	public static void main(String[] args) {
		Buyer buyer = new Buyer(16000, 0);
		KtTv tv = new KtTv();
		Audio audio = new Audio();
		Notebook notebook = new Notebook();

		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(audio);
		// 10
		buyer.Buy(audio);
//		buyer.Buy(notebook);
//		buyer.Buy(tv);
//		buyer.Buy(tv);
//		buyer.Buy(audio);
//		buyer.Buy(audio);
//		buyer.Buy(notebook);
//		buyer.Buy(audio);
		System.out.println();

		buyer.summary();
	}
}