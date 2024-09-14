package com.tks.trendsmeme.datalayer.repository
import com.tks.trendsmeme.datalayer.dao.UserDao
import com.tks.trendsmeme.datalayer.datasource.remote.AppApiService
import com.tks.trendsmeme.domainlayer.model.User
import com.tks.trendsmeme.domainlayer.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val apiService: AppApiService) : UserRepository  {
    override suspend fun getUser(userId: Int): User {
        return apiService.getUser(userId)
    }


}