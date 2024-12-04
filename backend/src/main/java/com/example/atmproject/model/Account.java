package com.example.atmproject.model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Account implements Serializable {
  @Id
  private String accountNumber;
  private String pinNumber;
  private Float balance;

  public Account() {}

  public Account(String accountNumber, String pinNumber, Float balance) {
    this.accountNumber = accountNumber;
    this.pinNumber = pinNumber;
    this.balance = balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getPinNumber() {
    return pinNumber;
  }

  public void setPinNumber(String pinNumber) {
    this.pinNumber = pinNumber;
  }

  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }
}


