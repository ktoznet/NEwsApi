package com.example.newsapi.presentor.presenot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import com.example.films.view.adapters.HeroAdapter
import com.example.heroretrofit.model.api.ApiInterface
import com.example.heroretrofit.model.data.News
import com.example.newsapi.databinding.ActivityMainBinding
import com.example.newsapi.presentor.apikey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class MainActivity : AppCompatActivity(){
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(3000)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DotaHeroy()
        val recyclerview = binding.recyclerview

        recyclerview.layoutManager = GridLayoutManager(this,1)
    }
    private fun DotaHeroy(){


        val apiInterface = ApiInterface.create().getMovies(apikey)
        apiInterface.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>?, response: Response<News>?) {
                Log.d("testLogs","OnResponse Success ${response?.body()}")
                // This will pass the ArrayList to our Adapter
                val adapter = HeroAdapter(response?.body()?.articles)
                binding.recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<News>?, t: Throwable?) {
                Log.d("testLogs","onFailure  ${t?.message}")
            }
        })


    }


}