package com.ms.email.controller;

import com.ms.email.dto.EmailDto;
import com.ms.email.model.Email;
import com.ms.email.service.IEmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;


    @PostMapping("/sending-email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDto emailInput){
        Email email = emailService.sendEmail(emailInput);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
