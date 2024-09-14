package com.tks.trendsmeme.application

import android.app.Application
import dagger.Module
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TrendsMemeApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}