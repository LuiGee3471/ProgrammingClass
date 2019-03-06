import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

// TreeSet 추가적으로 알고 있으면 좋을 것 같다

public class Ex11_Set_TreeSet {
	public static void main(String[] args) {
		// 순서(X), 중복(X)
		HashSet<String> hs = new HashSet<String>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		hs.add("A");
		System.out.println(hs);
		
		// HashSet 확장 > LinkedHashSet (순서 유지) > Linked : 주소값 > Node
		// add한 순서를 유지, 정렬되는 것은 아님
		Set<String> hs2 = new LinkedHashSet<String>();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("K");
		hs2.add("G");
		hs2.add("D");
		hs2.add("P");
		hs2.add("A");
		System.out.println(hs2.toString());
		
		// 순서(X), 중복(X), 정렬(O : 오름차순) 기본 제공
		// TreeSet: 검색과 정렬 두 가지 요소를 필요로 하는 구조에서 사용
		// 이진 트리 : 정렬되고 많은 양의 데이터를 저장할 때 효율적
		// 로또 : 1~45의 난수 6개, 중복 없음, 정렬해야 함
		
		Set<Integer> lotto = new TreeSet<Integer>();
		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add((int)(Math.random() * 45) + 1);
		}
		System.out.println(lotto);
		
		int sum = 0;
		Iterator<Integer> i = lotto.iterator();
		while (i.hasNext()) {
			// System.out.println(i.next());
			sum += i.next();
		}
		System.out.println(sum);
	}
}
