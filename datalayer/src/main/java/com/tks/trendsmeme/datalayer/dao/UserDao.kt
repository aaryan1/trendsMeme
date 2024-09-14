package com.tks.trendsmeme.datalayer.dao

import com.tks.trendsmeme.domainlayer.model.User

interface UserDao {
    suspend fun getUser(userId:Int): User
}