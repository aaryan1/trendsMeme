package com.tks.trendsmeme.extensions

/**moveTo: Move an item in a list from one position to another.*/
fun <T> MutableList<T>.moveTo(fromIndex: Int, toIndex: Int) {
    val item = this.removeAt(fromIndex)
    this.add(toIndex, item)
}