package com.rizasec.galaxIA.services

import com.rizasec.galaxIA.dto.GeneralInfo
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
        val pageEpicInfoNotion =
            getPageById(epicId).convertToGeneralInfoPage()

        val pageEpicBlockChildrenInfoNotion =
            getBlocksAndChildrenById(epicId).convertToPageBlockAndChildren()

//        val pagesRealisesBlockChildrenInfoNotion =
//            pageEpicInfoNotion.realises?.map {
//                getBlocksAndChildrenById(it.id).convertToPageBlockAndChildren()
//            }

//        val pagesStorysBlockChildrenInfoNotion =
//            pageEpicInfoNotion.storys?.map {
//                getBlocksAndChildrenById(it.id).convertToPageBlockAndChildren()
//            }

        val pagesStorysBlockChildrenInfoNotion =
            pageEpicInfoNotion.storys?.take(2)?.map {
                getBlocksAndChildrenById(it.id).convertToPageBlockAndChildren()
            }

        return GeneralInfo(
            pageEpicInfoNotion,
            pageEpicBlockChildrenInfoNotion,
            pagesStorysBlockChildrenInfoNotion,
        )
    }
}
