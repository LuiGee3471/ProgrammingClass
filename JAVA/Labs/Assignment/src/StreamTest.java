import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Temp\\NEW\\Chrysanthemum.jpg");
		FileOutputStream fos1 = new FileOutputStream("C:\\Temp\\c1.jpg");
		FileOutputStream fos2 = new FileOutputStream("C:\\Temp\\c2.jpg");
		FileOutputStream fos3 = new FileOutputStream("C:\\Temp\\c3.jpg");
		FileOutputStream fos4 = new FileOutputStream("C:\\Temp\\c4.jpg");
		
		int data = 0;
		while ((data = fis.read()) != -1) {
			fos1.write(data);
			fos2.write(data);
			fos3.write(data);
			fos4.write(data);
		}
		
		fos1.close();
		fos2.close();
		fos3.close();
		fos4.close();
		fis.close();
	}
}
