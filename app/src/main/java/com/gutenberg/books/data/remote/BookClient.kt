package com.gutenberg.books.data.remote

import retrofit2.http.GET

interface BookClient {

    @GET("books")
    fun getBookByCategory()
}