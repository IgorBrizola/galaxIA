package com.rizasec.galaxIA.dto

data class GeneralInfo(
    val pageEpicInfo: GeneralPageInfoNotion,
    val blockChildrenEpicInfo: List<ResultBlockItem>,
    val blockChildrenStoryInfo: List<ResultBlockItem>?,
)
