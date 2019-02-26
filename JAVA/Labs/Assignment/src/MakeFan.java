
public class MakeFan {

	public static void main(String[] args) {
		StudyFan fan = new StudyFan();

		fan.setMotor(1203115, "천궁");
		fan.powerOn();
		fan.change(1);
		fan.powerOff();

		System.out.println();

		StudyFan fan2 = new StudyFan();

		fan2.setMotor(1125018, "비트");
		fan2.powerOn();
		fan2.change(2);
		fan2.powerOff();
		
		System.out.println();
		
		StudyMotor.howManyMotor();
	}

}
