package com.forogh.salaryPayment.model;

public class Payment {

    private int depositNumber;
    private long amount;
    private String name;

    public int getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(int depositNumber) {
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
        return "Payment{" +
                "depositNumber=" + depositNumber +
                ", amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
