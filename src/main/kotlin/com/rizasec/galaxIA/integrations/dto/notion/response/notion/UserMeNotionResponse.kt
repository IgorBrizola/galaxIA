package com.rizasec.galaxIA.integrations.dto.notion.response.notion

import com.fasterxml.jackson.annotation.JsonProperty

data class UserMeNotionResponse(
    @field:JsonProperty("object")
    val objectName: String,
    val id: String,
    val name: String,
    @field:JsonProperty("avatar_url")
    val avatarUrl: String?,
    val type: String,
    val bot: Bot,
    @field:JsonProperty("request_id")
    val requestId: String,
)

data class Bot(
    val owner: Owner,
    @field:JsonProperty("workspace_name")
    val workspaceName: String,
    @field:JsonProperty("workspace_id")
    val workspaceId: String,
    @field:JsonProperty("workspace_limits")
    val workspaceLimits: WorkspaceLimits,
)

data class Owner(
    val type: String,
    val workspace: Boolean,
)

data class WorkspaceLimits(
    @field:JsonProperty("max_file_upload_size_in_bytes")
    val maxFileUploadSizeInBytes: Long,
)
