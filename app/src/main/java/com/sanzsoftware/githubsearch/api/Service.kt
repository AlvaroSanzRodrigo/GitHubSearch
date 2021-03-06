package com.sanzsoftware.githubsearch.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun repositoriesApi(): RepositoriesApi = getRetrofit().create(RepositoriesApi::class.java)

    companion object{

        @Volatile private var instance: Service? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Service().also {
                    instance = it
                }
            }

    }
}