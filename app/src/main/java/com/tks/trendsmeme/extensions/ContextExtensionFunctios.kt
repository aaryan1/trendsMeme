package com.tks.trendsmeme.extensions

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.getAppVersionName(): String = try {
    val pInfo = packageManager.getPackageInfo(packageName, 0)
    pInfo.versionName
} catch (e: Exception) {
    ""
}

fun Context.getAppVersionCode(): Int = try {
    val pInfo = packageManager.getPackageInfo(packageName, 0)
    pInfo.versionCode
} catch (e: PackageManager.NameNotFoundException) {
    // Handle the case where the package name is not found
    0
}