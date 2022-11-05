package org.example.service;

import org.example.bean.CreditPlan;
import org.example.dao.Credit;
import org.example.dao.DueCredit;

public interface CreditPlanService {

    CreditPlan generateCreditPlan(Credit credit);

    String addCreditInfo(Credit credit);

    DueCredit updateCreditPlan(String creditID, float approvedAmount, Integer paybackPeriod);
}
