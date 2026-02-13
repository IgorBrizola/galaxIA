package com.rizasec.galaxIA.configuration.integrations

import feign.RequestInterceptor
import feign.RequestTemplate
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignClientConfig(
    @param:Value("\${clients.notion.key}")
    private val notionKey: String,
) {
    companion object {
        private const val NOTION_VERSION = "2022-06-28"
    }

    private val logger = LogManager.getLogger(FeignClientConfig::class.java)

    @Bean
    fun requestInterceptor(): RequestInterceptor =
        RequestInterceptor { requestTemplate: RequestTemplate ->
            logger.info("🟣 Request intercepted -> ${requestTemplate.feignTarget().name() ?: "unknown"}")
            if (requestTemplate.feignTarget()?.name() == "NotionClient") {
                requestTemplate.header("Authorization", "Bearer $notionKey")
                requestTemplate.header("Notion-Version", NOTION_VERSION)
            }
        }
}
