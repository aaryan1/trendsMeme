package com.tks.trendsmeme.datalayer.datasource.remote

import com.tks.trendsmeme.domainlayer.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface AppApiService {

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User
}