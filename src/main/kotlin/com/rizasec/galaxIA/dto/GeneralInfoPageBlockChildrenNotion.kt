package com.rizasec.galaxIA.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.BulletedListItemBlock
import com.rizasec.galaxIA.dto.notion.HeadingBlock
import com.rizasec.galaxIA.dto.notion.NumberedListItemBlock
import com.rizasec.galaxIA.dto.notion.ParagraphBlock
import com.rizasec.galaxIA.dto.notion.SyncedBlock
import com.rizasec.galaxIA.dto.notion.ToDoBlock
import com.rizasec.galaxIA.dto.notion.ToggleBlock
import com.rizasec.galaxIA.integrations.dto.notion.response.notion.CodeBlock

@JsonIgnoreProperties(ignoreUnknown = true)
data class GeneralInfoPageBlockChildrenNotion(
    val title: String?,
    val results: List<ResultBlockItem>,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ResultBlockItem(
    val objectName: String,
    val id: String,
    val parentType: String,
    val parentId: String?,
    val heading1: HeadingBlock? = null,
    val heading2: HeadingBlock? = null,
    val heading3: HeadingBlock? = null,
    val paragraph: ParagraphBlock? = null,
    val numberedListItem: NumberedListItemBlock? = null,
    val bulletedListItem: BulletedListItemBlock? = null,
    val toDo: ToDoBlock? = null,
    val toggle: ToggleBlock? = null,
    val syncedBlock: SyncedBlock? = null,
    val syncedBlockChildren: MutableList<ResultBlockItem>? = null,
    val codeBlock: CodeBlock?,
    val aboutPage: AboutPage,
)
