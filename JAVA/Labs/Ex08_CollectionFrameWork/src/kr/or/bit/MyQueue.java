package kr.or.bit;

import java.util.Arrays;

public class MyQueue {
	private int[] arr;
	private int top;
	
	public int[] getArr() {
		return arr;
	}
	
	public MyQueue(int maxSize) {
		arr = new int[maxSize];
		top = 0;
	}
	
	public boolean isFull() {
		return (top == arr.length) ? true : false;
	}

	public void push(int i) {
		if (!isFull()) {
		    arr[top++] = i;
		}
	}
	
	public boolean isEmpty() {
		return (top == 0) ? true : false;
	}
	
	public int pop() {
		int pop;
		if (!isEmpty()) {
		    pop = arr[0];
		    for (int i = 1; i < arr.length; i++) {
		    	arr[i - 1] = arr[i];
		    }
		    arr[arr.length - 1] = 0;
		} else {
			pop = 0;
		}
		return pop;
	}
	
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(5);
		String result = Arrays.toString(queue.getArr());
		System.out.println(result);
		
		queue.push(3);
		queue.push(4);
		queue.push(5);
		queue.push(6);
		queue.push(8);
		
		result = Arrays.toString(queue.getArr());
		System.out.println(result);
		
		queue.pop();
		System.out.println(queue.pop());
		
		result = Arrays.toString(queue.getArr());
		System.out.println(result);
		
	}
}
