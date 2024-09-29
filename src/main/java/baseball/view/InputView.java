package baseball.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public boolean validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리 숫자를 입력해야 합니다.");
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) || input.indexOf(c) != input.lastIndexOf(c)) {
                throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
            }
        }
        return true;
    }

}