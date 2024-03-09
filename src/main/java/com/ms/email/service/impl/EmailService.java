package com.ms.email.service.impl;

import com.ms.email.repository.EmailRepository;
import com.ms.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    @Autowired
    private EmailRepository emailRepository;


}
