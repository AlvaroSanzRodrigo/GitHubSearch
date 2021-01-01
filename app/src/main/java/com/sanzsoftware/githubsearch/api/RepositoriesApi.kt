package com.sanzsoftware.githubsearch.api

import com.sanzsoftware.githubsearch.models.Repository
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface RepositoriesApi {
    @GET
    suspend fun searchRepositories(@Url url:String, @Query("q") search: String?): Response<RepositorySearchResponse>

    @GET
    suspend fun getRepositories(@Url url:String): Response<MutableList<Repository>>
}