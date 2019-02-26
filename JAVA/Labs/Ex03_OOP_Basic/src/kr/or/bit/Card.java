package kr.or.bit;

/*
 * 모든 소프트웨어는 변화한다
 * 요구사항은 항상 변한다
 * 이에 대응하는 프로그램을 만들어야 한다.
 * 
 * 우리 회사는 카드를 만들어서 판매하는 회사입니다.
 * 고객의 요청에 따라 카드 53장을 제작하게 되었습니다.
 * 
 * 요구사항
 * 카드는 각각 카드 번호와 모양도 가지고 있다. (다이아몬드, 하트, 스페이드, 클로버)
 * 카드는 크기를 가지고 있다. 크기 : 높이와 너비
 * 카드의 정보를 확인하는 기능을 가지고 있다.
 */

public class Card {
	public int number;
	public String shape;

	// 모든 카드의 크기는 고정
	// public int height = 50;
	// public int width = 20;
	public static int height = 50;
	public static int width = 20;

	// 기능
	public void cardInfo() {
		System.out.printf("카드 번호 : %d, 모양 : %s, 높이 : %d, 너비 : %d\n", number, shape, height, width);
	}
}
