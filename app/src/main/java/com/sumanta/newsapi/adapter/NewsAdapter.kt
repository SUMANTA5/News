package com.sumanta.newsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.sumanta.newsapi.R
import com.sumanta.newsapi.data.Article
import kotlinx.android.synthetic.main.view_holder_layout.view.*

class NewsAdapter(var newsData: List<Article>):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val newsImage = view.news_image
        val newsText = view.news_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_layout, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.newsText.text = newsData[position].title
        Picasso.get().load(newsData[position].urlToImage).into(holder.newsImage)
    }
}