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

            if (response.isSuccessful) {
                this.response.value?.clear()
                this.response.postValue(response.body())
            }
        } catch (e: Exception) {
            e.message?.let { Log.e(this.javaClass.simpleName, it) }
        }
    }

    suspend fun searchRepositories(search: String) {
        try {
            val response = Service.getInstance().repositoriesApi().searchRepositories("search/repositories", search)

            if (response.isSuccessful) {
                this.response.value?.clear()
                this.response.postValue(response.body()?.result?.toMutableList())
            }
        } catch (e: Exception) {
            e.message?.let { Log.e(this.javaClass.simpleName, it) }
        }
    }

}