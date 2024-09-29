package baseball.view;

public class OutputView {
    public void displayHint(String hint) {
        System.out.println(hint);
    }
    public void displayGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public void askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}