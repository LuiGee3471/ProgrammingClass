package lottowithio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Lotto {
	private Scanner scanner;
	private Random r;
	private int[] numbers;
	private String lotto = "";
	private String path = "C:\\Temp\\Lotto\\";
	private SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat time = new SimpleDateFormat("a hh:mm");

	public Lotto() { // 특수한 목적 : member field 초기화(생성자 함수), constructor
		scanner = new Scanner(System.in);
		r = new Random();
		numbers = new int[6];
	}

	public void selectBasicNumber() {	
		File defaultDir = new File(path);
		if (!defaultDir.exists()) {
			defaultDir.mkdirs();
		}
		
		int menu = 0;
		do {
			try {
				System.out.println("1. 로또 번호 출력");
				System.out.println("2. 로또 번호 재확인");
				System.out.println("3. 숫자 출현 횟수 확인하기");
				System.out.println("4. 프로그램 종료");
				System.out.print("입력 : ");
				menu = Integer.parseInt(scanner.nextLine());
				if (menu >= 1 && menu <= 4) {
					MenuCh(menu);
					break;
				} else {
					throw new Exception("문제발생 ^^");
				}
			} catch (Exception e) {
				System.out.println("메뉴를 잘못 선택");
				System.out.println("메뉴(1~2)까지 선택");
			}
		} while (true);
	}

	public void MenuCh(int a) {
		switch (a) {
		case 1:
			selectBasicLottoNumber(r, numbers);
			selectBasicNumber();
			break;
		case 2:
			readLottoNumber();
			selectBasicNumber();
			break;
		case 3:
			howManyNumbers();
			selectBasicNumber();
			break;
		case 4:
			System.out.println("프로그램 종료");
			System.exit(0);
		}
	}

	private void selectBasicLottoNumber(Random r, int[] numbers) { // 번호 선택
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
		LottoBu();
	}

	private void LottoBu() { // 정렬
		for (int i = numbers.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					int temp = 0;
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
		LottoPrint();
	}

	private void LottoPrint() { // 번호 출력
		System.out.println("요번주 당첨 번호 입니다");
		System.out.println("****************");
		for (int i = 0; i < numbers.length; i++) {
			lotto += numbers[i] + " ";
		}
		System.out.println(lotto);

		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(path + date.format(new Date()) + ".txt", true);
			bw = new BufferedWriter(fw);
			bw.write(time.format(new Date()) + " " + lotto);
			bw.newLine();
			lotto = "";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void readLottoNumber() {
		System.out.println("확인할 날짜를 입력해주세요 (ex. 20190307)");
		String today = scanner.nextLine();

		File file = new File(path + today + ".txt");

		if (!file.exists()) {
			System.out.println("저장된 파일이 없습니다.");
			return;
		}

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String s = "";
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void howManyNumbers() {
		Map<Integer, Integer> numberMap = new HashMap<>();
		
		System.out.println("확인할 날짜를 입력해주세요 (ex. 20190307)");
		String today = scanner.nextLine();
		
		File file = new File(path + today + ".txt");
		if (!file.exists()) {
			System.out.println("저장된 파일이 없습니다.");
			return;
		}
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String[] data;
			while ((data = br.readLine().split(" ")) != null) {
				for (int i = 2; i < data.length; i++) {
					int key = Integer.parseInt(data[i]);
					if (!numberMap.containsKey(key)) {
						numberMap.put(key, 1);
					} else {
						int value = numberMap.get(key) + 1;
						numberMap.put(key, value);
					}
				}
			}
		} catch (Exception e) {
			
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Set<Integer> keySet = numberMap.keySet();
		List<Integer> list = new ArrayList<Integer>(keySet);
		Collections.sort(list);
		Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			int key = i.next();
			System.out.println(key + " : " + numberMap.get(key) + "번");
		}
	}
}

public class LottoIO {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.selectBasicNumber();
	}
}
