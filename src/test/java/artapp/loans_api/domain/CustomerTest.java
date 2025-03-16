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

    @Nested
    class IsAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            Customer customer = CustomerFactory.build(25);

            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsUpperThan() {
            Customer customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(20));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualThan() {
            Customer customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class IsLocationEqualThan {

        @Test
        void shouldBeTrueWhenLocationIsEqualThan() {
            Customer customer = CustomerFactory.build("SP");

            assertTrue(customer.isLocationEqualThan("SP"));
        }

        @Test
        void shouldBeTrueWhenLocationIsEqualEvenUpperCaseThan() {
            Customer customer = CustomerFactory.build("sp");

            assertTrue(customer.isLocationEqualThan("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotEqualEvenUpperCaseThan() {
            Customer customer = CustomerFactory.build("rj");

            assertFalse(customer.isLocationEqualThan("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsEqualThan() {
            Customer customer = CustomerFactory.build("RJ");

            assertFalse(customer.isLocationEqualThan("SP"));
        }
    }

    @Nested
    class isIncomeEqualOrUpperThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqualThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(3000));

            assertTrue(customer.isIncomeEqualOrUpperThan(BigDecimal.valueOf(3000)));

        }

        @Test
        void shouldBeTrueWhenIncomeIsUpperThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(3000));

            assertTrue(customer.isIncomeEqualOrUpperThan(BigDecimal.valueOf(2000)));

        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            Customer customer = CustomerFactory.build(BigDecimal.valueOf(4000));

            assertFalse(customer.isIncomeEqualOrUpperThan(BigDecimal.valueOf(5000)));

        }
    }
}