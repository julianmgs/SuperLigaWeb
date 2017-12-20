package com.julian.superliga.service.impl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.service.inter.EmailService;
import com.julian.superliga.vo.Mensaje;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Service("emailService")
@Transactional
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = Logger.getLogger(EmailService.class);
	
	@Override
	public void sendEmailContacto(Mensaje mensaje) {
		
		Email from = new Email(mensaje.getEmail());
	    String subject = mensaje.getAsunto();
	    Email to = new Email("julianmgs@gmail.com");
	    Content content = new Content("text/plain", mensaje.getMensaje());
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
	    Request request = new Request();
	    
	    try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			
			Response response = sg.api(request);
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody());
			System.out.println(response.getHeaders());
		
	    } catch (IOException e) {
			logger.error("Error al enviar email", e);
			e.printStackTrace();
		}
	}
}
