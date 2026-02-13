package com.rizasec.galaxIA.dto

import com.rizasec.galaxIA.dto.notion.AboutPage

data class GeneralInfoPageBlockNotion(
    val id: String,
    val title: String,
    val aboutPage: AboutPage,
)
