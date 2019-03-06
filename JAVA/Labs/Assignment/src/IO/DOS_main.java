package IO;

import java.util.*;
import java.io.*;

class ExDos {
	private Scanner sc;
	private String[] args;
	private String defaultPath;
	
	public ExDos() {
		sc = new Scanner(System.in);
		defaultPath = "C:\\";
	}
	
	public void MyCmd() {
		while (true) {
			System.out.print(defaultPath + ">");
			String input = sc.nextLine();
			args = input.split(" ");
			if (args.length < 1) {
				args = new String[] {""};
			}
			switch (args[0]) {
				case "cd":
					changeDirectory(args);
					break;
				case "rename":
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
			System.out.println(defaultPath);
		} else if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}

		file = (args[1].startsWith("C:\\")) ? new File(args[1]) : new File(defaultPath + "\\" +args[1]);
		
		if (args[1].equals("..")) {
			if (!defaultPath.equals("C:\\")) {
				defaultPath = defaultPath.substring(0, defaultPath.lastIndexOf("\\"));
				if (defaultPath.equals("C:")) {
					defaultPath = "C:\\";
				}
				return;
			} else {
				return;
			}
		}
		
		if (file.isDirectory()) {
			defaultPath = file.getPath();
		} else {
			System.out.println("지정된 경로를 찾을 수 없습니다.");
		}
	}

	private void rename(String[] args) {

	}

	private void move(String[] args) {

	}

	private void delete(String[] args) {

	}
	
	private void type(String[] args) {

	}
}

public class DOS_main {
    public static void main(String[] args) {
        ExDos ex = new ExDos();
        ex.MyCmd();
    }
}