package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.ModelType;
import com.forogh.salaryPayment.model.Payment;
import com.forogh.salaryPayment.model.Transaction;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.List;

public class TransactionService {

    private WriteAndReadService writeAndReadService = new WriteAndReadService();
    private static final Logger log = Logger.getLogger(Payment.class.getName());
    private List<Transaction> paymentList;

    public void WriteTransaction(List<Transaction> transactionList) {
        try {
            writeAndReadService.writeOnFile(transactionList, ModelType.TRANSACTION);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
