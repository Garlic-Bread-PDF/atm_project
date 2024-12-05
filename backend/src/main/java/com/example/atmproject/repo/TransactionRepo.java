package com.example.atmproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atmproject.model.Account;
import com.example.atmproject.model.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
  List<Transaction> findTransactionsByAccount(Account account);
}
