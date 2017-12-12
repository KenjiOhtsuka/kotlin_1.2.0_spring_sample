package com.example.myapp.presentation.core

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

private fun FlowContent.divWithClass(
        defaultClass: String, classes : String? = null, block : DIV.() -> Unit = {}) {
    val _classes: String
    if (classes.isNullOrBlank()) _classes = defaultClass
    else _classes = classes + " " + defaultClass
    return div(_classes, block)
}

fun FlowContent.row(
        classes : String? = null, block : DIV.() -> Unit = {}) =
        divWithClass("row", classes, block)

fun FlowContent.col(
        classes : String? = null, block : DIV.() -> Unit = {}) =
        divWithClass("col", classes, block)
