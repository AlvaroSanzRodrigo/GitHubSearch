package com.sanzsoftware.githubsearch

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        start()
    }

    private fun start(){
        supportActionBar?.hide()
        setRecyclerview()
        registerObservers()
        setSearch()
        repositoryViewModel.getRepositories()
        addPagination()
    }

    private fun addPagination(){
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(RecyclerView.VERTICAL)) {
                    if (searchView.query.isNullOrBlank())
                        repositoryViewModel.getRepositoriesNextPage()
                    else
                        repositoryViewModel.searchRepositoriesNextPage(searchView.query.toString())
                }
            }
        })
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

    private fun setSearch(){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { repositoryViewModel.searchRepositories(it) }
                searchView.clearFocus()
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {return false}
        })
    }

    override fun onItemSelected(repository: Repository) {
    }

}