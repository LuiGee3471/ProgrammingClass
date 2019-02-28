import java.util.ArrayList;
import java.util.List;

class Product {}

class Tv extends Product {
	@Override
	public String toString() {
		return "Tv";
	}
}

class Audio extends Product {
	@Override
	public String toString() {
		return "Audio";
	}
}

class Notebook extends Product {
	@Override
	public String toString() {
		return "Notebook";
	}
}

public class Ex07_Generic_Quiz {
	public static void main(String[] args) {
		// 1. Array(배열)을 사용해서 cart를 만들고 제품 3개를 담으세요
		// 2. ArrayList를 사용해서 cart 만들고 제품 3개를 담으세요
		
		Product[] cart1 = { new Tv(), new Audio(), new Notebook() };
		List<Product> cart2 = new ArrayList<Product>();
		cart2.add(new Tv());
		cart2.add(new Audio());
		cart2.add(new Notebook());
		
		System.out.print("[");
		for (Product product : cart1) {
			System.out.print(product + ", ");
		}
		System.out.println("]");
		
		System.out.println(cart2);
	}
}
