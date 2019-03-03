
package baseballtracker;

public class MatchRecord {
    private BaseballTeam opponent;
    private String result;
    private int myScore;
    private int opponentScore;

    public MatchRecord(BaseballTeam opponent, String result, int myScore, int opponentScore) {
        this.opponent = opponent;
        this.result = result;
        this.myScore = myScore;
        this.opponentScore = opponentScore;
    }

    @Override
    public String toString() {
        return result + " / 상대팀 : " + opponent.getTeamName() + " / 스코어 " + myScore + ":" + opponentScore;
    }
}
