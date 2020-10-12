package com.kata.demo.account.personal;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kata.demo.account.transaction.Transaction;
import com.kata.demo.account.transaction.Transactions;

/**
 * Personal Account with all details of transactions(deposit,withdraw)  
 *
 */
public class Account {

      private static final Logger LOGGER = LogManager.getLogger(Account.class);
      
      private final Transactions transactions;
      
      private final int accountId;

      public Account(int accountId) {
            super();
            this.transactions = new Transactions();
            this.accountId = accountId;
      }

      public Transactions getTransactions() {
            return this.transactions;
      }

      public void deposit(final float amount) {
            transactions.deposit(amount);
      }

      public void deposit(final float amount, String description) {
            transactions.deposit(amount, description);
      }

      public void withdraw(final float amount) {
            transactions.withdraw(amount);
      }

      public void withdraw(final float amount, String description) {
            transactions.withdraw(amount, description);
      }

      public void printStatement() {
            List<Transaction> transactinList = transactions.getTransactionList();
            if(transactinList.isEmpty()) {
                  System.out.println("No Transactions found for the Account");                  
            } else {
            transactinList.stream().forEachOrdered(System.out::println);
            }
      }
      
      public int getAccountId() {
            return this.accountId;
      }

}
