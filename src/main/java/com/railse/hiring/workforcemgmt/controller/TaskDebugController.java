package com.railse.hiring.workforcemgmt.controller;

import com.railse.hiring.workforcemgmt.model.TaskManagement;
import com.railse.hiring.workforcemgmt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/debug")
public class TaskDebugController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/smart-tasks")
    public List<TaskManagement> getSmartTasks(@RequestParam Long start, @RequestParam Long end) {
        return taskService.getSmartTasksForDateRange(start, end);
    }
}