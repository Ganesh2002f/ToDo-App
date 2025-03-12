package com.todo.controller;

import com.todo.model.TaskEntity;
import com.todo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {


    @Autowired
    private TaskService taskService;


    @GetMapping
    public String getTasks(Model model){
        List<TaskEntity> tasks = taskService.getAllTasks();
        model.addAttribute("tasks" , tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return "redirect:/";
    }


    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id)
    {
        taskService.toggleTask(id);
        return "redirect:/";
    }


    @GetMapping("/update/{id}")
    public String update (@PathVariable Long id, Model model)
    {
        model.addAttribute("t",taskService.findById(id));
        return "update";
    }


    @PostMapping("/update/task/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("t") TaskEntity taskEntity, Model model)
    {
        TaskEntity existingData = taskService.findById(id);
        existingData.setId(taskEntity.getId());
        existingData.setTitle(taskEntity.getTitle());

        taskService.updateTask(existingData);
        return "redirect:/";
    }







}
