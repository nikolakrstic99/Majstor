package com.master.app.utils

// Page index starts from 1
fun<T> paginate(list: List<T>, page: Int, pageSize: Int): List<T> {
    val fromIndex = (page - 1) * pageSize
    val toIndex = minOf(fromIndex + pageSize, list.size)
    return if (fromIndex in list.indices) {
        list.subList(fromIndex, toIndex)
    } else {
        emptyList()
    }
}