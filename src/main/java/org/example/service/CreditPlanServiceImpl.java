package org.example.service;

import org.example.bean.CreditPlan;
import org.example.bean.MonthlyBreakup;
import org.example.dao.Credit;
import org.example.dao.DueCredit;
import org.example.repository.CreditRepository;
import org.example.repository.DueCreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class CreditPlanServiceImpl implements CreditPlanService {

    private static final int YEAR_TO_MONTH_INTEREST = 1200;

    @Autowired
    private CreditRepository creditRepository;
    @Autowired
    private DueCreditRepository dueCreditRepository;

    @Override
    public CreditPlan generateCreditPlan(Credit credit) {

        float amortizedAmount = Math.round(credit.getCreditAmount() / credit.getPaybackPeriod().floatValue());

        CreditPlan.CreditPlanBuilder creditPlanBuilder = new CreditPlan.CreditPlanBuilder().withApprovedAmount(credit.getCreditAmount())
                .withFee(credit.getInvoiceFee())
                .withInterest(credit.getAnnualInterest())
                .withPaybackPeriod(credit.getPaybackPeriod());

        float remainingAmount = credit.getCreditAmount();
        for (int i = 0; i < credit.getPaybackPeriod(); i++) {
            float monthlyInterest = remainingAmount * (credit.getAnnualInterest() / YEAR_TO_MONTH_INTEREST);
            creditPlanBuilder.addMonthlyBreakup(new MonthlyBreakup(amortizedAmount, credit.getInvoiceFee(), monthlyInterest, amortizedAmount + credit.getInvoiceFee() + monthlyInterest));
            remainingAmount -= amortizedAmount;
        }

        String creditID = addCreditInfo(credit);
        addInitialDueCreditInfo(creditID, credit.getCreditAmount(), credit.getPaybackPeriod(), credit.getAnnualInterest(), credit.getInvoiceFee());
        return creditPlanBuilder.build();
    }

    @Override
    public String addCreditInfo(Credit credit) {
        return creditRepository.save(credit).getCreditId();
    }

    @Override
    public DueCredit updateCreditPlan(String creditID, float approvedAmount, Integer paybackPeriod) {
        DueCredit dueCredit = dueCreditRepository.findByCreditId(creditID);
        Credit credit = creditRepository.findByCreditId(creditID);
        if (dueCredit == null || credit == null) {
            throw new IllegalStateException("Credit Id/Due Credit doesn't exist");
        }
        return updateDueCreditInfo(dueCredit.getDueCreditId(), creditID, approvedAmount, paybackPeriod, credit.getAnnualInterest(), credit.getInvoiceFee(), dueCredit.getDueDate());
    }


    private DueCredit addInitialDueCreditInfo(String creditID, float approvedAmount, Integer paybackPeriod, float interestRatePerAnum, float invoiceFee) {
        float interest = (approvedAmount) * (interestRatePerAnum / YEAR_TO_MONTH_INTEREST);
        float dueAmount = (approvedAmount / paybackPeriod) + interest + invoiceFee;
        return dueCreditRepository.save(new DueCredit("", creditID, dueAmount, interest, approvedAmount, LocalDate.now().plusMonths(1)));
    }

    private DueCredit updateDueCreditInfo(String dueCreditId, String creditId, float approvedAmount, Integer paybackPeriod, float interestRatePerAnum, float invoiceFee, LocalDate dueDate) {
        float interest = (approvedAmount) * (interestRatePerAnum / YEAR_TO_MONTH_INTEREST);
        float dueAmount = (approvedAmount / paybackPeriod) + interest + invoiceFee;
        return dueCreditRepository.save(new DueCredit(dueCreditId, creditId, dueAmount, interest, approvedAmount, dueDate));
    }

}
