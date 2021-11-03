package com.example.taskmaster;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "taskTitle")
    public String title;
    @ColumnInfo(name = "taskBody")
    public String body;
    @ColumnInfo(name = "taskState")
    public String state;

    public Task(String title, String body, String state) {
        this.title = title;
        this.body = body;
        this.state = state;
    }
}
