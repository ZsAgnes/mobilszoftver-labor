package com.example.news.ui.news.newscontent.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news.R
import com.example.news.ui.news.newscontent.model.UiArticle
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.fragment_news_list_item.view.*
import timber.log.Timber

class NewsAdapter :
    ListAdapter<UiArticle, NewsAdapter.ViewHolder>(ArticleComparator) {

    var listener: Listener? = null

    interface Listener {
        fun onItemSelected(article: UiArticle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.fragment_news_list_item,
                parent,
                false
            )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.item = item
        holder.title.text = item.title
        holder.date.text = item.publishedAt

        Glide
            .with(holder.image)
            .load(item.urlToImage)
            .placeholder(R.drawable.news_placeholder)
            .into(holder.image)

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: MaterialTextView = itemView.title
        val image: ImageView = itemView.newsImage
        val date: MaterialTextView = itemView.date
        var item: UiArticle? = null

        init {
            itemView.setOnClickListener {
                item.let {
                    it?.let { item ->
                        listener?.onItemSelected(item)
                    }
                }
                Timber.d("Adapter itemSelected")
            }
        }
    }
}