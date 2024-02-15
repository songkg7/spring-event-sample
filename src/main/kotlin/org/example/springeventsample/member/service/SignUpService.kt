package org.example.springeventsample.member.service

import org.example.springeventsample.member.domain.Member
import org.example.springeventsample.member.dto.MemberSignUpRequest
import org.example.springeventsample.member.event.SignUpEvent
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val publisher: ApplicationEventPublisher
) {

    private val log = LoggerFactory.getLogger(javaClass)

    // NOTE: 회원가입 처리 이후 메일 발송, push 알림 등의 비즈니스 로직 의존성 분리를 위해서 이벤트를 발행한다.
    fun signUp(memberSignUpRequest: MemberSignUpRequest) {
        log.info("회원가입 처리")
        val member = Member(1, memberSignUpRequest.email, memberSignUpRequest.password)
        log.info("회원 생성 완료: ${member.id} ${member.email}")

        // NOTE: 회원가입 이벤트 발행
        publisher.publishEvent(SignUpEvent(memberSignUpRequest.email))
    }
}
