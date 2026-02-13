package com.rizasec.galaxIA

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@OpenAPIDefinition(
    info =
        Info(
            title = "galaxIA API",
            version = "v1",
            description = "OpenAPI documentation for galaxIA endpoints.",
        ),
)
@SpringBootApplication
@EnableFeignClients(basePackages = ["com.rizasec.galaxIA.integrations.clients"])
class GalaxIaApplication

fun main(args: Array<String>) {
    runApplication<GalaxIaApplication>(*args)
}
