package com.example.atmproject.service;

import java.util.List;
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

  public Account addAccount(Account account) {
    if (!accountRepo.findAccountByAccountNumber(account.getAccountNumber()).isEmpty()) return null;
    else return accountRepo.save(account);
  }

  public List<Account> findAllAccounts() {
    return accountRepo.findAll();
  }

  public Account updateAccount(Account account) {
    return accountRepo.save(account);
  }

  public Optional<Account> getAccountByAccountNumberAndPin(String accountNumber, String pinNumber) throws AccountNotFoundException {
    return accountRepo.findAccountByAccountNumberAndPinNumber(accountNumber, pinNumber);
  }

  public void deleteAccount(String accountNumber) {
    accountRepo.deleteAccountByAccountNumber(accountNumber);
  }
}
