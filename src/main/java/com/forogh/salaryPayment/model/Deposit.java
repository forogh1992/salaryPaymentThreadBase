package com.forogh.salaryPayment.model;

public class Deposit {
    private String depositNumber;
    private long amount;
    private String name;

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "id=" + depositNumber +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
