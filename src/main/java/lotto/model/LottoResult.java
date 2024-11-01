package lotto.model;

public class LottoResult {
    private final ResultState state;

    public LottoResult(int matchCount, boolean matchBonus) {
        this.state = ResultState.from(matchCount, matchBonus);
    }
}
