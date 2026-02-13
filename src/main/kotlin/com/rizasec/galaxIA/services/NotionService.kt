package com.rizasec.galaxIA.services

import com.rizasec.galaxIA.dto.GeneralInfo
import com.rizasec.galaxIA.dto.GeneralInfoPageBlockChildrenNotion
import com.rizasec.galaxIA.integrations.clients.NotionClient
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.BlockChildrenNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.BlockNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.PageNotionResponse
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.UserMeNotionResponse
import org.springframework.stereotype.Service

@Service
class NotionService(
    private val notionClient: NotionClient,
) {
    fun getUserMe(): UserMeNotionResponse = notionClient.getUserMe()

    fun getPageById(id: String): PageNotionResponse = notionClient.getPageById(id)

    fun getBlocksById(id: String): BlockNotionResponse = notionClient.getBlocksById(id)

    fun getBlocksAndChildrenById(id: String): BlockChildrenNotionResponse = notionClient.getBlocksAndChildrenById(id)

    fun getGeneralInfoEpicById(epicId: String): GeneralInfo {
        val pageEpicInfo =
            getPageById(epicId).convertToGeneralInfoPage()

        val pageEpicBlockChildrenInfo =
            getBlocksAndChildrenById(epicId).convertToPageBlockAndChildren(null)

        val storyTitleHash = mutableMapOf<String, String?>()

        pageEpicInfo.storys?.forEach {
            val title = getBlocksById(it.id).childPage?.title
            storyTitleHash[it.id] = title
        }

        val pagesStorysBlockChildrenInfo =
            pageEpicInfo.storys?.subList(3, 5)?.map {
                getBlocksAndChildrenById(it.id).convertToPageBlockAndChildren(storyTitleHash[it.id])
            }

        return GeneralInfo(
            pageEpicInfo = pageEpicInfo,
            blockChildrenEpicInfo = pageEpicBlockChildrenInfo,
            blockChildrenStoryInfo = pagesStorysBlockChildrenInfo,
        )
    }
}
