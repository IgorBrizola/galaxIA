package com.rizasec.galaxIA.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.rizasec.galaxIA.dto.notion.AboutPage
import com.rizasec.galaxIA.dto.notion.NotionDate
import com.rizasec.galaxIA.dto.notion.RelationRef

data class GeneralPageInfoNotion(
    val id: String,
    val parentId: String?,
    val parentType: String?,
    val name: String?,
    val statusRoadMap: String?,
    val type: String?,
    val backLogTeam: String?,
    val priority: Int?,
    val launchProduction: NotionDate?,
    val realises: List<RelationRef>?,
    val storys: List<RelationRef>?,
    val aboutPage: AboutPage?,
)
