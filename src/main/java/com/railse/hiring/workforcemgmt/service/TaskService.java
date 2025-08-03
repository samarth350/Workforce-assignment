package com.railse.hiring.workforcemgmt.service;

import com.railse.hiring.workforcemgmt.model.TaskManagement;
import com.railse.hiring.workforcemgmt.model.enums.TaskStatus;
import com.railse.hiring.workforcemgmt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskManagement> getSmartTasksForDateRange(Long startDate, Long endDate) {
        return taskRepository.findAll().stream()
            .filter(task ->
                task.getStatus() == TaskStatus.ASSIGNED &&
                (
                    (task.getStartDate() != null && task.getStartDate() >= startDate && task.getStartDate() <= endDate)
                    ||
                    (task.getStartDate() != null && task.getStartDate() < startDate)
                )
            )
            .toList();
    }
}