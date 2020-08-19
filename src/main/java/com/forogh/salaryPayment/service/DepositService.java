package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.ModelType;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.List;

public class DepositService {

    final Gson gson = new Gson();
    private WriteAndReadService writeAndRead = new WriteAndReadService();
    private static final Logger log = Logger.getLogger(Deposit.class.getName());
    private List<Deposit> deposits;


    public synchronized void firstCreatingData() {
        Deposit deposit = new Deposit();
        deposit.setDepositNumber("1.10.100.1");
        deposit.setName("Xbank");
        deposit.setAmount(200000000);

        writeAndRead.writeOnFile(gson.toJson(deposit), ModelType.DEPOSIT);
    }

    public synchronized void DepositWrite(Deposit deposit) {
        writeAndRead.writeOnFile(gson.toJson(deposit), ModelType.DEPOSIT);
    }


    public Deposit getDeposit() {
        List<Object> genericList;
        Deposit deposit = new Deposit();

        try {
            genericList = writeAndRead.readFile(ModelType.DEPOSIT);

            for (Object obj : genericList) {
                deposit = ((Deposit) obj);
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return deposit;
    }

}
