package artapp.loans_api.domain;

import java.math.BigDecimal;

public class Customer {

    private final String name;
    private final Integer age;
    private final String cpf;
    private final String location;
    private final BigDecimal income;

    public Customer(String name, Integer age, String cpf, String location, BigDecimal income) {
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.location = location;
        this.income = income;
    }

    public boolean isIncomeEqualOrLowerThan(BigDecimal value) {
        return this.income.equals(value) || this.income.compareTo(value) < 0;
    }
}
