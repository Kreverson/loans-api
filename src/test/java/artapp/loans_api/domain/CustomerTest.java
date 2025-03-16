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

    @Nested
    class IsIncomeBetweenThan {

        @Test
        void shouldBeTrueWhenIncomeIsBetweenThan() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(3000));

            assertTrue(customer.isIncomeBetweenThan(BigDecimal.valueOf(2000), BigDecimal.valueOf(4000)));
        }

        @Test
        void shouldBeTrueWhenIncomeIsMinInBetweenThan() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(2000));

            assertTrue(customer.isIncomeBetweenThan(BigDecimal.valueOf(2000), BigDecimal.valueOf(4000)));
        }

        @Test
        void shouldBeTrueWhenIncomeIsMaxInBetweenThan() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(4000));

            assertTrue(customer.isIncomeBetweenThan(BigDecimal.valueOf(2000), BigDecimal.valueOf(4000)));
        }

        @Test
        void shouldBeFalseWhenIncomeIsUpperTheBetweenThan() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(4000.01));

            assertFalse(customer.isIncomeBetweenThan(BigDecimal.valueOf(2000), BigDecimal.valueOf(4000)));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerTheBetweenThan() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(1999.99));

            assertFalse(customer.isIncomeBetweenThan(BigDecimal.valueOf(2000), BigDecimal.valueOf(4000)));
        }
    }
}