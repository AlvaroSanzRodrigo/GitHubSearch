package com.sanzsoftware.githubsearch.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanzsoftware.githubsearch.api.DataRepository
import kotlinx.coroutines.launch

class RepositoryViewModel () : ViewModel() {
    private val dataRepository = DataRepository()
    val repositories = dataRepository.response

    fun getRepositories() { viewModelScope.launch { dataRepository.getRepositories() } }
    fun getRepositoriesNextPage() { viewModelScope.launch { dataRepository.getRepositoriesNextPage() } }
    fun searchRepositories(search: String) { viewModelScope.launch { dataRepository.searchRepositories(search) } }
    fun searchRepositoriesNextPage(search: String) { viewModelScope.launch { dataRepository.searchRepositoriesNextPage(search) } }
}