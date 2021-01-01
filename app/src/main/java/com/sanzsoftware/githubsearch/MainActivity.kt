package com.sanzsoftware.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sanzsoftware.githubsearch.api.Service
import com.sanzsoftware.githubsearch.models.Repository
import com.sanzsoftware.githubsearch.models.RepositoryViewModel
import kotlinx.coroutines.GlobalScope
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var repositoryViewModel: RepositoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repositoryViewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)

        repositoryViewModel.repositories.observe(this, Observer {
            for (repository in it)
                Log.i("MVVM", repository.name)
        })
        //repositoryViewModel.getRepositories()
        repositoryViewModel.searchRepositories("tetris")


    }
}