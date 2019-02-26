package Movie;

public class Cinema {// 영화관
	public static void main(String[] args) {
		// 1번 사람이 예매를 끝내고
		// 2번 사람이 예매를 끝내고
		// 1번 사람이 다시 예매 시스템을 이용하는 상황
		
		Reservation r1 = new Reservation();
		r1.reservation();

		Reservation r2 = new Reservation();
		r2.reservation();
		
		r1.reservation();
	}
}