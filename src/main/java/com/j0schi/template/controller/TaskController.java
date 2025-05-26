package com.j0schi.template.controller;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Пример работы с тасками:
 * http://localhost:8080/camunda/app/tasklist
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Получить задачи пользователя
    @GetMapping
    public List<Task> getUserTasks(@RequestParam String assignee) {
        return taskService.createTaskQuery()
                .taskAssignee(assignee)
                .list();
    }

    // Завершить задачу
    @PostMapping("/{taskId}/complete")
    public void completeTask(@PathVariable String taskId,
                             @RequestBody Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }
}