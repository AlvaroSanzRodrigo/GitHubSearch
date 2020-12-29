package com.sanzsoftware.githubsearch.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/search/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

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