package com.assignment.tantalum.service;

import java.util.List;
import java.util.Map;

import com.assignment.tantalum.bean.Message;

public interface MessageService {
	Map<Integer,List<Message>> getAllMessages();
	List<Message> getMessagesForANumber(int number);
	String addMessage(int number,Message newMessage);
	boolean updateMessage(int number,Message msg);
	void deleteMessage(int number,Message msg);

}
