package com.rizasec.galaxIA.services

import com.rizasec.galaxIA.integrations.clients.NotionClient
import com.rizasec.galaxIA.integrations.dto.notion.response.BlockChildrenNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.BlockNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.PageNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.UserMeNotionResponse
import org.springframework.stereotype.Service

@Service
class NotionService(
    private val notionClient: NotionClient,
) {
    fun getUserMe(): UserMeNotionResponse = notionClient.getUserMe()

    fun getPageById(id: String): PageNotionResponse = notionClient.getPageById(id)

    fun getBlocksById(id: String): BlockNotionResponse = notionClient.getBlocksById(id)

    fun getBlocksAndChildrenById(id: String): BlockChildrenNotionResponse = notionClient.getBlocksAndChildrenById(id)
}
