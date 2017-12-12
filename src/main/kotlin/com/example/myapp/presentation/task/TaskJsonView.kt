package com.example.myapp.presentation.task

import com.example.myapp.domain.task.Task
import com.example.myapp.presentation.layout.LayoutJsonView

object TaskJsonView {
    fun list(taskList: List<Task>): Map<String, Any?> {
        return LayoutJsonView.success(
                mapOf(
                        "tasks" to taskList.map {
                            mapOf(
                                    "id" to it.id,
                                    "name" to it.name,
                                    "created_at" to it.createdAt?.toString(),
                                    "updated_at" to it.updatedAt?.toString()
                            )
                        }
                )
        )
    }
}