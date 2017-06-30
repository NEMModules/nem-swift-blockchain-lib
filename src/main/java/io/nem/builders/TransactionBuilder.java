package io.nem.builders;

import org.nem.core.model.Account;
import org.nem.core.model.Transaction;
import org.nem.core.model.TransferTransactionAttachment;

import io.nem.model.TransactionBlock;
import io.nem.service.Globals;
import io.nem.service.TransactionService;

public class TransactionBuilder {

	private TransactionBlock tBlock = new TransactionBlock();
	private static TransactionBuilder instance;

	public static TransactionBuilder getInstance() {
		if (instance == null) {
			
			return new TransactionBuilder();
		}
		return instance;
	}

	public TransactionBuilder setSender(Account sender) {
		this.tBlock.setSender(sender);
		return this;
	}

	public TransactionBuilder setRecipient(Account recipient) {
		this.tBlock.setRecipient(recipient);
		return this;
	}

	public TransactionBuilder setAmount(Long amount) {
		this.tBlock.setAmount(amount);
		return this;
	}

	public TransactionBuilder setAttachment(TransferTransactionAttachment attachment) {
		this.tBlock.setAttachment(attachment);
		return this;
	}

	public Transaction buildTransaction() {
		if(this.tBlock.getTimeInstant() == null) {
			this.tBlock.setTimeInstant(Globals.TIME_PROVIDER.getCurrentTime());
		}
		return TransactionService.createTransaction(this.tBlock.getTimeInstant(), this.tBlock.getSender(),
				this.tBlock.getRecipient(), this.tBlock.getAmount(), this.tBlock.getAttachment());
	}

	public void buildAndSendTransaction() {
		if(this.tBlock.getTimeInstant() == null) {
			this.tBlock.setTimeInstant(Globals.TIME_PROVIDER.getCurrentTime());
		}
		TransactionService.createAndSendTransaction(this.tBlock.getSender(), this.tBlock.getRecipient(),
				this.tBlock.getAmount(), this.tBlock.getAttachment());
	}
}