package com.rizasec.galaxIA.dto

data class GeneralInfo(
    val pageEpicInfo: GeneralPageInfoNotion,
    val blockChildrenEpicInfo: GeneralInfoPageBlockChildrenNotion,
    val blockChildrenStoryInfo: List<GeneralInfoPageBlockChildrenNotion>?,
)
