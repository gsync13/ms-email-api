package com.ms.email.service.impl;

import com.ms.email.dto.EmailDto;
import com.ms.email.enums.EmailStatus;
import com.ms.email.model.Email;
import com.ms.email.repository.EmailRepository;
import com.ms.email.service.IEmailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Override
    @Transactional
    public Email sendEmail(EmailDto emailInput) {
        Email email = new Email();
        email.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailInput.getEmailFrom());
            message.setTo(emailInput.getEmailTo());
            message.setSubject(emailInput.getSubject());
            message.setText(emailInput.getText());
            emailSender.send(message);
            email.setStatusEmail(EmailStatus.SENT.name());
        }catch (MailException e){
            email.setStatusEmail(EmailStatus.ERROR.name());
        }

        BeanUtils.copyProperties(emailInput, email);
        emailRepository.save(email);
        return email;
    }

    @Override
    public Page<Email> getAllEmails(Pageable page) {
        return emailRepository.findAll(page);
    }

}
