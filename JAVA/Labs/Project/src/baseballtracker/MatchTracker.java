package baseballtracker;

import java.util.ArrayList;

public class MatchTracker {
    public BaseballTeam[] teams;

    public MatchTracker() {
        teams = new BaseballTeam[10];
        teams[0] = new BaseballTeam("SK 와이번스");
        teams[1] = new BaseballTeam("두산 베어스");
        teams[2] = new BaseballTeam("한화 이글스");
        teams[3] = new BaseballTeam("넥센 히어로즈");
        teams[4] = new BaseballTeam("KIA 타이거즈");
        teams[5] = new BaseballTeam("삼성 라이온즈");
        teams[6] = new BaseballTeam("롯데 자이언츠");
        teams[7] = new BaseballTeam("LG 트윈스");
        teams[8] = new BaseballTeam("KT 위즈");
        teams[9] = new BaseballTeam("NC 다이노스");
    }

    public void writeRecord(BaseballTeam A, BaseballTeam B, int scoreA, int scoreB) {
        if (scoreA > scoreB) {
            A.win(B, scoreA, scoreB);
        } else {
            B.win(A, scoreB, scoreA);
        }
    }

    public void readRecord(BaseballTeam team) {
        team.getMatchRecord();
    }

    public void getTotalMatches() {
        System.out.println("총 경기 수 : " + BaseballTeam.getTotalMatches());
    }
}