package kr.or.bit;
// stack이라는 자료구조를 직접 설계
// 데이터 그릇 : 배열
// 자료의 형태 : Object

import java.util.Arrays;

public class MyStack {
	private Object[] stackarr; // 데이터를 담을 공간
	private int top; // 값이 변함 (이동 : 커서 역할)
	
	public Object[] getStackArr() {
		return stackarr;
	}
	
	public MyStack(int maxSize) {
		stackarr = new Object[maxSize];
		top = 0;
	}
	
	// 기능 (함수)
	// 스택 empty?
	public boolean isEmpty() {
		return (top == 0) ? true : false;
	}
	
	// 스택 full?
	public boolean isFull() {
		return (top == stackarr.length) ? true : false; 
	}
	
	// 스택 push
	public void push(Object object) {
		if (!this.isFull()) {
			stackarr[top++] = object;	
		} else {
			System.out.println("MyStack is full.");
		}
	}
	
	// 스택 pop
	public Object pop() {
		Object obj = null;
		
		if (!this.isEmpty()) {
			obj = stackarr[--top];
			stackarr[top] = null;
		} else {
			System.out.println("MyStack is empty");
		}
		
		return obj;
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack(3);
		System.out.println(stack.isEmpty());
		stack.push("가");
		stack.push("나");
		stack.push("다");
		stack.push("라");
		String a = Arrays.toString(stack.getStackArr());
		System.out.println(a);
		System.out.println(stack.pop());
		a = Arrays.toString(stack.getStackArr());
		System.out.println(a);
		
		// 최소한 스택, 큐 정도의 코드는 구현해보자
	}
}
