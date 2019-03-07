package IO;

import java.util.*;
import java.io.*;

class ExDos {
	private Scanner sc;
	private String[] args;
	private final String DEFAULT_PATH;
	private String path;

	public ExDos() {
		sc = new Scanner(System.in);
		DEFAULT_PATH = "C:\\";
		path = DEFAULT_PATH;
	}

	public void MyCmd() {
		while (true) {
			System.out.print(path + ">");
			String input = sc.nextLine();
			args = input.split(" ");
			if (args.length < 1) {
				args = new String[] { "" };
			}
			switch (args[0].toLowerCase()) {
			case "cd":
			case "cd..":
				changeDirectory(args);
				break;
			case "rename":
			case "ren":
				rename(args);
				break;
			case "move":
				move(args);
				break;
			case "del":
				delete(args);
				break;
			case "type":
				type(args);
				break;
			case "exit":
				System.exit(0);
			default:
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}

	private void changeDirectory(String[] args) {
		File file = null;
		if (args.length == 1) {
			if (args[0].equals("cd")) {
				System.out.println(path);
				return;
			} else if (args[0].equals("cd..")) {
				if (path.equals(DEFAULT_PATH)) {
					return;
				} else {
					path = path.substring(0, path.lastIndexOf("\\"));
					if (path.length() < DEFAULT_PATH.length()) {
						path = DEFAULT_PATH;
					}
					return;
				}
			}
		} else if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}

		if (args[1].equals("..")) {
			if (path.equals(DEFAULT_PATH)) {
				return;
			} else {
				path = path.substring(0, path.lastIndexOf("\\"));
				if (path.length() < DEFAULT_PATH.length()) {
					path = DEFAULT_PATH;
				}
			}
		} else {
			String newPath = "";
			if (args[1].startsWith(DEFAULT_PATH)) {
				newPath = args[1];
			} else {
				newPath = (path.equals(DEFAULT_PATH)) ? path + args[1] : path + "\\" + args[1];
			}
			file = new File(newPath);
			if (!file.exists()) {
				System.out.println("지정된 경로를 찾을 수 없습니다.");
			} else if (!file.isDirectory()) {
				System.out.println("디렉터리 이름이 올바르지 않습니다.");
			} else {
				path = newPath;
			}
		}
	}

	private void rename(String[] args) {
		if (args.length == 1) {
			return;
		}
		String renamePath = "";
		String fileName = "";
		String newFileName = "";
		File file1 = null;
		File file2 = null;
		
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}
		
		if (args[2].startsWith(DEFAULT_PATH)) {
			System.out.println("명령 구문이 올바르지 않습니다.");
			return;
		}
		
		if (args[1].startsWith(DEFAULT_PATH)) {
			renamePath = args[1].substring(0, args[1].lastIndexOf("\\") + 1);
		    fileName = args[1].substring(args[1].lastIndexOf("\\") + 1);
		} else {
			renamePath = (path.equals(DEFAULT_PATH)) ? path : path + "\\";
			fileName = args[1];
		}
		
		file1 = new File(renamePath + fileName);
		newFileName = args[2];
		file2 = new File(renamePath + newFileName);
		
		if (!file1.exists()) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			return;
		} else if (file2.exists()) {
			System.out.println("중복되는 파일 이름이 있거나 파일을 찾을 수 없습니다.");
			return;
		}
		file1.renameTo(file2);
//		FileReader fr = null;
//		FileWriter fw = null;
//		try {
//			fr = new FileReader(file1);
//			fw = new FileWriter(file2);
//			
//			int data = 0;
//			while ((data = fr.read()) != -1) {
//				fw.write(data);
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fw.close();
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		file1.delete();
	}

	private void move(String[] args) {

	}

	private void delete(String[] args) {
		if (args.length == 1) {
			return;
		}
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}
		
		String newPath = "";
		if (args[1].startsWith(DEFAULT_PATH)) {
			newPath = args[1];
		} else {
			newPath = path + "\\" + args[1];
		}
		
		File file = new File(newPath);
		if (!file.delete()) {
			System.out.println(newPath + "를(을) 찾을 수 없습니다.");
		}
	}

	private void type(String[] args) {
		if (args.length == 1) {
			return;
		}
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}
		
		File file = new File(path + "\\" + args[1]);
		if (!file.exists()) {
			System.out.println("지정된 파일을 찾을 수 없습니다.");
			return;
		} else if (file.isDirectory()) {
			System.out.println("액세스가 거부되었습니다.");
			return;		
		}
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			int data = 0;
			while ((data = br.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
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
}

public class DOS {
	public static void main(String[] args) {
		ExDos ex = new ExDos();
		ex.MyCmd();
	}
}