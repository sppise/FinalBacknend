package com.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "bank_transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "trx_id_seq")
	private int transid;

	@Column(length = 10)
	private double balance;

	@Column(length = 10)
	private long transWith;

	@ManyToOne
	@JoinColumn(name = "acc_no")
	private Account account;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tx_date")
	private Date date;
	
	private double amount;
	
	private String type;
	

	public Transaction() {
		super();
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public long getTransWith() {
		return transWith;
	}

	public void setTransWith(long transWith) {
		this.transWith = transWith;
	}



/*	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date= date;
	}
	*/
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount= amount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	
}
