package org.example.dao;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "credit")
public class Credit {
    private String creditId;
    private String ssn;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private float creditAmount;
    private Integer paybackPeriod;
    private float annualInterest;
    private float invoiceFee;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }


    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(float creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getPaybackPeriod() {
        return paybackPeriod;
    }

    public void setPaybackPeriod(Integer paybackPeriod) {
        this.paybackPeriod = paybackPeriod;
    }

    public float getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(float annualInterest) {
        this.annualInterest = annualInterest;
    }

    public float getInvoiceFee() {
        return invoiceFee;
    }

    public void setInvoiceFee(float invoiceFee) {
        this.invoiceFee = invoiceFee;
    }
}
