package com.sanzsoftware.githubsearch.models

data class Repository(
    val id: String,
    val name: String,
    val fullName: String,
    val owner: User,
    val htmlUrl: String,
    val description: String,
    val url: String
)