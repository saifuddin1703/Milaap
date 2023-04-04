package com.example.cdgialumini.di

import com.example.cdgialumini.retrofit.services.AuthService
import com.example.cdgialumini.retrofit.Retrofit
import com.example.cdgialumini.retrofit.services.PostService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideAuthService(): AuthService {
        return Retrofit.getInstance().create(AuthService::class.java)
    }

    @Provides
    fun providePostService(): PostService {
        return Retrofit.getInstance().create(PostService::class.java)
    }
}