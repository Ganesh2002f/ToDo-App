package com.todo.services;

import com.todo.model.TaskEntity;
import com.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


  public List<TaskEntity> getAllTasks(){
      List<TaskEntity> s = taskRepository.findAll();
      return s;
  }

    public void createTask(String title) {
      TaskEntity t = new TaskEntity();
      t.setTitle(title);
      t.setCompleted(false);
      taskRepository.save(t);
    }

    public void deleteTask(Long id) {
      taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
      TaskEntity t = taskRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid task"));
      t.setCompleted(!t.isCompleted());
      taskRepository.save(t);
    }

    public TaskEntity findById(Long id) {
      TaskEntity task = taskRepository.findById(id).get();
      return task;
    }

    public TaskEntity updateTask(TaskEntity taskEntity)
    {
      return taskRepository.save(taskEntity);
    }
}
