package team1;

public class ifswitchex {

	public static void main(String[] args) {
		int score = 99;
		String grade = "";
		
		if (score == 100) {
			grade = "A";
		} else if (score >= 80) {
			grade = "B";
		} else if (score >= 60) {
			grade = "C";
		}
		
		switch (grade) {
		case "A":
			System.out.println(grade);
			break;
		case "B":
			System.out.println(grade);
			break;
		case "C":
			System.out.println(grade);
		    break;
		default:
		    
		}

	}

}
