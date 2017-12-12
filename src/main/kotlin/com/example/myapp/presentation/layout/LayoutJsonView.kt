package com.example.myapp.presentation.layout

object LayoutJsonView {
    fun success(data: Map<String, Any?>?): Map<String, Any?> {
        return mapOf("data" to data)
    }
}