package com.banking.service;
import com.banking.entity.BankTransfer;
import com.banking.entity.Transaction;

public interface TransactionService {

	void IMPSTransfer(BankTransfer bankTransfer);
}
