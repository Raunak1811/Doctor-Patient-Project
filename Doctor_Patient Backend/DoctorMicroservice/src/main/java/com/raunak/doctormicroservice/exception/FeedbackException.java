package com.raunak.doctormicroservice.exception;

import java.util.Date;

public class FeedbackException {

	private Date date;
	private String message;
	private String text;

	public FeedbackException() {
		super();
	}

	public FeedbackException(Date date, String message, String text) {
		super();
		this.date = date;
		this.message = message;
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
