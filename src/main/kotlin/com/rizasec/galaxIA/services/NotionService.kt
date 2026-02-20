package com.rizasec.galaxIA.services

import com.rizasec.galaxIA.dto.GeneralInfo
import com.rizasec.galaxIA.dto.GeneralInfoPageBlockChildrenNotion
import com.rizasec.galaxIA.dto.ResultBlockItem
import com.rizasec.galaxIA.integrations.clients.NotionClient
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

    fun getBlocksAndChildrenById(id: String): GeneralInfoPageBlockChildrenNotion {
        val title = getBlocksById(id).childPage?.title

        val allBlocksAndChildren = mutableListOf<ResultBlockItem>()
        var nextCursor: String? = null
        var hasMore: Boolean

        do {
            val rawResponse =
                notionClient.getBlocksAndChildrenById(id, startCursor = nextCursor)

            val converted = rawResponse.convertToPageBlockAndChildren(title)
            allBlocksAndChildren.addAll(converted.results)

            nextCursor = rawResponse.nextCursor
            hasMore = rawResponse.hasMore
        } while (hasMore)

        allBlocksAndChildren
            .filter { it.syncedBlock?.syncedFrom != null && it.aboutPage.hasChildren }
            .forEach { block ->
                val blockSyncId = block.syncedBlock!!.syncedFrom!!.blockId
                val syncTitle = getBlocksById(blockSyncId).childPage?.title

                val syncedBlocksChildren =
                    notionClient
                        .getBlocksAndChildrenById(blockSyncId)
                        .convertToPageBlockAndChildren(syncTitle)
                        .results

                block.syncedBlockChildren?.addAll(syncedBlocksChildren)
            }

        return GeneralInfoPageBlockChildrenNotion(
            title = title,
            results = allBlocksAndChildren,
        )
    }

    fun getGeneralInfoEpicById(epicId: String): GeneralInfo {
        val pageEpicInfo =
            getPageById(epicId).convertToGeneralInfoPage()

        val pageEpicBlockChildrenInfo =
            getBlocksAndChildrenById(epicId).results

        val pagesStorysBlockChildrenInfo =
            pageEpicInfo.storys?.flatMap {
                getBlocksAndChildrenById(it.id).results
            }
        return GeneralInfo(
            pageEpicInfo = pageEpicInfo,
            blockChildrenEpicInfo = pageEpicBlockChildrenInfo,
            blockChildrenStoryInfo = pagesStorysBlockChildrenInfo,
        )
    }
}
