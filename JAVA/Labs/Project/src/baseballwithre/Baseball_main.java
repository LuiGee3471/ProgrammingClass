package baseballwithre;

public class Baseball_main {
  static public Team t1 = new Team("롯데");
  static public Team t2 = new Team("KIA");
  public static void main(String[] args) {
    Match m1 = new Match();
    
    ScoreBoard scoreboard = new ScoreBoard(t1, t2);
    
    scoreboard.start();
    m1.start();
  }
}
