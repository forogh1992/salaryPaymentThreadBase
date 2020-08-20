package com.forogh.salaryPayment.thread;

import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.model.Transaction;
import com.forogh.salaryPayment.service.DepositService;
import com.forogh.salaryPayment.service.PaymentService;
import com.forogh.salaryPayment.service.TransactionService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TransactionThread implements Runnable {
    private List<Payment> paymentList;
    private Deposit deposit;


    @Override
    public void run() {


        List<Transaction> transactionList = new ArrayList<>();
        TransactionService transactionService = new TransactionService();
        DepositService depositService = new DepositService();
        PaymentService paymentService = new PaymentService();

        for (Payment payment : paymentList) {
            Transaction transaction = new Transaction();

            long paymentAmount = payment.getAmount();
            long depositAmount = deposit.getAmount();


            transaction.setDebtorDepositNum(deposit.getDepositNumber());
            transaction.setCreditorDepositNum(payment.getDepositNumber());
            transaction.setAmount(paymentAmount);
            transaction.setCreditorDepositNum(("" + payment.getDepositNumber()));
            transactionList.add(transaction);


                deposit.setAmount(depositAmount - paymentAmount);
                depositService.DepositWrite(deposit);

//                payment.setAmount(0);
        }

        paymentService.WritePayment(paymentList);
        transactionService.WriteTransaction(transactionList);

    }


    public void setDepositAndPayment(List<Payment> paymentList, Deposit deposit) {
        this.deposit = deposit;
        this.paymentList = paymentList;
    }
}

