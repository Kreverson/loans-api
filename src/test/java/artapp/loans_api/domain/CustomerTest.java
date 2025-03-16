package artapp.loans_api.domain;

import artapp.loans_api.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Nested
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqualThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(3000));

            assertTrue(customer.isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000)));

        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(2000));

            assertTrue(customer.isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000)));

        }

        @Test
        void shouldBeFalseWhenIncomeIsUpperThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(4000));

            assertFalse(customer.isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000)));

        }
    }
}