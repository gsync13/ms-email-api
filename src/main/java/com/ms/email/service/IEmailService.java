package com.ms.email.service;

import com.ms.email.dto.EmailDto;
import com.ms.email.model.Email;

public interface IEmailService {
    Email sendEmail(EmailDto emailInput);
}
