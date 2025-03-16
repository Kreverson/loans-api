package artapp.loans_api.domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class LoanTest {

    @Mock
    private Customer customer;

    @InjectMocks
    private Loan loan;

    @Nested
    class isPersonalLoanAvailable {

        @Test
        void shouldBeTrueWhenIncomeIsEqualOrLess3K() {
            doReturn(true).when(customer).isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000));

            assertTrue(loan.isPersonalLoanAvailable());
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotEqualOrLess3K() {
            doReturn(false).when(customer).isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000));

            assertFalse(loan.isPersonalLoanAvailable());
        }
    }
}
