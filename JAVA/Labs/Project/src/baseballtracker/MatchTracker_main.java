package baseballtracker;

/*
야구 경기 기록기
- 팀 2개를 입력해 스코어를 입력하면 승패를 각 팀마다 기록해준다
- 총 경기 수를 볼 수 있다
- 팀별 기록을 볼 수 있다.
*/

public class MatchTracker_main {
    public static void main(String[] args) {
        MatchTracker mt = new MatchTracker();
        mt.writeRecord(mt.teams[0], mt.teams[1], 10, 5);
        mt.writeRecord(mt.teams[0], mt.teams[1], 6, 8);
        mt.writeRecord(mt.teams[7], mt.teams[0], 5, 0);
        mt.readRecord(mt.teams[0]);
        mt.readRecord(mt.teams[1]);
        mt.readRecord(mt.teams[7]);

        mt.getTotalMatches();
    }
    

}