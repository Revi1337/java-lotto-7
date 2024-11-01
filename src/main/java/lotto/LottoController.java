package lotto;

import java.util.List;
import lotto.io.InputHandler;
import lotto.io.OutputHandler;
import lotto.model.LottoCashier;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class LottoController {
    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void execute() {
        int price = getPriceFromUser();

        Lottos lottos = purchaseLottos(price);
        outputHandler.showPurchasedLottos(lottos);

        List<Integer> selectedNumbers = getWinningNumbersFromUser();
        int bonusNumber = getBonusNumberFromUser();

        LottoMachine lottoMachine = new LottoMachine(selectedNumbers, bonusNumber);
        lottoMachine.draw(lottos);
        List<LottoResult> lottoResults = lottoMachine.getLottoResults();
    }

    private int getPriceFromUser() {
        outputHandler.showPriceInputNavigateMessage();
        return inputHandler.getPriceFromUser();
    }

    private Lottos purchaseLottos(int price) {
        LottoCashier lottoCashier = new LottoCashier();
        return lottoCashier.purchase(price);
    }

    private List<Integer> getWinningNumbersFromUser() {
        outputHandler.showWinningNumbersInputNavigateMessage();
        return inputHandler.getWinningNumbersFromUser();
    }

    private int getBonusNumberFromUser() {
        outputHandler.showBonusNumberInputNavigateMessage();
        return inputHandler.getBonusNumberFromUser();
    }
}