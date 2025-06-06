package sample.cafekiosk.spring.domain.stock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @DisplayName("재고의 수량이 제공된 수량보다 작은지 확인한다.")
    @Test
    void isQuantityLessThan() {
        // given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        // when
        boolean result = stock.isQuantityLessThan(quantity);

        // then
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("재고를 주어진 개수만큼 차감할 수 있다.")
    @Test
    void deductQuantity() {
        // given
        Stock stock = Stock.create("001", 1);
        int quantityToDeduct = 1;

        // when
        stock.deductQuantity(quantityToDeduct);

        // then
        Assertions.assertThat(stock.getQuantity()).isEqualTo(0);
    }

    @DisplayName("재고보다 많은 수의 수량으로 차감 시도하는 경우 예외가 발생한다.")
    @Test
    void deductQuantity_throwsException_whenMoreThanAvailable() {
        // given
        Stock stock = Stock.create("001", 1);
        int quantity = 2;

        // when & then
        Assertions.assertThatThrownBy(() -> stock.deductQuantity(quantity))
                        .isInstanceOf(IllegalArgumentException.class)
                                .hasMessage("재고가 부족합니다.");
        assertThrows(IllegalArgumentException.class, () -> stock.deductQuantity(quantity));
    }
}