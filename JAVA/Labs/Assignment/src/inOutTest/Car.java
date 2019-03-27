package inOutTest;

import java.io.Serializable;

public class Car implements Serializable {
	private int wheel = 4;
	private String name = "Avante";
	public int getWheel() {
		return wheel;
	}
	public void setWheel(int wheel) {
		this.wheel = wheel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
