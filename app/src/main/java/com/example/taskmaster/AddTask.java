package com.example.taskmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.room.Room;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Button addTaskButton = findViewById(R.id.button3);


        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                EditText title=findViewById(R.id.addtitle);
                String addTitle=title.getText().toString();

                EditText body=findViewById(R.id.addDesc);
                String addBody=body.getText().toString();

                EditText state=findViewById(R.id.addstate);
                String addState=state.getText().toString();

                Task task =new Task(addTitle,addBody,addState);
                Long addedTaskID = AppDatabase.getInstance(getApplicationContext()).taskDao().insertAll(task);

                Toast.makeText(getApplicationContext(),"submitted!", Toast.LENGTH_SHORT).show();
                System.out.println(
                        "++++++++++++++++++++++++++++++++++++++++++++++++++" +
                                " Student ID : " + addedTaskID
                                +
                                "++++++++++++++++++++++++++++++++++++++++++++++++++"
                );
            }
        });

        Button backButton=findViewById(R.id.back1);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent transferToAddTask=new Intent(AddTask.this,MainActivity.class);
                startActivity(transferToAddTask);
            }
        });


    }
    }
