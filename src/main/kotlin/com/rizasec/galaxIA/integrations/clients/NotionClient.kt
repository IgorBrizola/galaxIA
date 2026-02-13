package com.rizasec.galaxIA.integrations.clients

import com.rizasec.galaxIA.configuration.integrations.FeignClientConfig
import com.rizasec.galaxIA.integrations.dto.notion.response.BlockChildrenNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.BlockNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.PageNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.UserMeNotionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "NotionClient",
    configuration = [FeignClientConfig::class],
)
interface NotionClient {
    @GetMapping("/v1/users/me")
    fun getUserMe(): UserMeNotionResponse

    @GetMapping("/v1/pages/{id}")
    fun getPageById(
        @PathVariable id: String,
    ): PageNotionResponse

    @GetMapping("/v1/blocks/{id}")
    fun getBlocksById(
        @PathVariable id: String,
    ): BlockNotionResponse

    @GetMapping("/v1/blocks/{id}/children")
    fun getBlocksAndChildrenById(
        @PathVariable id: String,
    ): BlockChildrenNotionResponse
}
