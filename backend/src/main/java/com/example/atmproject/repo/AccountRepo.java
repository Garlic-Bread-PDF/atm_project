package com.example.atmproject.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atmproject.model.Account;

public interface AccountRepo extends JpaRepository<Account, String> {
  Optional<Account> findAccountByAccountNumber(String accountNumber);
  
  Optional<Account> findAccountByAccountNumberAndPinNumber(String accountNumber, String pinNumber);
  
  void deleteAccountByAccountNumber(String accountNumber);
}
