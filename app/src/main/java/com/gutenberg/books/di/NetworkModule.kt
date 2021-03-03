package com.gutenberg.books.di

import android.app.Application
import com.gutenberg.books.data.remote.BookClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    @Provides
    fun providerRetrofitInstance(): BookClient {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create())
            .baseUrl("")
            .build()
        return retrofit.create(BookClient::class.java)
    }



}