package com.tks.trendsmeme.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.tks.trendsmeme.domainlayer.model.User
import com.tks.trendsmeme.domainlayer.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val getUserUseCase: GetUserUseCase) : ViewModel() {
    suspend fun getUser(userId: Int): User {
        return getUserUseCase.invoke(userId)
    }

}