package com.nagaraju.whatsthenews.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.nagaraju.whatsthenews.BuildConfig
import com.nagaraju.whatsthenews.model.Article
import com.nagaraju.whatsthenews.model.NewsResponseModel
import com.nagaraju.whatsthenews.network.RetrofitClient
import com.nagaraju.whatsthenews.network.interfaces.ApiService
import com.nagaraju.whatsthenews.pagination.datasource.NewsPagingSource
import com.nagaraju.whatsthenews.utils.Constants

/*interface NewsListRepositoryInterface {
    suspend fun fetchNewsList(): Pager<Int, Article>
}*/

class NewsListRepository  {

    private val apiService = RetrofitClient.apiService
    fun fetchNewsList(): Pager<Int, Article> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { NewsPagingSource(apiService) }
        )
    }

}