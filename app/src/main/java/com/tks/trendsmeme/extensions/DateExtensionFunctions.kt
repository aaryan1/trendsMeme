package com.tks.trendsmeme.extensions

import android.icu.util.Calendar
import java.util.Date

/**isToday: Check if a Date object represents today.*/
fun Date.isToday(): Boolean {
    val calendar = Calendar.getInstance()
    calendar.time = this

    val today = Calendar.getInstance()
    return calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR) &&
            calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR)
}
/** toMillis: Convert a Date object to milliseconds.*/
fun Date.toMillis(): Long {
    return this.time
}

/** toCalendar: Convert a Date object to a Calendar instance.*/
fun Date.toCalendar(): Calendar {
    val calendar = Calendar.getInstance()
    calendar.time = this
    return calendar
}
/** toDate: Convert a Calendar instance to a Date object.*/
fun Calendar.toDate(): Date {
    return this.time
}