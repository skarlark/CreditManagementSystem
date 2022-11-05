package org.example.bean;

public class UpdateCreditPlanRequest {

    private String creditId;
    private float approvedAmount;
    private int paybackPeriod;

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public float getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(float approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public int getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(int paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }
}
