package com.example.myapp.presentation.task

import com.example.myapp.domain.task.Task
import com.example.myapp.domain.task.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@RequestMapping("task")
class TaskController {
    @Autowired
    private lateinit var taskRepository: TaskRepository

    @ResponseBody
    @GetMapping
    fun list(attributes: RedirectAttributes): String {
        return TaskView.list(attributes, taskRepository.findAll())
    }

    @ResponseBody
    @GetMapping(produces = arrayOf("application/json"))
    fun listJson(): Map<String, Any?> {
        return TaskJsonView.list(taskRepository.findAll())
    }

    @PostMapping
    fun create(
            attributes: RedirectAttributes,
            @RequestParam name: String): String {
        val task = Task()
        task.name = name
        taskRepository.save(task)
        attributes.addFlashAttribute("success", "タスクを追加しました。")
        return "redirect:/task"
    }
}