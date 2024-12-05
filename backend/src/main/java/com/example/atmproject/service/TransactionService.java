package com.example.atmproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atmproject.model.Account;
import com.example.atmproject.model.Transaction;
import com.example.atmproject.repo.TransactionRepo;

@Service
public class TransactionService {
  private final TransactionRepo transactionRepo;

  @Autowired
  public TransactionService(TransactionRepo transactionRepo) {
    this.transactionRepo = transactionRepo;
  }

  public Transaction addTransaction(Transaction transaction) {
    return transactionRepo.save(transaction);
  }

  public List<Transaction> findTransactionsByAccount(Account account) {
    return transactionRepo.findTransactionsByAccount(account);
  }
}
