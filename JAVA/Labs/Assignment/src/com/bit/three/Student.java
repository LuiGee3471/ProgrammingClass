package com.bit.three;

public class Student {
	private String studentNumber; //학번
	private String residentNumber; //주민등록번호(생년월일만)
	private String grade; //학년
	private String major;//전공
	private String name;//이름
	public static Student[] studentRegisterArr;
	public static int index;
	
	static {
		studentRegisterArr = new Student[100];
		studentRegisterArr[0] = new Student("정규현", "201118043", "920812","3","비트학과");
		studentRegisterArr[1] = new Student("곽호원", "201319002", "940206","2","컴공(핵잘함전공자)");
		studentRegisterArr[2] = new Student("박채연", "201611507", "961030","1","패션디자인과");
		studentRegisterArr[3] = new Student("김동현", "201506015", "951005","1","정보통신학과(어플신)");
		studentRegisterArr[4] = new Student("이교선", "201511043", "961009","4","미용학과");
		index = 5;
	}

	public Student(String name, String studentNumber, String residentNumber, String grade, String major) {
		this.studentNumber = studentNumber;
		this.residentNumber = residentNumber;
		this.grade = grade;
		this.major = major;
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public String getResidentNumber() {
		return residentNumber;
	}

	public String getGrade() {
		return grade;
	}

	public String getMajor() {
		return major;
	}

	public String getName() {
		return name;
	}
}
