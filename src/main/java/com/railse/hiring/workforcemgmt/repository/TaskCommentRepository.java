package com.railse.hiring.workforcemgmt.repository;

import com.railse.hiring.workforcemgmt.model.TaskComment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class TaskCommentRepository {
    private final List<TaskComment> comments = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public TaskComment addComment(Long taskId, String comment) {
        TaskComment taskComment = new TaskComment();
        taskComment.setId(idCounter.getAndIncrement());
        taskComment.setTaskId(taskId);
        taskComment.setComment(comment);
        taskComment.setCreatedAt(System.currentTimeMillis());
        comments.add(taskComment);
        return taskComment;
    }

    public List<TaskComment> getCommentsByTaskId(Long taskId) {
        return comments.stream()
                .filter(c -> c.getTaskId().equals(taskId))
                .collect(Collectors.toList());
    }
}