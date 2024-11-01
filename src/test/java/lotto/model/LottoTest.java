package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void testLotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        System.out.println("lotto = " + lotto);
    }

}