package org.example.bean;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CreditPlan {
    private float approvedAmount;
    private float interest;
    private Integer paybackPeriod;
    private float fee;
    private List<MonthlyBreakup> monthlyBreakup;

    private CreditPlan(float approvedAmount, float interest, Integer paybackPeriod, float fee, List<MonthlyBreakup> monthlyBreakup) {
        this.approvedAmount = approvedAmount;
        this.interest = interest;
        this.paybackPeriod = paybackPeriod;
        this.fee = fee;
        this.monthlyBreakup = monthlyBreakup;
    }

    public float getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(float approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Integer getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(Integer paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public List<MonthlyBreakup> getMonthlyBreakup() {
        return monthlyBreakup;
    }

    public void setMonthlyBreakup(List<MonthlyBreakup> monthlyBreakup) {
        this.monthlyBreakup = monthlyBreakup;
    }

    public static class CreditPlanBuilder {
        private float approvedAmount;
        private float interest;
        private Integer paybackPeriod;
        private float fee;
        private List<MonthlyBreakup> monthlyBreakupList;

        public CreditPlanBuilder withApprovedAmount(float approvedAmount) {
            this.approvedAmount = approvedAmount;
            return this;
        }

        public CreditPlanBuilder withInterest(float interest) {
            this.interest = interest;
            return this;
        }

        public CreditPlanBuilder withPaybackPeriod(Integer paybackPeriod) {
            this.paybackPeriod = paybackPeriod;
            return this;
        }

        public CreditPlanBuilder withFee(float fee) {
            this.fee = fee;
            return this;
        }

        public CreditPlanBuilder addMonthlyBreakup(MonthlyBreakup monthlyBreakup) {
            if (CollectionUtils.isEmpty(this.monthlyBreakupList)) {
                monthlyBreakupList = new ArrayList();
            }
            monthlyBreakupList.add(monthlyBreakup);
            return this;
        }

        public CreditPlan build() {
            return new CreditPlan(approvedAmount, interest, paybackPeriod, fee, monthlyBreakupList);
        }
    }

}
