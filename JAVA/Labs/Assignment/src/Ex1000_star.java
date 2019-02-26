
public class Ex1000_star {

	public static void main(String[] args) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------");

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		
		for(int i =1; i<10; i++) {
			for(int o =1; o<10-i; o++) {
				System.out.print(" ");
			}
			for(int e = 1; e<=i; e++) {
				System.out.print("*");
				for(int w= 1; w<e; w++) {
				System.out.print("*");
				}
			}System.out.println();
		}
	
	

	}
}
