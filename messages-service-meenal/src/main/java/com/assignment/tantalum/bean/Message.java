package com.assignment.tantalum.bean;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Message {
	private int messageID;
    private String message;
    private Date messageDate;
    private static final AtomicInteger count = new AtomicInteger(0); 
    

	public Message( String message, Date messageDate) {
		super();
		this.setMessageID(count.getAndIncrement());
		this.message = message;
		this.messageDate = messageDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
    

}
