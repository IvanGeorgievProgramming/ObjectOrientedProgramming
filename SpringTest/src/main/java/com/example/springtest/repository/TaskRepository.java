package com.example.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTitle(String title);
    List<Task> findByDueDate(LocalDate dueDate);
    List<Task> findByPriority(Priority priority);
    // Additional custom query methods can be defined here
}