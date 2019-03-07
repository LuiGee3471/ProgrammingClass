package gradecheck;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GradeCheck {
	private static Map<Integer, Grade> gradeMap = new HashMap<Integer, Grade>();
	private static int gradeCount = 1;
	private static String saveFile = "C:\\Temp\\gradeCheck.txt";
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		GradeCheck gc = new GradeCheck();
		while (true) {
			System.out.println("학생 성적 입력 프로그램");
			System.out.println("1. 입력 2. 삭제 3. 출력 4. 저장 5. 불러오기 6. 종료");
			System.out.print("입력 : ");
			int menu = scanner.nextInt();
			scanner.nextLine();
			switch (menu) {
			case 1:
				gc.inputData();
				break;
			case 2:
				gc.deleteData();
				break;
			case 3:
				gc.printData();
				break;
			case 4:
				gc.saveData();
				break;
			case 5:
				gc.loadData();
				break;
			case 6:
				System.out.println("프로그램 종료");
				System.out.println(gradeCount);
				System.exit(0);
				break;
			default:
				System.out.println("올바른 값을 입력해주세요");
			}
		}
	}

	private void inputData() {
		gradeMap.put(gradeCount, Grade.input());
		gradeCount += 1;
	}

	private void deleteData() {
		if (gradeCount == 1) {
			System.out.println("입력된 정보가 없습니다");
			return;
		}
		System.out.print("삭제할 성적의 번호를 입력하세요 : ");
		int key = scanner.nextInt();
		scanner.nextLine();
		if (gradeMap.containsKey(key)) {
			gradeMap.remove(key);
			System.out.println("성적이 삭제됐습니다");
		} else {
			System.out.println("해당하는 성적 정보가 없습니다");
		}
	}

	private void printData() {
		if (gradeCount == 1) {
			System.out.println("입력된 정보가 없습니다");
			return;
		}
		System.out.println("번호\t수학\t자바\t파이썬\t평균\t학점");
		Set<Integer> set = gradeMap.keySet();
		for (int i : set) {
			double math = gradeMap.get(i).getMath();
			double java = gradeMap.get(i).getJava();
			double python = gradeMap.get(i).getPython();
			double avg = gradeMap.get(i).getAvg();
			String you = gradeMap.get(i).getYou();
			System.out.printf("%d\t%.1f\t%.1f\t%.1f\t%.2f\t%s\n", i, math, java, python, avg, you);
		}
	}
	
	/*
	 * 1	90.0	80.0	90.0	86.67	A
2	95.0	90.0	95.0	93.33	A+
3	90.0	80.0	90.0	86.67	A
	 */

	private void saveData() {
		if (gradeCount == 1) {
			System.out.println("입력된 정보가 없습니다");
			return;
		}
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;
		File file = new File(saveFile);
		String answer = "";

		if (file.exists()) {
			System.out.println("저장 파일을 덮어쓰시겠습니까? 추가하시겠습니까? (덮어쓰기 / 추가)");
			answer = scanner.nextLine();
			if (!answer.equals("덮어쓰기") && !answer.equals("추가")) {
				System.out.println("올바른 입력이 아닙니다");
				return;
			}
		}
		
		try {
			if (answer.equals("추가")) {
				FileInputStream fis = new FileInputStream(saveFile);
				ObjectInputStream in = new ObjectInputStream(fis);
				int tempGradeCount = (int) in.readObject();
				Map<Integer, Grade> tempGradeMap = (HashMap<Integer, Grade>) in.readObject();
				Set<Integer> set = gradeMap.keySet();
				for (int i : set) {
					tempGradeMap.put(tempGradeCount + i, gradeMap.get(i));
				}
				gradeCount = tempGradeCount;
				gradeMap = tempGradeMap;
			}
			fos = new FileOutputStream(saveFile);
			bos = new BufferedOutputStream(fos);
			out = new ObjectOutputStream(bos);

			out.writeObject(gradeCount);
			out.writeObject(gradeMap);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				bos.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("저장이 완료됐습니다");
		}
	}

	private void loadData() {
		File file = new File(saveFile);
		if (!file.exists()) {
			System.out.println("저장된 데이터가 없습니다");
			return;
		}

		if (gradeMap.size() > 0) {
			System.out.print("작업 중인 정보가 사라집니다? 괜찮나요? (Y/N) : ");
			String answer = scanner.nextLine();
			if (!answer.equals("Y")) {
				return;
			}
		}

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream in = null;

		try {
			fis = new FileInputStream(saveFile);
			bis = new BufferedInputStream(fis);
			in = new ObjectInputStream(bis);

			gradeCount = (int) in.readObject();
			gradeMap = (HashMap<Integer, Grade>) in.readObject();

			System.out.println("불러오기가 완료됐습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
