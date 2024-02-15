package org.example.springeventsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class SpringEventSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringEventSampleApplication>(*args)
}
