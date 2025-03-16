package artapp.loans_api.domain;

import java.math.BigDecimal;

public class Loan {

    private final Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isPersonalLoanAvailable() {
        return customer.isIncomeEqualOrLowerThan(BigDecimal.valueOf(3000));
    }
}
