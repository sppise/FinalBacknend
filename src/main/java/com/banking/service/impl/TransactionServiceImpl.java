package com.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.entity.Account;
import com.banking.entity.BankTransfer;
import com.banking.entity.Transaction;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;
import com.banking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	@Transactional
	public void IMPSTransfer(BankTransfer bankTransfer) {
		System.out.println("hello");
		Account ac1 = accountRepository.findById(bankTransfer.getFromacc());
		Account ac2 = accountRepository.findById(bankTransfer.getToacc());

		if (ac1.getBalance() >= bankTransfer.getAmount()) {
			Transaction tx1 = new Transaction();
			tx1.setAmount(bankTransfer.getAmount());
			tx1.setAccount(ac1);
			tx1.setType("MONEYTRANSFER");

			Transaction tx2 = new Transaction();
			tx2.setAmount(bankTransfer.getAmount());
			tx2.setAccount(ac2);
			tx2.setType("MONEYRECEIVED");

			ac1.setBalance(ac1.getBalance() - bankTransfer.getAmount());
			ac2.setBalance(ac2.getBalance() + bankTransfer.getAmount());

			accountRepository.save(ac1);
			accountRepository.save(ac2);

			transactionRepository.save(tx1);
			transactionRepository.save(tx2);
		}
	}
}
