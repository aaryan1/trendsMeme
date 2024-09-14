package com.tks.trendsmeme.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.util.Patterns
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

fun String.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(context,this ,duration).show()
}
/**
Convert a string to title case (capitalize the first letter of each word).
 * */
fun String.toTitleCase(): String {
    return split(" ").joinToString(" ") { it.capitalize() }
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

/** Check if a string is a valid email address.*/
fun String.isValidEmail(): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(this).matches()
}
/** removeWhiteSpace: Remove all whitespace from a string*/
fun String.removeWhiteSpace(): String {
    return replace("\\s".toRegex(), "")
}