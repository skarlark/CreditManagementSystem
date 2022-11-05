package org.example.bean;

public class MonthlyBreakup {
    private float amortized;
    private float invoice;
    private float interestAmount;
    private float amountDue;

    public MonthlyBreakup(float amortized, float invoice, float interestAmount, float amountDue) {
        this.amortized = amortized;
        this.invoice = invoice;
        this.interestAmount = interestAmount;
        this.amountDue = amountDue;
    }

    public float getAmortized() {
        return amortized;
    }

    public void setAmortized(float amortized) {
        this.amortized = amortized;
    }

    public float getInvoice() {
        return invoice;
    }

    public void setInvoice(float invoice) {
        this.invoice = invoice;
    }

    public float getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(float interestAmount) {
        this.interestAmount = interestAmount;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

}
