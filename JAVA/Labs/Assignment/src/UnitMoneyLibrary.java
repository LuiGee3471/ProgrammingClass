
public class UnitMoneyLibrary {
	public int unit = 10000;
	public int num;
	public int sw;
	
	public void printUnitNum(int money) {
		num = money / unit;		
		System.out.printf("화폐단위 : %d원, 매수 : %d\n", unit, num); 
	}
}
