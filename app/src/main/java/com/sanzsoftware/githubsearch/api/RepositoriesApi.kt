package com.sanzsoftware.githubsearch.api

import com.sanzsoftware.githubsearch.models.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface RepositoriesApi {
    @GET
    fun searchRepositories(@Url url:String, @Query("q") search: String?): Call<RepositorySearchResponse>

    @GET
    fun getRepositories(@Url url:String): Call<List<Repository>>
}