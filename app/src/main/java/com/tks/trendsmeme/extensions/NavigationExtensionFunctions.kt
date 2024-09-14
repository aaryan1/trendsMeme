package com.tks.trendsmeme.extensions

import androidx.navigation.NavHostController

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