package com.kata.demo.account.transaction;

import java.time.Instant;
import java.util.Date;

/**
 * A single Transaction with details or operations i.e. date of transaction, transactionType, balance
 *
 */
public class Transaction {

      // date-time when this transaction happened
      private final Instant instant;
      
      private final String description;
      
      private final TransactionType transactionType;
      
      // total balance after the current transaction
      private final double balance;

      public Transaction(TransactionType transactionType, double balance) {
            this(transactionType, balance, "");
      }

      public Transaction(TransactionType transactionType, double balance, String description) {
            super();
            this.instant = Instant.now();
            this.transactionType = transactionType;
            this.balance = balance;
            this.description = description;
      }

      public Date getTransactionDate() {
            return Date.from(instant);
      }

      public TransactionType getTransactionType() {
            return transactionType;
      }

      public double getBalance() {
            return balance;
      }

      public String getDescription() {
            return description;
      }

      @Override
      public int hashCode() {
            final int prime = 31;
            int result = 1;
            long temp;
            temp = Double.doubleToLongBits(balance);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            result = prime * result + ((instant == null) ? 0 : instant.hashCode());
            result = prime * result + ((description == null) ? 0 : description.hashCode());
            result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
            return result;
      }

      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (obj == null)
                  return false;
            if (getClass() != obj.getClass())
                  return false;
            Transaction other = (Transaction) obj;
            if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
                  return false;
            if (instant == null) {
                  if (other.instant != null)
                        return false;
            } else if (!instant.equals(other.instant))
                  return false;
            if (description == null) {
                  if (other.description != null)
                        return false;
            } else if (!description.equals(other.description))
                  return false;
            if (transactionType != other.transactionType)
                  return false;
            return true;
      }

      @Override
      public String toString() {
            return "Transaction [date=" + this.getTransactionDate() + ", description=" + description + ", transactionType=" + transactionType.toString() + ", balance="
                        + balance + "]";
      }

      
}
