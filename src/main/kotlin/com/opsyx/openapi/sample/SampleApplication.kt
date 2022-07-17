package com.opsyx.openapi.sample

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class SampleApplication {

    fun main(args: Array<String>) {
        runApplication<SampleApplication>(*args)
    }
}