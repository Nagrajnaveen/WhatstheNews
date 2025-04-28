package com.nagaraju.whatsthenews.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nagaraju.whatsthenews.databinding.NewsListItemBinding
import com.nagaraju.whatsthenews.model.Article

class NewsListAdapter: PagingDataAdapter<Article, NewsListAdapter.NewsViewHolder>(ArticleDiffCallback()) {
    override fun onBindViewHolder(holder: NewsListAdapter.NewsViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListAdapter.NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = NewsListItemBinding.inflate(layoutInflater, parent, false)
        return NewsViewHolder(binding)
    }

    class NewsViewHolder(private val binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article?) {
            article?.let {
                Glide.with(binding.root)
                    .load(it.urlToImage)
                    .into(binding.newsImage)
            }
            binding.item = article
            binding.executePendingBindings()
        }
    }

    class ArticleDiffCallback : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article) = oldItem.url == newItem.url
        override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem == newItem
    }
}