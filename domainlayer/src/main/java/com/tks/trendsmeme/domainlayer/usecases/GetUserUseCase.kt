package com.tks.trendsmeme.domainlayer.usecases

import com.tks.trendsmeme.domainlayer.model.User
import com.tks.trendsmeme.domainlayer.repository.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(userId: Int): User {
        return userRepository.getUser(userId)
    }
}