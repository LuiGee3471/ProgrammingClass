import java.util.ArrayList;

class EmpData {
	private ArrayList alist;
	private int[] numbers;
	
	EmpData() {
		this.alist = new ArrayList();
		this.numbers = new int[10];
	}
	
	public ArrayList getAlist() {
		return this.alist;
	}
	
	public void setAlist(ArrayList alist) {
		this.alist = alist;
	}
	
	public int[] getNumbers() {
		return numbers;
	}
	
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
}

public class Ex04_ArrayList_Parameter {
	public static void main(String[] args) {
		EmpData empdata = new EmpData();
		System.out.println(empdata);
		System.out.println(empdata.getAlist().toString());
		
		ArrayList li = new ArrayList();
		li.add(100);
		li.add(200);
		li.add(300);
		
		empdata.setAlist(li);
		System.out.println(empdata.getAlist().toString());
		
		ArrayList li2 = new ArrayList(100);

	}
}
