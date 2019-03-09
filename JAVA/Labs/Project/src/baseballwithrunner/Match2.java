package baseballwithrunner;

public class Match2 {
	private static int outs;
	private int inning;
	private Team2[] teams;
	private static boolean[] runnerOnBases;
	private String half;
	private Team2 home, away;

	public Match2(String team1, String team2) {
		outs = 0;
		inning = 1;
		teams = new Team2[] { new Team2(team1), new Team2(team2) };
		away = teams[0];
		home = teams[1];
		runnerOnBases = new boolean[] {false, false, false};
	}
	
	
    /*
     * 경기 개시 함수
     * - 이닝 함수에서 false 반환 시 경기 종료
     * - 결과 출력
     */
	public void playBall() {
		while (true) {
			// 초 말
			if (!inning(away) || !inning(home)) {
				break;
			}
			inning++;
		}
		getResult(home.getTotalRuns(), away.getTotalRuns());
	}
	
	
    /*
     * 이닝 함수
     * - 한 팀이 한 이닝에 공격하는 과정
     * - 이닝 시작마다 아웃카운트, 주자 상황 초기화, 초, 말 전환
     * - 3아웃 전까지 공격 진행
     * - 9회 이상부터 홈팀이 앞설 시 말 진행 안함
     * - 9회 이상부터 홈팀이 한점이라도 앞서면 끝내기
     * - 경기 종료 조건 시 false 반환
     */
	private boolean inning(Team2 team) {
		outs = 0;
		for (int i = 0; i < runnerOnBases.length; i++) {
			runnerOnBases[i] = false;
		}
		half = (team == away) ? "초" : "말";
		System.out.println(inning + "회" + half + " " + team.getName() + " 공격");
		while (outs < 3) {
			if (team == home && inning >= 9 && home.getTotalRuns() > away.getTotalRuns()) {
				System.out.println();
				return false;
			}
			team.bat();
			System.out.print("주자 : ");
			for (int i = 0; i < runnerOnBases.length; i++) {
				if (runnerOnBases[i]) {
					System.out.print(i + 1 + "루 ");
				}
			}
			System.out.println();
		}
		System.out.println(inning + "회" + half + " 종료");
		if (team == home && inning >= 9 && home.getTotalRuns() != away.getTotalRuns()) {
			System.out.println();
			return false;
		}
		System.out.println("현재 스코어 " + away.getTotalRuns() + ":" + home.getTotalRuns());
		System.out.println();
		return true;
	}

	private void getResult(int runHome, int runAway) {
		String winner = (runHome > runAway) ? home.getName() : away.getName();
		System.out.println("최종 결과 " + away.getTotalRuns() + ":" + home.getTotalRuns());
		System.out.println(winner + " 승리");
	}

	public static int getOuts() {
		return outs;
	}

	public static void setOuts(int outs) {
		Match2.outs = outs;
	}

	public Team2[] getTeams() {
		return teams;
	}

	public void setTeams(Team2[] teams) {
		this.teams = teams;
	}

	public static boolean[] getRunnerOnBases() {
		return runnerOnBases;
	}

	public static void setRunnerOnBases(boolean[] runnerOnBases) {
		Match2.runnerOnBases = runnerOnBases;
	}
}
