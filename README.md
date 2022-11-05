# CreditManagementSystem

MYSQL Database Commands

CREATE DATABASE CREDIT_SYS;
USE CREDIT_SYS; 

CREATE TABLE credit(creditId varchar(36) NOT NULL, ssn varchar(10) NOT NULL, firstName varchar(30) NOT NULL, lastName varchar(30) NOT NULL, email varchar(30) NOT NULL, phone varchar(10) NOT NULL, creditAmount float(8,2) NOT NULL, paybackPeriod INTEGER NOT NULL, annualInterest DECIMAL(4,2) NOT NULL, invoiceFee float(8,2) NOT NULL, PRIMARY KEY (creditId));

CREATE TABLE dueCredit(dueCreditId varchar(36) NOT NULL, creditId varchar(36) NOT NULL, dueAmount float(8,2) NOT NULL, interestAmount float(8,2) NOT NULL, balanceAmount float(8,2) NOT NULL, dueDate DATE, PRIMARY KEY (dueCreditId));



CREDIT table maintains records of all approved credit requests
DUECREDIT table will record the next due amount and related info for a given creditID

The API currently performs
1. operation to add credit and respond back with creditPlan
2. update CreditPlan

