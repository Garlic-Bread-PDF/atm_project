package com.example.atmproject.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Transaction implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date", columnDefinition = "TIMESTAMP")
  private LocalDateTime date;

  private String type;

  private Float amount;

  @ManyToOne
  @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber")
  private Account account;

  public Transaction() {}

  public Transaction(Long id, LocalDateTime date, String type, Float amount) {
    this.id = id;
    this.date = date;
    this.type = type;
    this.amount = amount;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
