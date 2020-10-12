package com.kata.demo.service;

import java.util.List;

import com.kata.demo.account.transaction.Transaction;

public interface AccountService {

      public boolean deposit(int accountId, float amount, String description);
      public boolean withdraw(int accountId, float amount, String description);
      public List<Transaction> getStatement(int accountId);
      
}
