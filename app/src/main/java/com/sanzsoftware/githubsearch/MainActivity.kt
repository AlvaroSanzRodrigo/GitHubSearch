package com.sanzsoftware.githubsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sanzsoftware.githubsearch.api.Service
import com.sanzsoftware.githubsearch.models.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var call =  Service.getInstance().repositoriesApi().getRepositories("repositories")
        call.enqueue(
            object: Callback<List<Repository>>{
                override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                    Log.i("HTTP", "ERROR: ${t.localizedMessage} + ${t.message}")
                }

                override fun onResponse(
                    call: Call<List<Repository>>,
                    response: Response<List<Repository>>
                ) {
                    Log.i("HTTP", "SUCCESS -> ${response.code()}")
                    for (repository in response.body()!!)
                        Log.i("HTTP", repository.name)
                }

            }
        )

    }
}