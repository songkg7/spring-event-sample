package org.example.springeventsample.mail.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MailService {
    private val log = LoggerFactory.getLogger(javaClass)

    fun sendMail(email: String) {
        log.info("Send mail to $email")
    }
}
