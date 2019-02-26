/*
 * 카페의 매출을 관리하는 솔루션 개발
 * =================================
 * 카페는 2종류의 커피와 2종류의 차를 팔고 있습니다.
 * 
 * 커피와 차는 각각 고유의 가격을 가지고 있습니다.
 * 커피는 Americano, CaffeLatte라는 이름을 가지고 있습니다.
 * 차는 Chamomile, MilkTea라는 이름을 가지고 있습니다.
 * Coffee 클래스와 Tea 클래스가 존재한다.
 * 커피 2종류와 차 2종류는 Coffee 클래스와 Tea 클래스를 상속한다.
 * ex) Americano - 2000원, MilkTea - 3000원
 * 
 * 시뮬레이션 시나리오
 * 카페 : 매출 정보를 가지고 있다.
 * 예 : 현재까지 매출 5000원
 * 카페는 음료(Drink)를 판다. 음료를 팔면 매출이 증가한다.
 * 매출은 0으로 시작한다.
 * 음료를 파는 함수는 sell 하나만 만들어 사용한다.
 */
class Drink {
	int price;
	
	Drink(int price) {
		this.price = price;
	}
}

class Coffee extends Drink {
	Coffee(int price) {
		super(price);
	}
}

class Tea extends Drink {
	Tea(int price) {
		super(price);
	}
}

class Americano extends Coffee {
	Americano() {
		super(2000);
	}

	@Override
	public String toString() {
		return "아메리카노";
	}
}

class CaffeLatte extends Coffee {
	CaffeLatte() {
		super(2500);
	}
	@Override
	public String toString() {
		return "카페라떼";
	}
}

class Chamomile extends Tea {
	Chamomile() {
		super(3000);
	}
	
	@Override
	public String toString() {
		return "캐모마일";
	}
}

class MilkTea extends Tea {
	MilkTea() {
		super(2500);
	}
	
	@Override
	public String toString() {
		return "밀크티";
	}
}

class Cafe {
	int sales = 0;
	
	void sell(Drink drink) {
		this.sales += drink.price;
		System.out.println(drink.toString() + " 판매했습니다.");
		System.out.println("현재까지 매출은 " + this.sales + "원입니다.");
	}
}

public class CafeSales {
	public static void main(String[] args) {
		Cafe cafe = new Cafe();
		Americano americano = new Americano();
		CaffeLatte caffelatte = new CaffeLatte();
		Chamomile chamomile = new Chamomile();
		MilkTea milktea = new MilkTea();
		
		cafe.sell(americano);
		System.out.println();
		cafe.sell(caffelatte);
		System.out.println();
		cafe.sell(chamomile);
		System.out.println();
		cafe.sell(milktea);
	}
}
