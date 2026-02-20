package com.rizasec.galaxIA.integrations.clients

import com.rizasec.galaxIA.configuration.integrations.FeignClientConfig
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.BlockChildrenNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.BlockNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.PageNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.UserMeNotionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam

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
        @RequestParam("start_cursor", required = false) startCursor: String? = null,
        @RequestParam("page_size", required = false) pageSize: Int = 100,
    ): BlockChildrenNotionResponse
}
