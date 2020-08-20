package com.forogh.salaryPayment.service;


import com.forogh.salaryPayment.model.ModelType;
import com.forogh.salaryPayment.model.Payment;
import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaymentService {

    private final int paymentCount = 100;
    private WriteAndReadService writeAndReadService = new WriteAndReadService();
    private static final Logger log = Logger.getLogger(Payment.class.getName());
    private List<Payment> paymentList;


    public void firstCreatingData() {
        paymentList = new ArrayList<>();
        Payment payment = new Payment();
        payment.setName("");

        paymentList.add(payment);
        writeAndReadService.writeOnFile(paymentList, ModelType.PAYMENT);

        setInitCreditor();
    }

    private void setInitCreditor() {
        paymentList = new ArrayList<>();

        try {
            for (int i = 1; i <= paymentCount; i++) {
                Payment paymentDTO = new Payment();
                Random rnd = new Random();
                long amount = rnd.nextInt(200000);
                paymentDTO.setDepositNumber("1.20.100."+i);
                paymentDTO.setAmount(amount);
                paymentDTO.setName("employee" + i);

                paymentList.add(paymentDTO);
            }
            writeAndReadService.writeOnFile(paymentList, ModelType.PAYMENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void WritePayment(List<Payment> paymentDTOList) {
        try {
            writeAndReadService.writeOnFile(paymentList, ModelType.PAYMENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
    }


    public List<Payment> getAllCreditorAccount() {
        try {
            paymentList = (List<Payment>) writeAndReadService.readFile(ModelType.PAYMENT);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return paymentList;
    }
}
