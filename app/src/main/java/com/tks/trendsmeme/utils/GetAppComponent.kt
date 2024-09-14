package com.tks.trendsmeme.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.tks.trendsmeme.presentation.appComponents.AppComponents
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AppComponentsEntryPoint {
    fun getAppComponents(): AppComponents
}
@Composable
fun GetAppComponents(content: @Composable (AppComponents) -> Unit) {
    val appComponents = EntryPointAccessors.fromApplication(
        LocalContext.current,
        AppComponentsEntryPoint::class.java
    ).getAppComponents()
    content(appComponents)
}