package com.tks.trendsmeme.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date


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
} catch (e: Exception) {
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