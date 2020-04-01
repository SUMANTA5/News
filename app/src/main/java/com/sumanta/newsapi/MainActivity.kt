package com.sumanta.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sumanta.newsapi.adapter.NewsAdapter
import com.sumanta.newsapi.api.NewsApiService
import com.sumanta.newsapi.data.Article
import com.sumanta.newsapi.data.NewsArticles
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , Callback<NewsArticles> {


    val data = ArrayList<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsData = NewsApiService.create()
        newsData.getTopHighlights().enqueue(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NewsAdapter(data)



    }

    override fun onFailure(call: Call<NewsArticles>, t: Throwable) {

    }

    override fun onResponse(call: Call<NewsArticles>, response: Response<NewsArticles>) {
        val newsArticles = response.body()
        if (newsArticles != null) {
            data.clear()
            data.addAll(newsArticles.articles)
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

}
