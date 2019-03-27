package team1;

public class TVMain {

	public static void main(String[] args) {
		TV tv = new TV();
		
		tv.on();
		tv.chUp();
		tv.chUp();
		tv.setFavoriteCh(3);
		tv.off();
		tv.on();
		tv.chDown();
	}
}
