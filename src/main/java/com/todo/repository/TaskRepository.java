package com.todo.repository;

import com.todo.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
}
