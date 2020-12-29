package com.sanzsoftware.githubsearch.api

import retrofit2.Call
import retrofit2.http.Query
import retrofit2.http.Url

interface RepositoriesApi {
    fun getRepositories(@Url url:String, @Query("q") search: String?): Call<RepositoryResponse>
}