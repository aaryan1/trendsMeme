package com.tks.trendsmeme.di

import com.tks.trendsmeme.datalayer.constants.Constants
import com.tks.trendsmeme.datalayer.datasource.remote.AppApiService
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
     @Provides
     @Singleton
     fun provideRetrofit(): Retrofit {
         return Retrofit.Builder().
         baseUrl(Constants.BASE_URL).
         addConverterFactory(GsonConverterFactory
             .create())
             .build()
     }
     @Provides
     @Singleton
     fun provideApiService(retrofit: Retrofit): AppApiService {
         return provideRetrofit().create(AppApiService::class.java)

     }

}