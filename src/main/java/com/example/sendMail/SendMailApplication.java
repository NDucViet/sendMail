package com.example.sendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.sendMail.Model.EmailSenderService;

@SpringBootApplication
public class SendMailApplication {

	@Autowired
	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(SendMailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		senderService.sendMail("vietnguyen4002@gmail.com", "Code Login for you", "123456");
	}
}
