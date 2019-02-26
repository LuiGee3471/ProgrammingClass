
public class PrintTest {

	public static void main(String[] args) {
		Test t = new Test();
		
		t.a = 3;
		System.out.println("a : " + t.a);
		t.setB(5);
		System.out.println("b : " + t.getB());

	}

}
