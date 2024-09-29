package baseball.controller;

import baseball.model.HintGenerator;
import baseball.model.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ComputerController computerController;
    private final HintGenerator hintGenerator;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.computerController = new ComputerController();
        this.hintGenerator = new HintGenerator();
    }

    public void startGame() {
        List<Integer> computerNumbers = computerController.generateComputerNumbers();
        Numbers numbers = new Numbers(computerNumbers);

        boolean gameWon = false;

        while (!gameWon) {
            String input = inputView.getInput();
            if (!inputView.validateInput(input)) {
                System.out.println("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력해주세요.");
                continue;
            }

            List<Integer> playerNumbers = parseInput(input);
            String hint = hintGenerator.generateHint(numbers.getComputerNumbers(), playerNumbers);
            outputView.displayHint(hint);

            if (hint.equals("3스트라이크")) {
                outputView.displayGameOver();
                gameWon = true;
            }
        }
        askForRestart();
    }

    private List<Integer> parseInput(String input) {
        List<Integer> playerNumbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            playerNumbers.add(Character.getNumericValue(c));
        }
        return playerNumbers;
    }

    private void askForRestart() {
        outputView.askRestart();
        String input = Console.readLine();
        if (input.equals("1")) {
            startGame();
        } else if (input.equals("2")) {
            return; // 게임 종료
        } else {
            System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
            askForRestart();
        }
    }
}
