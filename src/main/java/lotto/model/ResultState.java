package lotto.model;

import java.util.Arrays;

public enum ResultState {
    NON_MATCH(0, false, 0),
    THREE_MATCH(3, false, 5_000),
    FOUR_MATCH(4, false, 50_000),
    FIVE_MATCH(5, false, 1_500_000),
    FIVE_BONUS_MATCH(5, true, 30_000_000),
    SIX_MATCH(6, false, 2_000_000_000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    ResultState(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static ResultState from(int matchCount, boolean matchBonus) {
        return Arrays.stream(ResultState.values())
                .filter(count -> count.matchCount == matchCount)
                .filter(bonus -> bonus.matchBonus == matchBonus)
                .findFirst()
                .orElse(NON_MATCH);
    }
}
