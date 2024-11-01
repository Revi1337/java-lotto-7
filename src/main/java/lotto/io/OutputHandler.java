package lotto.io;

import lotto.model.Lottos;

public class OutputHandler {
    public static final String PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String SELECT_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String SELECT_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showPriceInputNavigateMessage() {
        System.out.println(PURCHASE_MESSAGE);
    }

    public void showPurchasedLottos(Lottos lottos) {
        showLottoCount(lottos);
        showLottos(lottos);
    }

    public void showWinningNumbersInputNavigateMessage() {
        System.out.println();
        System.out.println(SELECT_NUMBER_MESSAGE);
    }

    public void showBonusNumberInputNavigateMessage() {
        System.out.println();
        System.out.println(SELECT_BONUS_MESSAGE);
    }

    private void showLottoCount(Lottos lottos) {
        System.out.println();
        System.out.println(lottos.getCount() + "개를 구매했습니다.");
    }

    private void showLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
    }
}