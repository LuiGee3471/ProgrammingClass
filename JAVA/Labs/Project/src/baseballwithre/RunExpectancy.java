package baseballwithre;

public class RunExpectancy {
  private static double rE;
  
  public static double getRE(int outs) {
    switch (outs) {
      case 0:
        rE = 0.555;
      case 1:
        rE = 0.297;
      case 2:
        rE = 0.117;
    }
    return rE;
  }
}
