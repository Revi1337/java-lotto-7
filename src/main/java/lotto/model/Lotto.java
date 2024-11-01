package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public int countMatchNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(this::numberContains)
                .count();
    }

    public boolean containsBonusNumber(int number) {
        return numberContains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    private boolean numberContains(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }
}