package com.assignment.tantalum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.assignment.tantalum.bean.Message;
import com.assignment.tantalum.service.MessageService;

@Service
public class MessageServiceImplementation implements MessageService{
	
	private static Map<Integer, List<Message>> messageDB = new HashMap<Integer, List<Message>>();
	 
    static {

        messageDB = new HashMap<Integer, List<Message>>();
 
        List<Message> lst = new ArrayList<Message>();
        Message msg = new Message( "First Message for 123123123", new Date());
        lst.add(msg);
        msg = new Message("Second Message for 123123123",new Date());
        lst.add(msg);
 
        messageDB.put(123123123, lst);
 
        lst = new ArrayList<Message>();
        msg = new Message("First Message for 456456456",new Date());
        lst.add(msg);
        msg = new Message("Second Message for 456456456",new Date());
        lst.add(msg);
        msg = new Message("Third Message for 456456456",new Date());
        lst.add(msg);
        messageDB.put(456456456, lst);
        
        lst = new ArrayList<Message>();
        msg = new Message("First Message for 789789789",new Date());
        lst.add(msg);
        msg = new Message("Second Message for 789789789",new Date());
        lst.add(msg);
 
        messageDB.put(789789789, lst);  
        
 
    }
    
    

	@Override
	public Map<Integer, List<Message>> getAllMessages() {
		  return messageDB;
	}

	@Override
	public List<Message> getMessagesForANumber(int number) {

        List<Message> messages = messageDB.get(number);
        if (messages == null) {
            messages = new ArrayList<Message>();
            Message std = new Message("No Messages Found",null);
            messages.add(std);
        }
        return messages;
	}

	@Override
	public String addMessage(int number,Message newMessage) {
		messageDB.put(number, Arrays.asList(newMessage));
		return "Added successfully!";
	}

	@Override
	public boolean updateMessage(int number,Message msg) {
		boolean result = false;
		List<Message> oldmsg = messageDB.get(number);
		Date oldmsgDate = oldmsg.get(number).getMessageDate();
		if(msg.getMessageDate().getTime() - oldmsgDate.getTime() < 10*1000 ) {
			messageDB.put(number,Arrays.asList(msg));
			result=true;
		}
		
		return result;
	}

	@Override
	public void deleteMessage(int number, Message msg) {
		Date msgDate = msg.getMessageDate();
		if(new Date().getTime() - msgDate.getTime() >  2*60*1000 ) {
			messageDB.get(number).remove(msg.getMessageID());
		}
		
	}

}
