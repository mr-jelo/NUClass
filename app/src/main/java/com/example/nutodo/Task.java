package com.example.nutodo;

public class Task {
    String subject;
    String taskName;
    String dueDate;
    String submittedDate;
    String status; // Assigned, Missing, Completed

    public Task(String subject, String taskName, String dueDate, String submittedDate, String status) {
        this.subject = subject;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.submittedDate = submittedDate;
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public String getStatus() {
        return status;
    }
}

