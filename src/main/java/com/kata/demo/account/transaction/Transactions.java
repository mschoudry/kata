package com.kata.demo.account.transaction;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.kata.demo.account.personal.Account;

/**
 * Transactions to hold all transactions of the account holder
 *
 */
public class Transactions {
      
      private static final Logger LOGGER = LogManager.getLogger(Account.class);
      
      List<Transaction> transactionList;
      double currentBalance; 
      
      public Transactions() {
            transactionList = new ArrayList<Transaction>();
      }
      
      public void deposit(final float amount) {
            this.deposit(amount, "");           
      }
      
      public void deposit(final float amount, String description) {
            synchronized (this) {
                  currentBalance += amount;
                  transactionList.add(new Transaction(TransactionType.DEPOSIT, currentBalance, description));
                  LOGGER.info("Amount Deposited New balance:"+this.currentBalance);
            }      
            
      }
      
      public void withdraw(final float amount) {
            this.withdraw(amount, ""); 
      }
      
      public void withdraw(final float amount, String description) {
            synchronized (this) {
                  currentBalance -= amount;
                  transactionList.add(new Transaction(TransactionType.WITHDRAW, currentBalance, description));
                  LOGGER.info("Amount WithDraw New balance:"+this.currentBalance);
            }
      }

      public List<Transaction> getTransactionList() {
            return transactionList;
      }

      public double getCurrentBalance() {
            return currentBalance;
      }
      
      

}
