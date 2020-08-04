package com.forogh.salaryPayment.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String exception) {
        super(exception);
    }

    public static class InsufficientFundsException extends Exception {


        private long amount;

        public InsufficientFundsException(String message, long amount) {

            super(message);
            this.amount = amount;
        }

        public void test() {
        }

        public long getAmount() {
            return amount;
        }
    }
}
