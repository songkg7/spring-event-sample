package org.example.springeventsample.member.event

import org.example.springeventsample.mail.service.MailService
import org.slf4j.LoggerFactory
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit

@Component
class SignUpEventListener(
    private val mailService: MailService
) {

    private val log = LoggerFactory.getLogger(javaClass)

    @Async
    @EventListener
    fun sendMail(signUpEvent: SignUpEvent) {
        TimeUnit.SECONDS.sleep(3)
        mailService.sendMail(signUpEvent.email)
    }

    @Async
    @EventListener
    fun sendWelcomeMessage(signUpEvent: SignUpEvent) {
        TimeUnit.SECONDS.sleep(3)
        log.info("Send welcome message to ${signUpEvent.email}")
    }

    @Async
    @EventListener
    fun sendPush(signUpEvent: SignUpEvent) {
        TimeUnit.SECONDS.sleep(3)
        log.info("Send push to ${signUpEvent.email}")
    }
}
