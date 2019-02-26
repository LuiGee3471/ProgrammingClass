package kr.or.bit;

/*
 * 책은 책 이름과 가격을 가지고 있다. => member field : 이름, 가격
 * 책이 출판되면 반드시 책은 책의 이름과 가격을 가지고 있어야 한다. => 생성자(default 금지)
 * 책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고 출판된 이후에는 수정할 수 없다. => 둘 다 출력하는 함수, private, setter 없음
 * 책 이름과 가격 정보를 각각 읽을 수 있다. => getter 존재
 */

public class Book {
	private String name;
	private int price;

	public Book(String str, int i) {
		name = str;
		price = i;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void printNamePrice() {
		System.out.println("이름 : " + name + ", 가격 : " + price);
	}
}

/*
 * 시계는 같은 브랜드와 가격을 가지고 있다
 * 브랜드는 뻐꾸기, 가격은 15000원이다
 * 시계는 만들어질 때 시침, 초침, 분침이 가리키는 시간을 지정해줘야 한다
 * 시계는 만들어질 때마다 누적생산대수가 1대씩 늘어난다.
 * (시:분:초)를 한번에 출력하는 기능을 가지고 있다.
 * 시간은 새로 설정할 수 있고 (시, 분, 초)를 한번에 설정해야한다
 * 시는 (0~12)만, 분은 (0~59)만, 초는 (0~59)만 가능하며 다른 값을 입력하면 0으로 설정된다.
 */

