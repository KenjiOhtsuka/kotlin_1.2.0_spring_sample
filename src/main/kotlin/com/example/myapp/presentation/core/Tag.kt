package com.example.myapp.presentation.core

import kotlinx.html.DIV
import kotlinx.html.FlowContent
import kotlinx.html.div

fun FlowContent.row(classes : String? = null, block : DIV.() -> Unit = {}) {
    val _classes: String
    if (classes.isNullOrBlank()) _classes = "row"
    else _classes = classes + " row"
    return div(_classes, block)
}