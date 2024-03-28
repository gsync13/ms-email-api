package com.ms.email.service;

import com.ms.email.dto.EmailDto;
import com.ms.email.model.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmailService {
    Email sendEmail(EmailDto emailInput);

    Page<Email> getAllEmails(Pageable page);
}
