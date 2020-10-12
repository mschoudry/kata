package com.kata.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kata.demo.account.personal.Account;

public class AccountTest {

      Account account;

      @Before
      public void setUp() {
            account = new Account(1);
            
            // set Starting balance
            account.deposit(500, "Initial Deposit");
      }

      @Test
      public void testAmountDeposit() {

            account.deposit(100);
            account.deposit(100);
            account.deposit(150.5F);

            assertEquals(850.5, account.getTransactions().getCurrentBalance());
      }
      
      @Test
      public void testAmountWithDraw() {

            account.withdraw(100);
            account.withdraw(50);
            account.withdraw(50.5F);

            assertEquals(299.5, account.getTransactions().getCurrentBalance());
      }
      
      @Test
      public void testAmountDepositAndWithDraw() {

            account.withdraw(100);
            account.deposit(100);
            account.deposit(100);
            account.withdraw(50);
            account.withdraw(50.5F);

            assertEquals(499.5, account.getTransactions().getCurrentBalance());
      }
      
      @Test public void testPrintStatement() {
          
            account.deposit(100);
            account.withdraw(50);
            account.withdraw(50.5F);
            
            account.deposit(100);
            account.deposit(50);
            account.deposit(50.5F);
            
            account.printStatement();
          
      }

}
