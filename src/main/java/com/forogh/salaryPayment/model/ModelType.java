package com.forogh.salaryPayment.model;

public enum ModelType {

    DEPOSIT("deposit", 1),
    PAYMENT("payment", 2),
    TRANSACTION("transaction", 3);

    private int id;
    private String name;

    ModelType(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
