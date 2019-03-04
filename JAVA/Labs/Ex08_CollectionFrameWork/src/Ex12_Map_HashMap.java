import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/*
 * Map 인터페이스를 구현하는 클래스
 * Map >> (키(key), 값(value)) >> 쌍배열
 * ex) 지역번호 : (02, 서울), 우편번호
 * key 값 : 중복 허용 X
 * value 값 : 중복 허용
 * 
 * Map >> Generic 지원
 * 
 * HashTable(구버전) : 동기화 보장
 * HashMap(신버전) : 동기화 강제 X
 */
public class Ex12_Map_HashMap {
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Tiger", "1004");
		map.put("scott", "1004");
		map.put("superman", "1007");
		// 활용 : 회원의 ID, 비밀번호
		// 메모리(heap) >> 종료 후에도 보존 >> 파일 >> 관리의 어려움 문제 >> RDBMS (관계형 DB)
		
		System.out.println(map.containsKey("tiger")); // false : 대소문자 구분
		System.out.println(map.containsKey("scott"));
		System.out.println(map.containsValue("1004"));
		
		// (key, value)
		// POINT : key 값을 가지고 value 값을 찾는 것
		System.out.println(map.get("Tiger"));
		System.out.println(map.get("hong")); // hong이라는 key 값을 map이 가지고 있지 않다
		
		// put
		map.put("Tiger", 1008); // key가 같은 경우는 value를 덮어쓴다(override)
		
		System.out.println(map.get("Tiger"));
		System.out.println("before : " + map.size());
		Object returnValue = map.remove("superman");
		System.out.println(returnValue); // 필요하다면 써
		System.out.println("after : " + map.size());
		
		Set set = map.keySet();
		// Set 인터페이스를 구현하는 객체를 내부적으로 new하고 그 객체에 key를 담고 객체의 주소값을 return (다형성)
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		// Quiz Map에서 value 값들을 모아서 출력하세요
		// map.values()
		
//		List list = new ArrayList(map.values());
//		Iterator i = list.iterator();
//		while (i.hasNext()) {
//			System.out.println(i.next());
//		}
		Collection vlist = map.values();
		System.out.println(vlist);
	}
}
