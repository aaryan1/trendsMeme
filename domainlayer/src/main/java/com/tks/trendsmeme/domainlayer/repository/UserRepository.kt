package com.tks.trendsmeme.domainlayer.repository

import com.tks.trendsmeme.domainlayer.model.User

interface UserRepository {
    suspend fun getUser(userId: Int): User
}