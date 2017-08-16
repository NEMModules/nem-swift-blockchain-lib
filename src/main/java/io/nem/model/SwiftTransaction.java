package io.nem.model;

import java.io.Serializable;

import org.nem.core.crypto.Signature;
import org.nem.core.model.Account;
import org.nem.core.model.TransferTransactionAttachment;
import org.nem.core.model.primitive.Amount;
import org.nem.core.time.TimeInstant;

public class SwiftTransaction implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The sender. */
	private Account sender;

	/** The recipient. */
	private Account recipient;
	
	private Amount fee;
	
	private Signature signature;
	
	private TimeInstant deadline;

	public Amount getFee() {
		return fee;
	}

	public void setFee(Amount fee) {
		this.fee = fee;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	public TimeInstant getDeadline() {
		return deadline;
	}

	public void setDeadline(TimeInstant deadline) {
		this.deadline = deadline;
	}

	/**
	 * Gets the mulit sig.
	 *
	 * @return the mulit sig
	 */
	public Account getMultisigAccount() {
		return mulitSig;
	}

	/**
	 * Sets the mulit sig.
	 *
	 * @param mulitSig
	 *            the new mulit sig
	 */
	public void setMultisigAccount(Account mulitSig) {
		this.mulitSig = mulitSig;
	}

	/** The mulit sig. */
	private Account mulitSig;

	/** The amount. */
	private Long amount = 0l;

	/** The attachment. */
	private TransferTransactionAttachment attachment;

	/** The payload. */
	private String payload;

	/** The transaction message type. */
	private TransactionMessageType transactionMessageType;

	/** The time instant. */
	private TimeInstant timeInstant;

	/**
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public Account getSenderAccount() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender
	 *            the new sender
	 */
	public void setSenderAccount(Account sender) {
		this.sender = sender;
	}

	/**
	 * Gets the recipient.
	 *
	 * @return the recipient
	 */
	public Account getRecipientAccount() {
		return recipient;
	}

	/**
	 * Sets the recipient.
	 *
	 * @param recipient
	 *            the new recipient
	 */
	public void setRecipientAccount(Account recipient) {
		this.recipient = recipient;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount
	 *            the new amount
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * Gets the attachment.
	 *
	 * @return the attachment
	 */
	public TransferTransactionAttachment getAttachment() {
		return attachment;
	}

	/**
	 * Sets the attachment.
	 *
	 * @param attachment
	 *            the new attachment
	 */
	public void setAttachment(TransferTransactionAttachment attachment) {
		this.attachment = attachment;
	}

	/**
	 * Gets the time instant.
	 *
	 * @return the time instant
	 */
	public TimeInstant getTimeInstant() {
		return timeInstant;
	}

	/**
	 * Gets the payload.
	 *
	 * @return the payload
	 */
	public String getPayload() {
		return payload;
	}

	/**
	 * Sets the payload.
	 *
	 * @param payload
	 *            the new payload
	 */
	public void setPayload(String payload) {
		this.payload = payload;
	}

	/**
	 * Sets the time instant.
	 *
	 * @param timeInstant
	 *            the new time instant
	 */
	public void setTimeInstant(TimeInstant timeInstant) {
		this.timeInstant = timeInstant;
	}

	/**
	 * Gets the transaction message type.
	 *
	 * @return the transaction message type
	 */
	public TransactionMessageType getTransactionMessageType() {
		return transactionMessageType;
	}

	/**
	 * Sets the transaction message type.
	 *
	 * @param transactionMessageType
	 *            the new transaction message type
	 */
	public void setTransactionMessageType(TransactionMessageType transactionMessageType) {
		this.transactionMessageType = transactionMessageType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SwiftTransaction other = (SwiftTransaction) obj;

		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;

		if (sender == null) {
			if (other.sender != null)
				return false;
		} else if (!sender.equals(other.sender))
			return false;

		if (timeInstant == null) {
			if (other.timeInstant != null)
				return false;
		} else if (!timeInstant.equals(other.timeInstant))
			return false;

		if (attachment == null) {
			if (other.attachment != null)
				return false;
		} else if (!attachment.equals(other.attachment))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionBlock [sender=" + sender + ", recipient=" + recipient + ", amount=" + amount
				+ ", attachment=" + attachment.toString() + ", timeInstant=" + timeInstant + "]";
	}

}
