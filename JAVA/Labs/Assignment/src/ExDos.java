import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ExDos {
	static FileReader file;
	static BufferedReader bfile;
	static String path;
	static FileWriter fw;
	static BufferedWriter bw;

	public static void main(String[] args) {
		File f = new File("C:\\Temp\\path.txt");

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			file = new FileReader("C:\\Temp\\path.txt");
			bfile = new BufferedReader(file);
			path = bfile.readLine();
			if (path == null) {
				path = "C:\\";
			}
			fw = new FileWriter("C:\\Temp\\path.txt");
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (args.length < 1) {
			System.out.println("사용법이 맞지 않습니다");
			System.out.println("다음과 같이 사용하세요");
			System.out.println("java ExDos [명령어] [(필요할 경우) 명령어에 필요한 인자]");
			System.exit(0);
		}

		switch (args[0]) {
		case "cd":
			cd(args);
			break;
		case "RENAME":
			rename(args);
			break;
		case "move":
			move(args);
			break;
		case "BD":
			bd(args);
			break;
		case "type":
			type(args);
			break;
		default:
			System.out.println("명령어가 틀렸습니다.");
		}
	}

	static void cd(String[] args) {
		if (args.length > 2) {
			for (int i = 2; i < args.length; i++) {
				args[1] += " " + args[i];
			}
		}
		if (args.length == 1) {
			;
		} else if (args[1].equals("..")) {
			path = path.substring(0, path.lastIndexOf("\\"));
			if (path.equals("C:")) {
				path += "\\";
			}
		} else {
			File file = null;
			if (!(new File(args[1]).exists())) {
				if (path.equals("C:\\")) {
					file = new File(args[1] = path + args[1]);
				} else {
					file = new File(args[1] = path + "\\" + args[1]);
				}
			} else {
				file = new File(args[1]);
			}
			if (file.exists() && file.isDirectory()) {
				path = args[1];
			} else {
				System.out.println("지정된 경로를 찾을 수 없습니다.");
			}
		}

		System.out.println("현재 경로 : " + path);

		try {
			bw.write(path);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
				bfile.close();
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static void rename(String[] args) {
		File file1, file2;

		if (args[1].startsWith("C:")) {
			file1 = new File(args[1]);
			file2 = new File(args[1].substring(0, args[1].lastIndexOf("\\") + 1) + args[2]);
		} else {
			file1 = new File(path + "\\" + args[1]);
			file2 = new File(path + "\\" + args[2]);
		}

		if (!file1.exists()) {
			System.out.println("명령 구문이 올바르지 않습니다.");
			System.exit(0); // 프로세스 종료
		}

		if (file2.exists()) {
			System.out.println("이미 존재하는 파일입니다.");
			System.exit(0);
		}

		if (!file1.renameTo(file2)) {
			System.out.println("이름 변경 에러");
		}
	}

	static void move(String[] args) {
		int data = 0;
		File file = null;

		if (args[1].startsWith("C:")) {
			file = new File(args[1]);
		} else {
			file = new File(path + "\\" + args[1]);
		}

		String temp = "";
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			temp = args[2] + "\\" + file.getName();
			FileWriter fw = new FileWriter(temp);
			if (file.exists()) {
				while ((data = fr.read()) != -1) {
					fw.write(data);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				fr.close();
				file.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	static void bd(String[] args) {
		File file = null;

		if (args[1].startsWith("C:")) {
			file = new File(args[1]);
		} else {
			file = new File(path + "\\" + args[1]);
		}

		if (!file.exists()) {
			System.out.println("존재하지 않는 파일이나 디렉토리입니다.");
			System.exit(0);
		}
		file.delete();
		System.out.println("파일 삭제를 완료하였습니다.");
	}

	static void type(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		File file = null;

		if (args[1].startsWith("C:")) {
			file = new File(args[1]);
		} else {
			file = new File(path + "\\" + args[1]);
		}

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";

			for (int i = 0; (line = br.readLine()) != null; i++) {
				System.out.println(line);
			}

		} catch (IOException e) {
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
