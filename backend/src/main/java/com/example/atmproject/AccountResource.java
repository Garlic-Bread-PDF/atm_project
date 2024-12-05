package com.example.atmproject;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmproject.model.Account;
import com.example.atmproject.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountResource {
  private final AccountService accountService;

  public AccountResource(AccountService accountService) {
    this.accountService = accountService;
  }

  // Get the account with the given account number and pin if one exists
  @GetMapping("/get-account")
  public ResponseEntity<Optional<Account>> getAccountByAccountNumberAndPin(@RequestParam String accountNumber, @RequestParam String pinNumber) throws AccountNotFoundException {
    Optional<Account> account = accountService.getAccountByAccountNumberAndPin(accountNumber, pinNumber);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  // Create the given account
  @PostMapping("/add")
  public ResponseEntity<Account> addAccount(@RequestBody Account account) {
    Account newAccount = accountService.addAccount(account);
    return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
  }

  // Update the given account
  @PutMapping("/update")
  public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
    Account updatedAccount = accountService.updateAccount(account);
    return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
  }

  // Delete the given account
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteAccount(@RequestBody String accountNumber) {
    accountService.deleteAccount(accountNumber);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
