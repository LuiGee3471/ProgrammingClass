package baseballwithre;

public class Team {
  private String name;
  private int runsInning;
  private int runsTotal;

  public Team(String name) {
    this.name = name;
  }

  public void bat() {
    double rE = Math.random() + RunExpectancy.getRE(Match.getOuts());
    try {
      switch (Match.getOuts()) {
        case 0:
        case 1:
        case 2:
          Thread.sleep(125);
          if (rE > 1) {
            runsTotal++;
            System.out.print("득점 ");
          } else {
            Match.setOuts(Match.getOuts() + 1);
            System.out.print("아웃 ");
          }
          Thread.sleep(250);
          break;
      }
    } catch (Exception e) {
      System.out.println("경기 중단");
    }
  }
//    try {
//      Thread.sleep(500);
//      while (Match.getOuts() < 3) {
//        double rE = Math.random() + RunExpectancy.getRE(Match.getOuts());
//        switch (Match.getOuts()) {
//          case 0:
//          case 1:
//          case 2:
//            Thread.sleep(250);
//            if (rE > 1) {
//              runsInning++;
//              System.out.print("득점 ");
//            } else {
//              Match.setOuts(Match.getOuts() + 1);
//              System.out.print("아웃 ");
//            }
//            Thread.sleep(500);
//            break;
//        }
//      }
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//    System.out.println();
//    System.out.println("이닝 득점 : " + runsInning);
//    runsTotal += runsInning;
//    runsInning = 0;
  

  public int getRunsTotal() {
    return runsTotal;
  }

  public String getName() {
    return name;
  }



}
