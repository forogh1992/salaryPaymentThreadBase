package com.forogh.salaryPayment.thread;

import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.model.Transaction;
import com.forogh.salaryPayment.service.DepositService;
import com.forogh.salaryPayment.service.PaymentService;
import com.forogh.salaryPayment.service.TransactionService;

import java.util.ArrayList;
import java.util.List;

public class TransactionThread implements Runnable {
    private List<Payment> paymentList;
    private Deposit deposit;


    @Override
    public void run() {


        List<Transaction> transaction = new ArrayList<>();
        TransactionService transactionService = new TransactionService();
        DepositService depositService = new DepositService();
        PaymentService paymentService = new PaymentService();

        for (Payment payment : paymentList) {
            Transaction transactionDTO = new Transaction();

            long paymentAmount = payment.getAmount();
            long depositAmount = deposit.getAmount();


            transactionDTO.setDebtorDepositNum(deposit.getDepositNumber());
            transactionDTO.setCreditorDepositNum(payment.getDepositNumber());
            transactionDTO.setAmount(paymentAmount);
            transactionDTO.setCreditorDepositNum(Integer.parseInt("" + payment.getDepositNumber()));
            transaction.add(transactionDTO);

            deposit.setAmount(depositAmount - paymentAmount);
            depositService.DepositWrite(deposit);

//                payment.setAmount(0);
        }

        paymentService.WritePayment(paymentList);
        transactionService.WriteTransaction(transaction);

    }


    public void setDepositAndPayment(List<Payment> paymentList, Deposit deposit) {
        this.deposit = deposit;
        this.paymentList = paymentList;
    }
}

