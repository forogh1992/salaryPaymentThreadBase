package com.forogh.salaryPayment;

import com.forogh.salaryPayment.exception.NotFoundException;
import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.service.DepositService;
import com.forogh.salaryPayment.service.PaymentService;
import com.forogh.salaryPayment.thread.TransactionThread;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {


    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws NotFoundException.InsufficientFundsException, ClassNotFoundException {
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
        for (Payment payments : paymentList)
            sumAmount += payments.getAmount();

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        TransactionThread transactionThread = new TransactionThread();
        transactionThread.setDepositAndPayment(paymentList, deposit);

        if (sumAmount < deposit.getAmount()) {
            executorService.execute(transactionThread);
            executorService.shutdown();
        } else
            throw new NotFoundException("balance not enough requirement is:" + sumAmount);

        log.info(System.currentTimeMillis());
    }
}
