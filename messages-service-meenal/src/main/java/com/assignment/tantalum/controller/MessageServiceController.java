package com.assignment.tantalum.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.tantalum.bean.Message;
import com.assignment.tantalum.service.MessageService;

@RestController
public class MessageServiceController {
	

	@Autowired
	private MessageService messageService;
	
    @RequestMapping(value = "/getMessages/{number}", method = RequestMethod.GET)
    public List<Message> getMessagesForANumber(@PathVariable int number) {
        System.out.println("Getting messages for " + number);
        return messageService.getMessagesForANumber(number);
    }
    
    @RequestMapping(value = "/getMessages", method = RequestMethod.GET)
    public Map<Integer,List<Message>> getAllMessages() {
        System.out.println("Getting all messages");
        return messageService.getAllMessages();
    }
    
    @RequestMapping(value = "/addMessage/{number}", method = RequestMethod.POST)
	public  String addMessage(@RequestBody Message message,@PathVariable int number) {
		return messageService.addMessage(number, message);
	}
	
    @RequestMapping(value = "/updateMessage/{number}", method = RequestMethod.PUT)
	public boolean updateBook(@RequestBody Message message,@PathVariable int number) {
		return messageService.updateMessage(number,message);
	}
	
    @RequestMapping(value = "/deleteMessage/{number}", method = RequestMethod.DELETE)
	public void deleteBook(@RequestBody Message message,@PathVariable int number) {
		messageService.deleteMessage(number,message);
	}
}
