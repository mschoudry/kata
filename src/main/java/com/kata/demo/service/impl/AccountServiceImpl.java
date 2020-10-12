package com.kata.demo.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.demo.account.personal.Account;
import com.kata.demo.account.transaction.Transaction;
import com.kata.demo.service.AccountService;

/**
 * 
 * Provide different servcies of a BankAccount
 *
 */
@Service
public class AccountServiceImpl implements AccountService {

      private static final Logger LOGGER = LogManager.getLogger(Account.class);

      @Autowired
      public Account account;

      /*
       *  find the accountId in the DateSource and its relevant account with details
       * @see com.kata.demo.service.AccountService#deposit(int, float, java.lang.String)
       */
      @Override
      public boolean deposit(int accountId, float amount, String description) {
            try {
                  account.deposit(amount, description);
                  return true;
            } catch (Exception excp) {
                  LOGGER.error(excp.getMessage(), excp);
            }
            return false;
      }

      /*
       *  find the accountId in the DateSource and its relevant account with details
       * @see com.kata.demo.service.AccountService#withdraw(int, float, java.lang.String)
       */
      @Override
      public boolean withdraw(int accountId, float amount, String description) {
            try {
                  account.withdraw(amount, description);
                  return true;
            } catch (Exception excp) {
                  LOGGER.error(excp.getMessage(), excp);
            }
            return false;
      }

      /**
       * 
       */
      @Override
      public List<Transaction> getStatement(int accountId) {
            try {
                  return this.account.getTransactions().getTransactionList();
            } catch (Exception excp) {
                  LOGGER.error(excp.getMessage(), excp);
            }
            
            return null;

      }

}
