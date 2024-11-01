package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private List<LottoResult> lottoResults = new ArrayList<>();
    private boolean isDrawn;

    public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public void draw(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            int countedMatchNumbers = lotto.countMatchNumbers(winningNumbers);
            boolean matchBonus = lotto.containsBonusNumber(bonusNumber);
            addLottoResult(countedMatchNumbers, matchBonus);
        }

        completeDraw();
    }

    public List<LottoResult> getLottoResults() {
        if (drawnNotYet()) {
            throw new IllegalArgumentException("[ERROR] 아직 추첨하지 않아 통계를 낼 수 없습니다.");
        }

        return Collections.unmodifiableList(this.lottoResults);
    }

    private void addLottoResult(int countedMatchNumbers, boolean matchBonus) {
        if (countedMatchNumbers == 5 && matchBonus) {
            this.lottoResults.add(new LottoResult(countedMatchNumbers, true));
            return;
        }

        this.lottoResults.add(new LottoResult(countedMatchNumbers, false));
    }

    private void completeDraw() {
        this.isDrawn = true;
    }

    private boolean drawnNotYet() {
        return !alreadyDrawn();
    }

    private boolean alreadyDrawn() {
        return this.isDrawn;
    }
}