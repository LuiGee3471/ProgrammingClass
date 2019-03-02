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
        return result + " / 상대팀 : " + opponent + " / 스코어 " + myScore + ":" + opponentScore;
    }

    public BaseballTeam getLoser() {
        return loser;
    }

    public void setLoser(BaseballTeam loser) {
        this.loser = loser;
    }

    public BaseballTeam getWinner() {
        return winner;
    }

    public void setWinner(BaseballTeam winner) {
        this.winner = winner;
    }

    public int getWinnerScore() {
        return winnerScore;
    }

    public void setWinnerScore(int winnerScore) {
        this.winnerScore = winnerScore;
    }

    public int getLoserScore() {
        return loserScore;
    }

    public void setLoserScore(int loserScore) {
        this.loserScore = loserScore;
    }
}