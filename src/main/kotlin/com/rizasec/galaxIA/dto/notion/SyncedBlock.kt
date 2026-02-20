package com.rizasec.galaxIA.dto.notion

import com.fasterxml.jackson.annotation.JsonProperty

data class SyncedBlock(
    @field:JsonProperty("synced_from")
    val syncedFrom: SyncedFrom? = null,
)

data class SyncedFrom(
    val type: String,
    @field:JsonProperty(value = "block_id")
    val blockId: String,
)
