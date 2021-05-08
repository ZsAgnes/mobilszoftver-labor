package com.example.news.ui.news.newscontent.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.news.ui.news.newscontent.model.UiArticle

object ArticleComparator : DiffUtil.ItemCallback<UiArticle>() {

    override fun areItemsTheSame(oldItem: UiArticle, newItem: UiArticle): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiArticle, newItem: UiArticle): Boolean {
        return oldItem == newItem
    }

}