package kr.or.bit;

import java.io.IOException;

public class ExClass {
	
	public ExClass(String path) throws IOException, ArithmeticException { // 예외는 복수로 던지기 가능
		
	}
	
	public void call() throws ArithmeticException, ArrayIndexOutOfBoundsException {
		System.out.println("call 함수 start");
		int i = 1 / 0;
		System.out.println("call 함수 end");
	}

}
