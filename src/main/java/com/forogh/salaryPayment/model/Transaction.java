package com.forogh.salaryPayment.model;

public class Transaction {

    private int debtorDepositNum;
    private int creditorDepositNum;
    private long amount;

    public int getDebtorDepositNum() {
        return debtorDepositNum;
    }

    public void setDebtorDepositNum(int debtorDepositNum) {
        this.debtorDepositNum = debtorDepositNum;
    }

    public int getCreditorDepositNum() {
        return creditorDepositNum;
    }

    public void setCreditorDepositNum(int creditorDepositNum) {
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
