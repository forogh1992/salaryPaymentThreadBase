package com.forogh.salaryPayment;

import com.forogh.salaryPayment.exception.NotFoundException;
import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.service.DepositService;
import com.forogh.salaryPayment.service.PaymentService;
import com.forogh.salaryPayment.thread.TransactionThread;

import java.util.List;

public class Main {

    public static void main(String[] args) throws NotFoundException.InsufficientFundsException {

        List<Payment> paymentList;

        DepositService depositService = new DepositService();
        PaymentService paymentService = new PaymentService();
        Deposit deposit;
        Payment payment = new Payment();

        depositService.firstCreatingData();
        paymentService.firstCreatingData();

        paymentList = paymentService.getAllCreditorAccount();
        deposit = depositService.getDeposit();

        long sumAmount = 0;
        for (Payment payments : paymentList) {
            sumAmount += payments.getAmount();
        }

        TransactionThread transactionThread = new TransactionThread();
        transactionThread.setDepositAndPayment(paymentList, deposit);

        Thread thread = new Thread(transactionThread);
        if (sumAmount < deposit.getAmount()) {
            thread.start();

        } else throw new NotFoundException.InsufficientFundsException("balance not enough requirement is:", sumAmount);

    }
}
