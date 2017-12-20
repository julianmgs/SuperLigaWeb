package com.julian.superliga.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julian.superliga.service.inter.EmailService;
import com.julian.superliga.utils.Constants;
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

	@Override
	public void sendEmailContacto(Mensaje mensaje) throws IOException {
		
		Email from = new Email(mensaje.getEmail());
	    String subject = mensaje.getAsunto();
	    Email to = new Email("julianmgs@gmail.com");
	    Content content = new Content("text/plain", "Hello, Email!");
	    Mail mail = new Mail(from, subject, to, content);

	    SendGrid sg = new SendGrid(Constants.SENDGRID_API_KEY);
	    Request request = new Request();

		request.setMethod(Method.POST);
		request.setEndpoint("mail/send");
		request.setBody(mail.build());
		Response response = sg.api(request);
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
	}
}
