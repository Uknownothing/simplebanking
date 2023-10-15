package com.eteration.simplebanking.model;

//withdrawallTransaction sınıfını extend etmeli cünkü temel olarak hesaptan para çekme mantıgı ile hareket ediyor.
public class BillPaymentTransaction extends WithdrawalTransaction{

    private final String payee;

    public String getPayee() {
        return payee;
    }


    public BillPaymentTransaction(double amount, String payee) {
        super(amount);
        this.payee = payee;
    }

    @Override
    public String toString() {
        return "BillPaymentTransaction{" +
                "payee='" + payee + '\'' +
                '}';
    }
}
