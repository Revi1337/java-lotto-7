package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("지불 금액을 테스트한다.")
class PriceTest {

    @DisplayName("성공 케이스를 테스트한다.")
    @Nested
    class HappyCase {

        @DisplayName("지불 금액이 1000 단위면 성공한다.")
        @ParameterizedTest
        @ValueSource(ints = {1000, 2000, 3000, 50000})
        void testPriceConstructor(int money) {
            Price price = new Price(money);

            assertThat(price).isNotNull();
        }
    }

    @DisplayName("실패 케이스를 테스트한다.")
    @Nested
    class EdgeCase {

        @DisplayName("지불 금액이 0이면 실패한다.")
        @ParameterizedTest
        @ValueSource(ints = {0})
        void testPriceZero(int money) {
            assertThatThrownBy(() -> new Price(money))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("지불 금액이 1000 단위가 아니면 실패한다.")
        @ParameterizedTest
        @ValueSource(ints = {200, 2012, 5001})
        void testPriceUnit(int money) {
            assertThatThrownBy(() -> new Price(money))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("지불 금액이 음수면 실패한다.")
        @ParameterizedTest
        @ValueSource(ints = {0, -0})
        void testPriceRange(int money) {
            assertThatThrownBy(() -> new Price(money))
                    .isExactlyInstanceOf(IllegalArgumentException.class);
        }
    }
}