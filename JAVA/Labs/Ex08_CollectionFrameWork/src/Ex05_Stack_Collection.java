import java.util.Stack;

import kr.or.bit.Coin;

public class Ex05_Stack_Collection {
	public static void main(String[] args) {
		// LIFO
		// Stack : Collection Framework이 제공하는 클래스
		
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		System.out.println(stack.indexOf("D"));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		// System.out.println(stack.pop()); // java.util.EmptyStackException 발생
		System.out.println(stack.isEmpty()); // true 아무 것도 없어
		
		// 동전 케이스
		// stack 자료구조가 원하는 형태
		Stack<Coin> coinbox = new Stack<>();
		coinbox.push(new Coin(100));
		coinbox.push(new Coin(50));
		coinbox.push(new Coin(500));
		
		// System.out.println(coinbox.pop().getValue());
		while (!coinbox.isEmpty()) {
			Coin coin = coinbox.pop();
			System.out.println("꺼낸 동전 : " + coin.getValue() + "원");
		}
	}
}
