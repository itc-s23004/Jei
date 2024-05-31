//s23004
//'showWinner'で各チームの得点を比較して試合結果を表示する

class d48Q6kadai {
  public static void main(String[] args) {
    if (args.length != 4) {
      System.out.println("数値を４つ指定してください");
      return;
    }

    Achievement teamA = new Achievement();
    teamA.set(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    Achievement teamB = new Achievement();
    teamB.set(Integer.parseInt(args[2]), Integer.parseInt(args[3]));

    Match match = new Match();
    match.setAchievements(teamA, teamB);
    System.out.println(match.showResult());
    System.out.println(match.showWinner());
  }
}

class Match {
  Achievement teamA;
  Achievement teamB;

  void setAchievements(Achievement a, Achievement b) {
    teamA = a;
    teamB = b;
  }

  String showResult() {
    return
      "Team A: " + winPoint(teamA.point, teamB.point, teamA.tryNumber) + " points\n" 
    + "Team B: " + winPoint(teamB.point, teamA.point, teamB.tryNumber) + " points";
  }

  String showWinner() {
    int teamAPoints = winPoint(teamA.point, teamB.point, teamA.tryNumber);
    int teamBPoints = winPoint(teamB.point, teamA.point, teamB.tryNumber);

    if (teamAPoints > teamBPoints) {
      return "チームAの勝利！";
    } else if (teamBPoints > teamAPoints) {
      return "チームBの勝利！";
    } else {
      return "引き分け！";
    }
  }

  int winPoint(int teamXPoint, int teamYPoint, int teamXTryNumber) {
    return matchPoint(teamXPoint, teamYPoint) + bonusPoint(teamXTryNumber);
  }

  int matchPoint(int teamXPoint, int teamYPoint) {
    if (teamXPoint == teamYPoint) {
      return 2;
    } else if (teamXPoint > teamYPoint) {
      return 4;
    } else {
      return 1;
    }
  }

  int bonusPoint(int tryNumber) {
    return tryNumber >= 4 ? 1 : 0;
  }
}

class Achievement {
  int point;
  int tryNumber;

  void set(int teamPoint, int teamTryNumber) {
    point = teamPoint;
    tryNumber = teamTryNumber;
  }
}

