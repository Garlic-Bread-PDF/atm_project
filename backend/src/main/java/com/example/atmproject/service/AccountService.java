package com.example.atmproject.service;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.atmproject.model.Account;
import com.example.atmproject.repo.AccountRepo;

@Service
public class AccountService {
  private final AccountRepo accountRepo;

  @Autowired
  public AccountService(AccountRepo accountRepo) {
    this.accountRepo = accountRepo;
  }

  // Get the account with the given account number and pin if one exists
  public Optional<Account> getAccountByAccountNumberAndPin(String accountNumber, String pinNumber) throws AccountNotFoundException {
    return accountRepo.findAccountByAccountNumberAndPinNumber(accountNumber, pinNumber);
  }

  // Create the given account if it doesn't already exist
  public Account addAccount(Account account) {
    if (!accountRepo.findAccountByAccountNumber(account.getAccountNumber()).isEmpty()) return null;
    else return accountRepo.save(account);
  }

  // Update the given account
  public Account updateAccount(Account account) {
    return accountRepo.save(account);
  }

  // Delete the given account
  public void deleteAccount(String accountNumber) {
    accountRepo.deleteAccountByAccountNumber(accountNumber);
  }
}
