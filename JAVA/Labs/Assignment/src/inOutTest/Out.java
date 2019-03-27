package inOutTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Out {
	private int a = 1;
	private static List<Car> cars = new ArrayList<Car>();
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:\\Temp\\outTest.data");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		
		cars.add(new Car());
		cars.add(new Car());
		
		out.writeObject(cars);
		
		FileInputStream fis = new FileInputStream("C:\\Temp\\outTest.data");
		ObjectInputStream in = new ObjectInputStream(fis);
		
		List<Car> cars2 = (ArrayList<Car>) in.readObject();
		System.out.println(cars2);
		System.out.println(cars2.get(0).getName());
	}
}
