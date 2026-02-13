package com.rizasec.galaxIA.services

import com.rizasec.galaxIA.integrations.clients.NotionClient
import com.rizasec.galaxIA.integrations.dto.notion.response.UserMeNotionResponse
import org.springframework.stereotype.Service

@Service
class NotionService(
    private val notionClient: NotionClient,
) {
    fun getUserMe(): UserMeNotionResponse = notionClient.getUserMe()
}
