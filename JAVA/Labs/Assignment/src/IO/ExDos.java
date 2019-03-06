package IO;

import java.util.List;
import java.util.concurrent.Delayed;
import java.io.File;
import java.util.ArrayList;

public class ExDos {
	public static void main(String[] args) {
		String path = "C:\\Temp";
		
		if (args.length > 3) {
			System.out.println("사용법이 맞지 않습니다");
			System.out.println("다음과 같이 사용하세요");
			System.out.println("java ExDos [명령어] [(필요할 경우) 명령어에 필요한 인자]");
			System.exit(0);
		}
		
		if (!args[0].equals("Rd")) {
			System.out.println("잘못된 명령어 입니다.");
			System.exit(0);
		}
		File file = new File(args[1]);
		
		if(!file.exists()) {
			System.out.println("존재하지 않는 디렉토리입니다.");
			System.exit(0);
		}
		Rd(file);
		file.delete();
		System.out.println("파일 삭제를 완료하였습니다.");
		
		
	}
	static void Rd(File rdfile) {
		System.out.println("실행시킨 파일 위치 : [ " + rdfile.getAbsoluteFile() + " ]" );
		
		List<Integer> subRd = new ArrayList<Integer>();
		File[] files = rdfile.listFiles();
		String filename = null;
		for(int i = 0 ; i < files.length ; i ++) {
			filename = files[i].getName();
			if(files[i].isDirectory()) {
				System.out.println("폴더명 :" + filename);
			}else { 
				filename = "파일명" + filename;
			}
			subRd.add(i);
			
			}
		System.out.println("삭제할수있는 목록" + filename);
		}
		
		
		}