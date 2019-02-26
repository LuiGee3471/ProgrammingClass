class Animal {
	int food;
	
	Animal(int food) {
		this.food = food;
	}
}

class Monkey extends Animal {
	Monkey() {
		super(100);
	}

	@Override
	public String toString() {
		return "원숭이";
	}	
}

class Tiger extends Animal {
	Tiger() {
		super(300);
	}

	@Override
	public String toString() {
		return "호랑이";
	}	
}

class Lion extends Animal {
	Lion() {
		super(400);
	}

	@Override
	public String toString() {
		return "사자";
	}	
}

class Zookeeper {
	int food = 1000;
	
	void feed(Animal animal) {
		this.food -= animal.food;
		System.out.println(animal.toString() + "에게 먹이를 주었습니다.");
		System.out.println("먹이가 " + this.food + " 남았습니다.");
	}
}


public class Zoo {
	public static void main(String[] args) {
		Zookeeper zookeeper = new Zookeeper();
		Monkey monkey = new Monkey();
		Tiger tiger = new Tiger();
		Lion lion = new Lion();
		
		zookeeper.feed(monkey);
		System.out.println();
		zookeeper.feed(tiger);
		System.out.println();
		zookeeper.feed(lion);
	}
}
