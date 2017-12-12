package com.example.myapp.presentation.task

import com.example.myapp.domain.task.Task
import com.example.myapp.presentation.core.col
import com.example.myapp.presentation.core.row
import com.example.myapp.presentation.layout.LayoutView
import kotlinx.html.*
import org.springframework.ui.ModelMap

object TaskView {
    fun list(
            modelMap: ModelMap,
            taskList: List<Task>
    ) = LayoutView.default(modelMap) {
        taskList.forEach {
            row {
                col {
                    +(it.name ?: "")
                }
            }
        }
        hr {  }
        row {
            col {
                postForm("/task") {
                    div("form-group") {
                        label("col-form-label") {
                            htmlFor = "name"
                        }
                        textInput {
                            classes = setOf("form-control")
                            name = "name"
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