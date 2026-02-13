package com.rizasec.galaxIA.integrations.clients

import com.rizasec.galaxIA.configuration.integrations.FeignClientConfig
import com.rizasec.galaxIA.integrations.dto.notion.response.UserMeNotionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(
    name = "NotionClient",
    configuration = [FeignClientConfig::class],
)
interface NotionClient {
    @GetMapping("/v1/users/me")
    fun getUserMe(): UserMeNotionResponse
}
