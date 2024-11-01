package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoCashier {
    private static final int LOTTO_PRICE = 1000;

    public Lottos purchase(int price) {
        int count = getPurchasableCount(price);
        return new Lottos(purchaseLottos(count));
    }

    private int getPurchasableCount(int price) {
        return price / LOTTO_PRICE;
    }

    private List<Lotto> purchaseLottos(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(ignored -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .peek(Collections::sort)
                .map(Lotto::new)
                .toList();
    }
}