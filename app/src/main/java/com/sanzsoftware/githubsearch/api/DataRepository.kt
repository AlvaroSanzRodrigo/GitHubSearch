package com.sanzsoftware.githubsearch.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sanzsoftware.githubsearch.models.Repository
import retrofit2.Response

class DataRepository {
    val response = MutableLiveData<MutableList<Repository>>()

    suspend fun getRepositories() {
        try {
            val response = Service.getInstance().repositoriesApi().getRepositories("repositories")
            Log.i(TAG, "$response")

            if (response.isSuccessful) {
                Log.d(TAG, "SUCCESS")
                Log.d(TAG, response.body().toString())
                this.response.postValue(response.body())

            } else {
                Log.d(TAG, "FAILURE")
                Log.d(TAG, response.body().toString())
            }

        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
        }

    }

    companion object {
        val  TAG = "HTTP"
    }
}