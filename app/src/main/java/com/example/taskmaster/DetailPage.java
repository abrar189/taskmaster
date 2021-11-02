package com.example.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        String title=intent.getExtras().getString("taskNameClickListener");
        String body=intent.getExtras().getString("taskBodyClickListener");
        String state=intent.getExtras().getString("taskStateClickListener");
        TextView taskTitleView =findViewById(R.id.titleTask);
        TextView taskBodyView =findViewById(R.id.taskBody);
        TextView taskStateView =findViewById(R.id.taskState);
        taskTitleView.setText("Task Title:  "+title);
        taskBodyView.setText("Task Body:  "+body);
        taskStateView.setText("Task State:  "+state);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Intent intent = getIntent();
//        String taskName = intent.getExtras().getString("taskName");
//        TextView taskTitle = findViewById(R.id.titleTask);
//        taskTitle.setText(taskName);
//    }
}