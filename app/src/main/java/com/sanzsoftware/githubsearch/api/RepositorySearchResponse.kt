package com.sanzsoftware.githubsearch.api

import com.google.gson.annotations.SerializedName
import com.sanzsoftware.githubsearch.models.Repository

data class RepositorySearchResponse(
    @SerializedName("total_count")
    val totalCount: Int,
    @SerializedName("incomplete_results")
    val incompleteResults: String,
    val result: List<Repository>
)