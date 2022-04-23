package kitchenpos.eatinorders.tobe.domain;

import java.util.Collections;
import kitchenpos.eatinorders.tobe.exception.InvalidStockQuantityException;
import kitchenpos.menus.tobe.domain.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static kitchenpos.TobeFixtures.newMenu;
import static kitchenpos.TobeFixtures.newMenuGroup;
import static kitchenpos.TobeFixtures.newMenuProduct;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderLineItemTest {

    @Test
    @DisplayName("메뉴가 유효하지 않으면 주문 메뉴 생성 불가능")
    void createOrderLineItemFail01() {
        assertThatExceptionOfType(InvalidOrderLineException.class)
            .isThrownBy(() -> OrderLineItem.create(null, new Stock(1L)));
    }

    @ParameterizedTest
    @ValueSource(longs = { 0, -1, -5, -1000 })
    @DisplayName("재고가 0개 이하면 주문 메뉴 생성 불가능")
    void createOrderLineItemFail02(long quantity) {
        assertThatExceptionOfType(InvalidStockQuantityException.class)
            .isThrownBy(() -> OrderLineItem.create(null, quantity));
    }

    @Test
    @DisplayName("주문 메뉴 생성 성공")
    void createOrderLineSuccess() {
        Menu menu = newMenu("메뉴", 1000L, newMenuGroup("메뉴그룹"), Collections.singletonList(newMenuProduct("메뉴상품", 1000L)));
        assertThatCode(() -> OrderLineItem.create(menu, new Stock(5L)))
            .doesNotThrowAnyException();
    }
}