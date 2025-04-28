package com.nagaraju.whatsthenews.pagination.datasource

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nagaraju.whatsthenews.BuildConfig
import com.nagaraju.whatsthenews.model.Article
import com.nagaraju.whatsthenews.network.interfaces.ApiService
import com.nagaraju.whatsthenews.utils.Constants

class NewsPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize

            val response = apiService.getNewsList("IPL 2025", page, pageSize, Constants.API_KEY)
            Log.d("TAG", "articles: ${response.articles.size}")
            LoadResult.Page(
                data = response.articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.articles.isEmpty()) null else page + 1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}