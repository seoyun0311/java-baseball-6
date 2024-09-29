package baseball.model;

import java.util.List;

public class HintGenerator {
    public String generateHint(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(playerNumbers.get(i))) {
                strike++;
            }
            else if (computerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }

        if (strike == 3) {
            return "3스트라이크";
        }
        else if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        else {
            return ball + "볼 " + strike + "스트라이크";
        }
    }
}