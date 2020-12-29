package com.sanzsoftware.githubsearch.api

import com.sanzsoftware.githubsearch.models.Repository

data class RepositoryResponse(
    val totalCount: Int,
    val incompleteResults: String,
    val result: List<Repository>
)