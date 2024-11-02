package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구입한 Lotto 들을 테스트한다.")
class LottosTest {

    @DisplayName("구입한 로또의 개수를 확인한다.")
    @Test
    void lottosTest() {
        List<Lotto> lottoList = generateLottos(3);
        Lottos lottos = new Lottos(lottoList);

        int lottoSize = lottos.size();

        assertThat(lottoSize).isEqualTo(lottoList.size());
    }

    private List<Lotto> generateLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(ignored -> Randoms.pickUniqueNumbersInRange(1, 45, 6))
                .peek(Collections::sort)
                .map(Lotto::new)
                .toList();
    }
}