package baseballwithrunner;

public class Team2 {
	private String name;
	private int totalRuns;

	public Team2(String name) {
		this.name = name;
		totalRuns = 0;
	}
	
	/*
	 * 공격 함수
	 * - 난수 생성으로 공격 결과 결정
	 * - 공격 결과에 따라 주자 이동
	 * - 볼넷은 주자 움직임이 다름
	 */
	public void bat() {
		try {
			double result = Math.random();
			Thread.sleep(500);
			if (result > BattingStats.OBP) {
				Match2.setOuts(Match2.getOuts() + 1);
				System.out.println(Match2.getOuts() + "아웃");
			} else if (result > BattingStats.BA) {
				baseOnBalls();
			} else if (result > BattingStats.XBH) {
				singleH();
			} else if (result > BattingStats.THREEBASE + BattingStats.HR) {
				twoBaseHit();
			} else if (result > BattingStats.HR) {
				threeBaseHit();
			} else {
				homeRun();
			}
			Thread.sleep(500);
		} catch (Exception e) {
			System.out.println("경기 중단");
		}
	}

	public void baseOnBalls() {
		System.out.println("볼넷");
		runnersMove(1, true);
	}

	public void singleH() {
		System.out.println("안타");
		runnersMove(1, false);
	}

	public void twoBaseHit() {
		System.out.println("2루타");
		runnersMove(2, false);
	}

	public void threeBaseHit() {
		System.out.println("3루타");
		runnersMove(3, false);
	}

	public void homeRun() {
		System.out.println("홈런");
		runnersMove(4, false);
		totalRuns++; // 홈런은 타자까지 득점 포함
	}
	
	/*
	 * 주자 이동 함수
	 * - Match에서 현재 주자 상황 불러옴
	 * - 볼넷일 경우 밀어내기 구현
	 * - 이전 베이스에 주자가 있을 때만 움직임
	 * - 안타 시 base 정수만큼 주자 이동
	 * - 주자가 3루에 갈 수 있으면  
	 * - 3루보다 주자가 더 움직이면 득점, 주자는 사라짐
	 * - 마지막으로 타자를 주자로 변경함
	 */

	public void runnersMove(int base, boolean isBB) {
		boolean[] rOB = Match2.getRunnerOnBases();

		if (isBB) {
			for (int i = 2; i >= 0; i--) {
				if (i == 0 && rOB[0]) {
					rOB[1] = true;
				} else if (i != 0) {
					if (rOB[i] && rOB[i - 1]) {
						if (i == 2 && rOB[0]) {
							System.out.println("득점");
							totalRuns++;
							rOB[2] = false;
						} else {
							rOB[2] = true;
							rOB[1] = false;
						}
					}
				}
			}
		} else {
			for (int i = 2; i >= 0; i--) {
				if (rOB[i]) {
					if (i + base < 2) {
						rOB[i + base] = true;
						rOB[i] = false;
					} else if (i + base == 2) {
						double p = Math.random(); 
						rOB[i] = false;
						if (p > 0.42) {
							System.out.println("득점");
							totalRuns++;
						} else if (p > 0.05) {
							rOB[i + base] = true;
						} else {
							System.out.println("주루사");
							Match2.setOuts(Match2.getOuts() + 1);
							System.out.println(Match2.getOuts() + "아웃");
						}
					} else {
						rOB[i] = false;
						System.out.println("득점");
						totalRuns++;
					}
				}
			}
		}
		
		if (base != 4) {
			rOB[base - 1] = true;
		}
		Match2.setRunnerOnBases(rOB);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
}
