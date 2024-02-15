package org.example.springeventsample.member.controller

import org.example.springeventsample.member.dto.MemberSignUpRequest
import org.example.springeventsample.member.service.SignUpService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    private val signUpService: SignUpService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/members/sign-up")
    fun signUp(@RequestBody memberSignUpRequest: MemberSignUpRequest) {
        signUpService.signUp(memberSignUpRequest)
        log.info("회원가입 완료: ${memberSignUpRequest.email}")
    }
}
