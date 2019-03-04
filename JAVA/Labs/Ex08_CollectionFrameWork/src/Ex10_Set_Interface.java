import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Set 인터페이스를 구현하고 있는 클래스

// Set : 순서가 없고 중복을 허용하지 않는 데이터 집합
// 구현하는 클래스 : HashSet, TreeSet
// 순서를 보장하지 않는다 = 내부 구조가 배열이 아니다 = 넣은 순서를 보장하지 않는다

public class Ex10_Set_Interface {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(1);
		hs.add(100);
		hs.add(55);
		System.out.println(hs.toString());
		// 1. 중복 데이터 처리(POINT)
		boolean bo = hs.add(1); // 기존에 같은 데이터가 있으면 추가되지 않음
		System.out.println(bo);
		hs.add(2);
		System.out.println(hs.toString());
		
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("b");
		hs2.add("A");
		hs2.add("F");
		hs2.add("c");
		hs2.add("z");
		System.out.println(hs2.toString());
		// 순서를 유지하지 않는다 (순차적으로)
		
		// 1. 중복 데이터 허용(X) (일상 생활에서 중복 데이터를 허용하지 않는 경우)
		String[] obj = { "A", "B", "A", "C", "D", "B", "A" };
		HashSet<String> hs3 = new HashSet<String>();
		for (int i = 0; i < obj.length; i++) {
			hs3.add(obj[i]);
		}
		System.out.println(hs3.toString());
		
		// Quiz
		// HashSet 사용해서 1~45 난수 6개를 넣으세요(add)
		Set<Integer> lotto = new HashSet<Integer>();
		while (lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);
		
		Set<Integer> lotto2 = new HashSet<Integer>();
		int index = 0;
		for (int i = 0; lotto2.size() < 6;) {
			index++;
			lotto2.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(index);
		System.out.println(lotto2);
		
		HashSet<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFFF");
		System.out.println(set3);
		
		Iterator<String> s = set3.iterator();
		while (s.hasNext()) {
			System.out.println(s.next());
		}
		// add된 순서를 보장하지 않는다 (배열이 아님)
		
		// Collections.sort(List<T> list); List 인터페이스를 구현하는 모든 객체를 param로 할 수 있다
		// Set 인터페이스를 구현하는 HashSet을 가지고 놀다가 데이터 정렬을 하고 싶어졌다
		// HashSet >> sort 제공 X
		
		List list = new ArrayList(set3); // ArrayList(Collection c);
		System.out.println("before 무작위 >> " + list.toString());
		Collections.sort(list);
		System.out.println("after 정렬 >> " + list.toString());
	}
}
