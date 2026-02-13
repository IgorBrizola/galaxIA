package com.rizasec.galaxIA

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients(basePackages = ["com.rizasec.galaxIA.integrations.clients"])
class GalaxIaApplication

fun main(args: Array<String>) {
    runApplication<GalaxIaApplication>(*args)
}
