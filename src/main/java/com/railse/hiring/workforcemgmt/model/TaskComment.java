package com.railse.hiring.workforcemgmt.model;

import lombok.Data;

@Data
public class TaskComment {
    private Long id;
    private Long taskId;
    private String comment;
    private Long createdAt;
}