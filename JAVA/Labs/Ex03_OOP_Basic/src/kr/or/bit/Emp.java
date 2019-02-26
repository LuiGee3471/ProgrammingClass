package kr.or.bit;

/*
 * 만든 이: 나
 * 생성날짜 : 2019-02-08
 * 파일: Emp.java(사원 정보)
 * 
 * class는 설계도이다
 * 설계도의 기본 구성 요소 : 상태, 고유 정보 + 행위 정보
 *                   속성(변수, 필드) + 기능(함수)
 */

public class Emp {
	public int empno; // 사번(정보 > 변수 > member field(instance variable))
	public String ename; // 이름
	public String job; // 직종

	private int sal; // 급여 (캡슐화, 은닉화 : 간접 할당)
	// sal값을 write(set), read(get)

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) { // write(간접할당)
		if (sal < 0) {
			this.sal = 0;
		} else {
			this.sal = sal;
		}
	}

	private int mgr; // 관리자 사번

	public int getMgr() { // read (getter)
		return mgr;
	}

	public void setMgr(int mgr) { // write (setter) 웬만하면 자동 생성 기능으로
		this.mgr = mgr;
	}
	
	// 기능(함수)
	public String getEmpInfo() {
		return empno + "/" + ename + "/" + job + "/" + sal;
	}
	
}
