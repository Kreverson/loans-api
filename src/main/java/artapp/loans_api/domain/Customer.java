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

    public boolean isIncomeBetweenThan(BigDecimal min, BigDecimal max) {
        return (this.income.equals(max) || this.income.compareTo(max) < 0)
                && (this.income.equals(min) || this.income.compareTo(min) > 0);
    }

    public boolean isAgeLowerThan(Integer value) {
        return this.age < value;
    }

    public boolean isLocationEqualThan(String value) {
        return this.location.equalsIgnoreCase(value);
    }
}
