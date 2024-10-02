package com.digitalSupport.seasonalInformation.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class EmailService {
    public boolean sendEmail(Set<String> toEmails, Set<String> ccEmails, String subject, String body) {
        return true;
    }
}