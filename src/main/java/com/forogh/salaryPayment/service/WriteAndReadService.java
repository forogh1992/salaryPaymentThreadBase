package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.Deposit;
import com.forogh.salaryPayment.model.ModelType;
import com.forogh.salaryPayment.model.Payment;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadService {

    final Gson gson = new Gson();
    final String resource = "src/main/resources/";
    private static final Logger log = Logger.getLogger(WriteAndReadService.class.getName());


    public List<Object> readFile(ModelType modelType) {
        List<Object> fileValues = new ArrayList<>();
        try {
            Path path = Paths.get(resource + modelType.getName() + ".json");

            StringBuilder deposit = new StringBuilder();
            List<String> contents = Files.readAllLines(path);
            for (String content : contents)
                deposit.append(content);
/*
            if (modelType==ModelType.DEPOSIT){
                Deposit depositJ = gson.fromJson(deposit.toString(), Deposit.class);
                   fileValues.add(depositJ);
            } else System.out.println("not found");*/


            switch (modelType) {
                case DEPOSIT: {
                    Deposit depositJ = gson.fromJson(deposit.toString(), Deposit.class);
                    fileValues.add(depositJ);
                    break;
                }
                case PAYMENT: {
//                    PaymentDTO dto = gson.fromJson(deposit.toString(), PaymentDTO.class);
//                    fileValues.add(dto);
                    break;
                }
                case TRANSACTION: {
//                    Tra dto = gson.fromJson(deposit.toString(), DepositDTO.class);
//                    fileValues.add(dto);
                    break;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileValues;
    }

    public void writeOnFile(String models, ModelType modelType) {

        Path path = Paths.get(resource + modelType.getName() + ".json");

        try {
            Files.write(path, models.getBytes());
        } catch (IOException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }

    }

}
