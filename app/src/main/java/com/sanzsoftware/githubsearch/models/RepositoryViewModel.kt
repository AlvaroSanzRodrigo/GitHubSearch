package com.sanzsoftware.githubsearch.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanzsoftware.githubsearch.api.DataRepository
import com.sanzsoftware.githubsearch.api.RepositorySearchResponse
import com.sanzsoftware.githubsearch.api.Service
import kotlinx.coroutines.launch

class RepositoryViewModel () : ViewModel() {
    private val dataRepository = DataRepository()
    val repositories = dataRepository.response

    fun getRepositories() { viewModelScope.launch { dataRepository.getRepositories() } }
}