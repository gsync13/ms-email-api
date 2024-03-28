package com.ms.email.controller;

import com.ms.email.dto.EmailDto;
import com.ms.email.model.Email;
import com.ms.email.service.IEmailService;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;

    Logger logger = LogManager.getLogger(EmailController.class);


    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDto emailInput){
        Email email = emailService.sendEmail(emailInput);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    @GetMapping ("/emails")
    public ResponseEntity<Page<Email>> getAllEmails(Pageable page){
        logger.trace("TRACE");
        logger.info("INFO");
        return new ResponseEntity<>(emailService.getAllEmails(page), HttpStatus.OK);
    }
}
