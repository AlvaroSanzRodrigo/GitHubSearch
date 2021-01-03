package com.sanzsoftware.githubsearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanzsoftware.githubsearch.adapters.RepositoryAdapter
import com.sanzsoftware.githubsearch.models.Repository
import com.sanzsoftware.githubsearch.models.RepositoryViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RepositoryAdapter.OnClickedItemListener {
    private lateinit var repositoryViewModel: RepositoryViewModel
    private var items: ArrayList<Repository> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        setRecyclerview()
        registerObservers()
        repositoryViewModel.getRepositories()
        // repositoryViewModel.searchRepositories("tetris")
    }

    private fun registerObservers(){
        repositoryViewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)

        repositoryViewModel.repositories.observe(this, Observer {
            items.clear()
            items.addAll(it)
            recyclerView.adapter?.notifyDataSetChanged()
        })
    }

    private fun setRecyclerview(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RepositoryAdapter(items)
    }

    override fun onItemSelected(repository: Repository) {
    }

}