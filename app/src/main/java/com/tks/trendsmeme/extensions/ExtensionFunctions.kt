package com.tks.trendsmeme.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.Date

fun NavHostController.navigate(route: String, data: Any? = null) {
    if (data != null) {
        // If data is not null, convert it to a string and append it to the route
        // You might need to handle different data types here
        this.navigate("$route/${data.toString()}")
    } else {
        // If data is null, just navigate to the route
        this.navigate(route)
    }
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this ,duration).show()
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


/** Given 2024-07-11T02:48:00Z, return Friday, 11 July 2024, 02:48 AM */
@SuppressLint("SimpleDateFormat")
fun String.toHumanReadableDateTIme(): String = try {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    val date = formatter.parse(this)
    val humanReadableDate = SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm a").format(date as Date)
    humanReadableDate
} catch (e: Exception) {
    this
}