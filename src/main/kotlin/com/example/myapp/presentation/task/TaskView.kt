package com.example.myapp.presentation.task

import com.example.myapp.domain.task.Task
import com.example.myapp.presentation.core.row
import com.example.myapp.presentation.layout.LayoutView
import kotlinx.html.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

object TaskView {
    fun list(
            redirectAttributes: RedirectAttributes,
            taskList: List<Task>
    ) = LayoutView.default(redirectAttributes) {
        taskList.forEach {
            row {
                div("col") {
                    +(it.name ?: "")
                }
            }
        }
        hr {  }
        row {
            div("col") {
                postForm("/task") {
                    div("form-group") {
                        label("col-form-label") {
                            htmlFor = "name"
                        }
                        textInput {
                            classes = setOf("form-control")
                            name = "name"
                            attributes["data-id"] = "a"
                        }
                    }
                    div("form-group") {
                        button {
                            classes = setOf("btn btn-primary")
                            type = ButtonType.submit
                            +"Submit"
                        }
                    }
                }
            }
        }
    }
}