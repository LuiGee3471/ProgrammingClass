package baseballwithre;

public class Match extends Thread {
  private static int inning; // 1~9
  private static String half; // top bottom
  private Team[] teams; // score
  private static int outs;
  private Team home, away;

  public Match() {
    inning = 1;
    outs = 0;
    teams = new Team[] {Baseball_main.t1, Baseball_main.t2};
    home = teams[1];
    away = teams[0];
  }

  @Override
  public void run() {
    playBall();
  }


  public void playBall() {
    match: while (true) {
      // 초                     말
      if (!inningHalf(away) || !inningHalf(home)) {
        break;
      }
      inning++;
      // outs = 0;
      // half = "말";
      // System.out.println(home.getName() + " 공격");
      // while (outs < 3) {
      // home.bat();
      // if (inning >= 9 && home.getRunsTotal() > away.getRunsTotal()) {
      // System.out.println();
      // break match;
      // }
      // }
      // System.out.println();
      // System.out.println(inning +"회" + half + " 종료");
      // if (inning >= 9 && home.getRunsTotal() != away.getRunsTotal()) {
      // break;
      // }
      // System.out.println("현재 스코어 " + away.getRunsTotal() + ":" + home.getRunsTotal());
      // inning++;
    }
    getResult(home.getRunsTotal(), away.getRunsTotal());
    System.exit(0);
  }

  private boolean inningHalf(Team team) {
    outs = 0;
    half = (team == away) ? "초" : "말";
    System.out.println(team.getName() + " 공격");
    while (outs < 3) {
      if (team == home && inning >= 9 && home.getRunsTotal() > away.getRunsTotal()) {
        System.out.println();
        return false;
      }
      team.bat();
    }
    System.out.println();
    System.out.println(inning + "회" + half + " 종료");
    if (team == home && inning >= 9 && home.getRunsTotal() != away.getRunsTotal()) {
      System.out.println();
      return false;
    }
    System.out.println("현재 스코어 " + away.getRunsTotal() + ":" + home.getRunsTotal());
    return true;
  }

  // if (inning >= 9 && home.getRunsTotal() > away.getRunsTotal()) {
  // break match;
  // }

  private void getResult(int runHome, int runAway) {
    String winner = (runHome > runAway) ? home.getName() : away.getName();
    System.out.println("최종 결과 " + away.getRunsTotal() + ":" + home.getRunsTotal());
    System.out.println(winner + " 승리");
  }

  public static int getOuts() {
    return outs;
  }

  public static void setOuts(int outs) {
    Match.outs = outs;
  }

  public static int getInning() {
    return inning;
  }
}
