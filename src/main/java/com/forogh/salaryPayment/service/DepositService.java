package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.ModelType;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.List;

public class DepositService {



    private WriteAndReadService writeAndRead = new WriteAndReadService();
    private static final Logger log = Logger.getLogger(Deposit.class.getName());
    private Deposit deposit;

    public synchronized void firstCreatingData() {
        Deposit deposit = new Deposit();
        deposit.setDepositNumber("1.10.100.1");
        deposit.setName("Xbank");
        deposit.setAmount(2000000000);

        writeAndRead.writeOnFile(deposit, ModelType.DEPOSIT);
    }

    public synchronized void DepositWrite(Deposit deposit) {
        writeAndRead.writeOnFile(deposit, ModelType.DEPOSIT);
    }


    public Deposit getDeposit() throws ClassNotFoundException {
        deposit = (Deposit) writeAndRead.readFile(ModelType.DEPOSIT);
        return deposit;
    }
}
