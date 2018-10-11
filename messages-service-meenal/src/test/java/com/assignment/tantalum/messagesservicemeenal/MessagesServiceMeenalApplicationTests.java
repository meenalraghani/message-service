package com.assignment.tantalum.messagesservicemeenal;

import java.util.Date;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.assignment.tantalum.bean.Message;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessagesServiceMeenalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessagesServiceMeenalApplicationTests {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetAllMessages() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:"+port+"/getMessages",
				HttpMethod.GET, entity, String.class);
		//System.out.println(response.getStatusCodeValue());
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());

	}

	@Test
	public void testGetMessagesForANumber() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange("http://localhost:"+port+"/getMessages/123123123",
				HttpMethod.GET, entity, String.class);

		Assert.assertEquals( HttpStatus.OK.value(),response.getStatusCodeValue());
	}

	@Test
	public void addMessage() throws JSONException {
		Message msg = new Message("New message for 789789789", new Date());
		HttpEntity<Message> entity = new HttpEntity<Message>(msg, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:"+port+"/addMessage/789789789",
				HttpMethod.POST, entity, String.class);

		Assert.assertEquals( HttpStatus.OK.value(),response.getStatusCodeValue());
	}


}
