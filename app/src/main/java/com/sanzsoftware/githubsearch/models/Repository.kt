package com.sanzsoftware.githubsearch.models

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: User,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("description")
    val description: String
)