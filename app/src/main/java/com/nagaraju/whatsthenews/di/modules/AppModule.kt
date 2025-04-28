package com.nagaraju.whatsthenews.di.modules


import com.nagaraju.whatsthenews.repository.NewsListRepository
import com.nagaraju.whatsthenews.viewmodel.NewsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NewsListViewModel(get<NewsListRepository>())
    }
}

val repositoryModule = module {
    single {
        NewsListRepository()
    }
}
