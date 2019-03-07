package gradecheck;

import java.io.Serializable;
import java.util.Scanner;

public class Grade implements Serializable {
	private double math = 0;
	private double java = 0;
	private double python = 0;
	private double avg = 0;
	private String you = null;

	public static Grade input() {
		Grade grade = new Grade();
		Scanner scan = new Scanner(System.in);
		System.out.print("수학 점수 입력하세요 : ");
		grade.math = scan.nextInt();
		System.out.print("자바 점수 입력하세요 : ");
		grade.java = scan.nextInt();
		System.out.print("파이썬 점수 입력하세요 : ");
		grade.python = scan.nextInt();

		grade.avg = (grade.math + grade.java + grade.python) / 3;
		if (grade.avg > 90) {
			grade.you = "A+";
		} else if (grade.avg > 80 && grade.avg <= 90) {
			grade.you = "A";
		} else if (grade.avg > 70 && grade.avg <= 80) {
			grade.you = "B+";
		} else if (grade.avg > 60 && grade.avg <= 70) {
			grade.you = "B";
		} else {
			grade.you = "C";
		}
		return grade;
	}

	public double getMath() {
		return math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getJava() {
		return java;
	}

	public void setJava(double java) {
		this.java = java;
	}

	public double getPython() {
		return python;
	}

	public void setPython(double python) {
		this.python = python;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getYou() {
		return you;
	}

	public void setYou(String you) {
		this.you = you;
	}

	@Override
	public String toString() {
		return "Grade [math=" + math + ", java=" + java + ", python=" + python + ", avg=" + avg + ", you=" + you + "]";
	}
}
