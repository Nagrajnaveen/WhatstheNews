package com.nagaraju.whatsthenews.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nagaraju.whatsthenews.repository.NewsListRepository

class NewsListViewModel(repositoryInterface: NewsListRepository) : ViewModel() {

   /* private val _newsResponse = MutableLiveData<NewsResponseModel>()
    val newsResponse: MutableLiveData<NewsResponseModel> get() = _newsResponse

    private val _newsList = MutableLiveData<PagingData<Article>>()
    val newsList: LiveData<PagingData<Article>> get() = _newsList*/

    val newsFlow = repositoryInterface.fetchNewsList()
        .flow
        .cachedIn(viewModelScope)


}