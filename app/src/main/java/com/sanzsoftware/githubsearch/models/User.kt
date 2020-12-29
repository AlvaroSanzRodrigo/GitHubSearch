package com.sanzsoftware.githubsearch.models

data class User(
    val login: String,
    val id: String,
    val nodeId: String,
    val avatarUrl: String,
    val url: String
)