package com.tks.trendsmeme.di

import android.content.Context
import android.content.SharedPreferences
import com.tks.trendsmeme.datalayer.repository.UserRepositoryImpl
import com.tks.trendsmeme.domainlayer.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{
  @Singleton
  @Provides
  fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
      return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
  }

    @Provides
    fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository {
        return userRepositoryImpl
    }
}