package com.tks.trendsmeme.di

import com.tks.trendsmeme.datalayer.constants.Constants
import com.tks.trendsmeme.datalayer.datasource.remote.AppApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
 object NetworkModule {
     @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {

         val loggingInterceptor = HttpLoggingInterceptor().apply {
             // later on the if(BuildConfig.DEBUG) condition will be applied
             //level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
             level = HttpLoggingInterceptor.Level.BODY
         }

        return OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS).addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(newRequest)
            }.addInterceptor(loggingInterceptor)
            .build()
    }

     @Provides
     @Singleton
     fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
         return Retrofit.Builder().
         baseUrl(Constants.BASE_URL).
         addConverterFactory(GsonConverterFactory
             .create()).client(okHttpClient)
             .build()
     }
     @Provides
     @Singleton
     fun provideApiService(retrofit: Retrofit): AppApiService {
         return retrofit.create(AppApiService::class.java)

     }

}