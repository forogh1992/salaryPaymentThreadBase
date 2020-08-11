package com.forogh.salaryPayment.model;

public class Transaction {

    private String debtorDepositNum;
    private String creditorDepositNum;
    private long amount;

    public String getDebtorDepositNum() {
        return debtorDepositNum;
    }

    public void setDebtorDepositNum(String debtorDepositNum) {
        this.debtorDepositNum = debtorDepositNum;
    }

    public String getCreditorDepositNum() {
        return creditorDepositNum;
    }

    public void setCreditorDepositNum(String creditorDepositNum) {
        this.creditorDepositNum = creditorDepositNum;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "debtorDepositNum=" + debtorDepositNum +
                ", creditorDepositNum=" + creditorDepositNum +
                ", amount=" + amount +
                '}';
    }
}
