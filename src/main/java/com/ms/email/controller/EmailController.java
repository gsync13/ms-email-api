package com.ms.email.controller;

import com.ms.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {

    @Autowired
    private IEmailService emailService;


}
