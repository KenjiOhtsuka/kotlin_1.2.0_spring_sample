package com.example.myapp.presentation.layout

import com.example.myapp.presentation.core.col
import com.example.myapp.presentation.core.row
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.springframework.ui.ModelMap
import java.io.StringWriter

object LayoutView {
    private fun HEAD.metaTags() = {
        meta { attributes["charset"] = "UTF-8" }
        meta(name = "robots", content = "noindex,nofollow,noarchive")
        meta(name = "viewport", content = "width=device-width,initial-scale=1.0")
    }()

    fun default(
            modelMap: ModelMap,
            pageTitle: String = "", block: DIV.() -> Unit
    ): String =
            StringWriter().
                    appendln("<!DOCTYPE html>").
                    appendHTML().html {
                head {
                    title {
                        +pageTitle
                    }
                    metaTags()
                    styleLink("https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css")
                }
                body {
                    id = "main"

                    header("pos-f-t") {
                        nav("navbar navbar-light bg-light") {
                            a("/") {
                                classes = setOf("navbar-brand")
                                +"Task List"
                            }
                        }
                    }

                    if (modelMap.containsAttribute("success")) {
                        div("container") {
                            row {
                                col {
                                    div("alert alert-success") {
                                        role = "alert"
                                        +(modelMap["success"] as String)
                                    }
                                }
                            }
                        }
                    }

                    div("container") {
                        block()
                    }
                }
            }.toString()
}