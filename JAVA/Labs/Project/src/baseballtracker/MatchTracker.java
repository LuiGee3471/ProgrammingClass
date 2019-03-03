package baseballtracker;

import java.util.ArrayList;

public class MatchTracker {
    private BaseballTeam[] teams;

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

    public BaseballTeam getTeam(String teamName) {
        BaseballTeam team = null;
        for (BaseballTeam t : teams) {
            if (teamName.equals(t.getTeamName())) {
                team = t;
            }
        }
        return team;
    }

    private BaseballTeam[] getTeams(String team1, String team2) {
        BaseballTeam[] teamlist = new BaseballTeam[2];
        for (BaseballTeam team : teams) {
            if (team1.equals(team.getTeamName())) {
                teamlist[0] = team;
            } else if (team2.equals(team.getTeamName())) {
                teamlist[1] = team;
            }
        }
        return teamlist;
    }

    public void writeRecord(String team1, String team2, int scoreA, int scoreB) {
        BaseballTeam[] teamlist = getTeams(team1, team2);

        if (scoreA > scoreB) {
            teamlist[0].win(teamlist[1], scoreA, scoreB);
        } else {
            teamlist[1].win(teamlist[0], scoreB, scoreA);
        }
    }

    public void readRecord(String teamName) {
        BaseballTeam team = getTeam(teamName);
        team.getMatchRecord();
    }

    public void getTotalMatches() {
        System.out.println("총 경기 수 : " + BaseballTeam.getTotalMatches());
    }

    public void standings() {
        for (int i = 0; i < teams.length; i++) {
            BaseballTeam temp = null;
            for (int j = i + 1; j < teams.length; j++) {
                if (teams[i].getWP() < teams[j].getWP()) {
                    temp = teams[j];
                    teams[j] = teams[i];
                    teams[i] = temp;
                }
            }
        }

        System.out.println("팀    승 패 승률");
        for (BaseballTeam team : teams) {
            System.out.printf("%.3s %2d %2d %.3f\n", team.getTeamName(), team.getWins(), team.getLosses(), team.getWP());
        }
    }

    public void printPE() {
        System.out.println("팀별 피타고리안 승률");
        for (BaseballTeam team : teams) {
            System.out.printf("%s %.3f\n", team.getTeamName(), team.getPE());
        }
    }
}