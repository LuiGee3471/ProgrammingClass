package coffeevendingmachine;

import java.util.Arrays;

public class Coffee {
	private String coffeeName; // 커피 이름
	private int coffeeId;      // 커피 고유번호
	private int[] recipe;      // 커피 재료 사용량
	private int coffeePrice;   // 커피 가격

	public String getCoffeeName() {
		return coffeeName;
	}

	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}

	public int getCoffeeId() {
		return coffeeId;
	}

	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}

	public void setRecipe(int[] recipe) {
		this.recipe = recipe;
	}

	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}

	public Coffee(String coffeeName, int coffeeId, int[] recipe, int coffeePrice) { // 커피 생성자 함수
		this.coffeeName = coffeeName;
		this.coffeeId = coffeeId;
		this.recipe = recipe;
		this.coffeePrice = coffeePrice;
	}

	public int[] getRecipe() {
		return recipe;
	}

	public int getCoffeePrice() {
		return coffeePrice;
	}
}