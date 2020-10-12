package com.kata.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.kata.demo.account.transaction.Transactions;

public class TransactionsTest {

      Transactions transactions;

      @Before
      public void setUp() {
            transactions = new Transactions();
            
            // set Starting balance
            transactions.deposit(500, "Initial Deposit");
      }

      @Test
      public void testAmountDeposit() {

            transactions.deposit(100);
            transactions.deposit(100);
            transactions.deposit(150.5F);

            assertEquals(850.5, transactions.getCurrentBalance());
      }
      
      @Test
      public void testAmountWithDraw() {

            transactions.withdraw(100);
            transactions.withdraw(50);
            transactions.withdraw(50.5F);

            assertEquals(299.5, transactions.getCurrentBalance());
      }
      
      @Test
      public void testAmountDepositAndWithDraw() {

            transactions.withdraw(100);
            transactions.deposit(100);
            transactions.deposit(100);
            transactions.withdraw(50);
            transactions.withdraw(50.5F);

            assertEquals(499.5, transactions.getCurrentBalance());
      }
      
     

}
