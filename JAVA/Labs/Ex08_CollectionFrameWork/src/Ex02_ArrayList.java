import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

// Today's Keypoint
public class Ex02_ArrayList {
	public static void main(String[] args) {
		ArrayList arraylist = new ArrayList();
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		System.out.println(arraylist.toString());
		
		for (int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		
		System.out.println("현재 : [0]" + arraylist.get(0));
		// add : 데이터를 추가하는 함수 (기본은 순차적으로)
		// 비순차적으로 데이터를 추가하거나 삭제하는 방법
		arraylist.add(0, 1111);
		System.out.println("add : " + arraylist.toString()); // [1111, 100, 200, 300]
		// 덮어쓰지 않고 밀어낸다, 기존의 자원은 자리 이동
		// 데이터를 삽입하는 add : default(맨 뒤, 순차적)
		// 데이터를 삽입하는 add : 중간에 추가, 삭제...
		// ArrayList에서 중간에 데이터를 추가하거나 삭제하는 작업은 성능에 좋지 않다
		// 순차적인 데이터 추가, 삭제는 성능이 좋다
		arraylist.remove(0);
		System.out.println("size : " + arraylist.size());
		System.out.println("remove : " + arraylist.toString());
		
		// ArrayList의 함수
		System.out.println(arraylist.contains(200)); // true
		System.out.println(arraylist.contains(333)); // false
		
		System.out.println(arraylist.isEmpty()); // false
		arraylist.clear(); // 데이터 삭제
		System.out.println(arraylist.isEmpty()); // true >> (size == 0)
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		
		System.out.println(arraylist.toString());
		
		Object value = arraylist.remove(0); // 필요하다면 지워지는 값을 받을 수 있다
		System.out.println("value : " + value);
		System.out.println("remove : " + arraylist.toString());
		
		ArrayList list = new ArrayList();
	    list.add("가");
	    list.add("나");
	    list.add("다");
	    list.add("가");
	    
	    System.out.println("ArrayList : 순서 유지 " + list.toString());
	    list.remove("가"); // 순차적으로(앞에서부터) 찾아서 있으면 삭제
	    System.out.println("ArrayList : remove " + list.toString());
	    
	    // 이 코드는 매우 중요
	    List li = new ArrayList(); // 코드 패턴 : 다형성 (부모 타입)
	    // li = new Vector();
	    // List 인터페이스를 상위 인터페이스로
	    
	    li.add("가");
	    li.add("나");
	    li.add("다");
	    li.add("라");
	    
	    System.out.println(li.toString());
	    
	    List li4 = li.subList(0, 2);
	    System.out.println(li4.toString());
	    
	    ArrayList alist = new ArrayList();
	    alist.add(50);
	    alist.add(1);
	    alist.add(7);
	    alist.add(40);
	    alist.add(7);
	    alist.add(15);
	    System.out.println("before : " + alist.toString());
	    Collections.sort(alist);
	    System.out.println("after : " + alist.toString());
	}
}
