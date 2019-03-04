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
        mt.writeRecord("한화 이글스", "넥센 히어로즈", 3, 6);
        mt.writeRecord("KT 위즈", "KIA 타이거즈", 5, 4);
        mt.writeRecord("LG 트윈스", "NC 다이노스", 2, 4);
        mt.writeRecord("롯데 자이언츠", "SK 와이번스", 5, 6);
        mt.writeRecord("삼성 라이온즈", "두산 베어스", 6, 3);

        mt.writeRecord("한화 이글스", "넥센 히어로즈", 4, 1);
        mt.writeRecord("KT 위즈", "KIA 타이거즈", 1, 14);
        mt.writeRecord("LG 트윈스", "NC 다이노스", 1, 7);
        mt.writeRecord("롯데 자이언츠", "SK 와이번스", 0, 5);
        mt.writeRecord("삼성 라이온즈", "두산 베어스", 4, 5);

        mt.writeRecord("한화 이글스", "NC 다이노스", 6, 9);
        mt.writeRecord("KT 위즈", "SK 와이번스", 5, 8);
        mt.writeRecord("LG 트윈스", "넥센 히어로즈", 4, 5);
        mt.writeRecord("롯데 자이언츠", "두산 베어스", 0, 5);
        mt.writeRecord("삼성 라이온즈", "KIA 타이거즈", 0, 17);
        
        mt.writeRecord("한화 이글스", "NC 다이노스", 6, 2);
        mt.writeRecord("KT 위즈", "SK 와이번스", 8, 5);
        mt.writeRecord("LG 트윈스", "넥센 히어로즈", 9, 3);
        mt.writeRecord("롯데 자이언츠", "두산 베어스", 5, 6);
        mt.writeRecord("삼성 라이온즈", "KIA 타이거즈", 6, 0);

        mt.writeRecord("한화 이글스", "NC 다이노스", 1, 4);
        mt.writeRecord("KT 위즈", "SK 와이번스", 7, 1);
        mt.writeRecord("LG 트윈스", "넥센 히어로즈", 4, 9);
        mt.writeRecord("롯데 자이언츠", "두산 베어스", 1, 4);
        mt.writeRecord("삼성 라이온즈", "KIA 타이거즈", 0, 7);
        
        mt.readRecord("SK 와이번스");
        mt.readRecord("한화 이글스");
        mt.readRecord("LG 트윈스");

        mt.getTotalMatches();
        mt.standings();
        mt.printPE();
    }
    

}