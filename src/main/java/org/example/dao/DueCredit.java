package org.example.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "dueCredit")
public class DueCredit {

    private String dueCreditId;
    private String creditId;
    private float dueAmount;
    private float interestAmount;
    private float balanceAmount;
    private LocalDate dueDate;

    public DueCredit() {

    }

    public DueCredit(String dueCreditId, String creditId, float dueAmount, float interestAmount, float balanceAmount, LocalDate dueDate) {
        this.dueCreditId = dueCreditId;
        this.creditId = creditId;
        this.dueAmount = dueAmount;
        this.interestAmount = interestAmount;
        this.balanceAmount = balanceAmount;
        this.dueDate = dueDate;
    }

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String getDueCreditId() {
        return dueCreditId;
    }

    public void setDueCreditId(String dueCreditId) {
        this.dueCreditId = dueCreditId;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public float getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(float dueAmount) {
        this.dueAmount = dueAmount;
    }

    public float getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(float interestAmount) {
        this.interestAmount = interestAmount;
    }

    public float getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(float balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

}
