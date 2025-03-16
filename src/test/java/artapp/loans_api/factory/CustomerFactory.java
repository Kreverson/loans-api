package artapp.loans_api.factory;

import artapp.loans_api.domain.Customer;

import java.math.BigDecimal;

public class CustomerFactory {

    public static Customer build() {
        return new Customer("Loan",25,"123.456.789-00","SP", BigDecimal.valueOf(3000));
    }

    public static Customer build(BigDecimal income) {
        return new Customer("Loan",25,"123.456.789-00","SP", income);
    }
}
