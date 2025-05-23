package com.nagaraju.whatsthenews

import android.app.Application
import com.nagaraju.whatsthenews.di.modules.repositoryModule
import com.nagaraju.whatsthenews.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                repositoryModule))
        }
    }
}