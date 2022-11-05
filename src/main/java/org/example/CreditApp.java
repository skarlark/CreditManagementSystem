package org.example;

import org.example.bean.CreditPlan;
import org.example.bean.UpdateCreditPlanRequest;
import org.example.dao.Credit;
import org.example.dao.DueCredit;
import org.example.service.CreditPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;


//TODO: add logging and unit test cases, handle UUID in hibernate

@RestController()
@EnableAutoConfiguration
@ComponentScan(basePackages = "org.example")
@RequestMapping("/credit")
public class CreditApp {

    @Autowired
    private CreditPlanService creditPlanService;

    @PostMapping("/createCreditPlan")
    public CreditPlan getCreditPlan(@RequestBody Credit credit) {
        return creditPlanService.generateCreditPlan(credit);
    }

    @PostMapping("/updateCreditPlan")
    public DueCredit updateCreditPlan(@RequestBody UpdateCreditPlanRequest updateCreditPlanRequest) {
        return creditPlanService.updateCreditPlan(updateCreditPlanRequest.getCreditId(), updateCreditPlanRequest.getApprovedAmount(), updateCreditPlanRequest.getPaybackPeriod());
    }

    public static void main(String[] args) {
        SpringApplication.run(CreditApp.class, args);
    }


}