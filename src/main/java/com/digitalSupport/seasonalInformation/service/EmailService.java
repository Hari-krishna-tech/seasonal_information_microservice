package com.digitalSupport.seasonalInformation.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
public class EmailService {
    @Value("${spring.sendgrid.api-key}")
    private String sendGridApiKey;
    public boolean sendEmail(Set<String> toEmails, Set<String> ccEmails, String subject, String body) throws IOException {

        Mail mail = new Mail();

        Email fromEmail = new Email("harikrishna.t@olamnet.com");
        mail.setFrom(fromEmail);

        mail.setSubject(subject);

        Personalization personalization = new Personalization();

        // add multiple "To" recipients
        for(String toEmail : toEmails) {
            personalization.addTo(new Email(toEmail));
        }

        // Add "CC" recipients if provided

        if(ccEmails != null) {
            for(String ccEmail: ccEmails) {
                personalization.addCc(new Email(ccEmail));
            }
        }

        mail.addPersonalization(personalization);

        // adding body
        Content content = new Content("text/plain", body);
        mail.addContent(content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());

        Response response = sg.api(request);



        return response.getStatusCode() == 202;
    }
}