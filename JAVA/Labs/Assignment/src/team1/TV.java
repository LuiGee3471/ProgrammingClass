package team1;

import java.util.HashSet;
import java.util.Set;

public class TV {
	private int ch;
	private boolean power;
	private Set<Integer> favoriteCh;
	
	public TV() {
		ch = 1;
		power = false;
		favoriteCh = new HashSet<>();
	}
	
	public void on() {
		System.out.println("TV ON");
		System.out.println("채널 : " + ch);
		power = true;
	}
	
	public void off() {
		System.out.println("TV OFF");
		power = false;
	}
	
	public void chUp() {
		System.out.println("채널 : " + ++ch);
	}
	
	public void chDown() {
		System.out.println("채널 : " + --ch);
	}
	
	public int getCh() {
		return this.ch;
	}
	
	public void setCh(int ch) {
		this.ch = ch;
	}
	
	public boolean getPower() {
		return power;
	}
	
	public void setPower(boolean power) {
		this.power = power;
	}
	
	public void setFavoriteCh(int ch) {
		favoriteCh.add(ch);
		System.out.println("선호 채널 추가 : " + ch);
	}
}
