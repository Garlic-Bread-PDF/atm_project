package com.example.atmproject;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmproject.model.Account;
import com.example.atmproject.model.Transaction;
import com.example.atmproject.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {
  private final TransactionService transactionService;

  public TransactionResource(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping("/get-transactions")
  public ResponseEntity<List<Transaction>> findTransactionsByAccount(@RequestBody Account account) {
    List<Transaction> transactions = transactionService.findTransactionsByAccount(account);
    return new ResponseEntity<>(transactions, HttpStatus.CREATED);
  }

  @PostMapping("/add")
  public ResponseEntity<Transaction> addAccount(@RequestBody Transaction transaction) {
    Transaction newTransaction = transactionService.addTransaction(transaction);
    return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
  }
}
