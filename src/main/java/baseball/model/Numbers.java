package baseball.model;
import java.util.List;

public class Numbers {
    private final List<Integer> computerNumbers;

    public Numbers(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}