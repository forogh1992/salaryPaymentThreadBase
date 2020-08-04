package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.ModelType;
import com.forogh.salaryPayment.model.Payment;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentService {

    private final int paymentCount = 20;
    private WriteAndReadService writeAndReadService = new WriteAndReadService();
    private static final Logger log = Logger.getLogger(Payment.class.getName());
    private List<Payment> paymentList;

    final Gson gson = new Gson();

    public void firstCreatingData() {
        paymentList = new ArrayList<>();
        Payment payment = new Payment();
        payment.setName("");

        paymentList.add(payment);
        writeAndReadService.writeOnFile(gson.toJson(paymentList), ModelType.PAYMENT);

        setInitCreditor();
    }

    private void setInitCreditor() {
        paymentList = new ArrayList<>();

        try {
            for (int i = 0; i < paymentCount; i++) {
                Payment paymentDTO = new Payment();
                Random rnd = new Random();
                long amount = rnd.nextInt(200000);
                paymentDTO.setDepositNumber(i);
                paymentDTO.setAmount(amount);
                paymentDTO.setName("employee" + i);

                paymentList.add(paymentDTO);
            }
            writeAndReadService.writeOnFile(gson.toJson(paymentList), ModelType.PAYMENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void WritePayment(List<Payment> paymentDTOList) {
        try {
            writeAndReadService.writeOnFile(gson.toJson(paymentDTOList), ModelType.PAYMENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public List<Payment> getAllCreditorAccount() {
        List<Object> genericList;

        try {
            genericList = writeAndReadService.readFile(ModelType.PAYMENT);

            for (Object obj : genericList) { //cast reading json object to my object(payment)
                Payment payment;
                payment = ((Payment) obj);
                paymentList.add(payment);
            }

        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return paymentList;
    }
}
