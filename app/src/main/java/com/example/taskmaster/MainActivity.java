package com.example.taskmaster;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());

            Log.i("Tutorial", "Initialized Amplify");
        } catch (AmplifyException error) {
            Log.e("Tutorial", "Could not initialize Amplify", error);
        }


        RecyclerView allTasks = findViewById(R.id.recyclerView);

        Handler handler =new Handler(Looper.getMainLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                allTasks.getAdapter().notifyDataSetChanged();
                return false;
            }
        });

        List <Task> tasks= new ArrayList<Task>();

        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.Task.class),
                response -> {
                    for (Task taskTodo : response.getData()) {
                        tasks.add(taskTodo);
                    }
                    handler.sendEmptyMessage(1);
                },
                error -> Log.e("MyAmplifyApp", error.toString(), error)
        );

        allTasks.setLayoutManager(new LinearLayoutManager(this));
        allTasks.setAdapter(new TaskAdapter(tasks));



        Button allTaskButton = findViewById(R.id.button2);

        allTaskButton.setOnClickListener(V -> {
            Intent activity2Intent = new Intent(MainActivity.this, AllTasks.class);
            startActivity(activity2Intent);
        });


        Button addTaskButton = findViewById(R.id.button);
        addTaskButton.setOnClickListener(V -> {
            Intent activity2Intent = new Intent(MainActivity.this, AddTask.class);
            startActivity(activity2Intent);
        });

        findViewById(R.id.sitting).setOnClickListener(V ->{
            Intent sitting= new Intent(MainActivity.this ,SettingsPage.class);
            startActivity(sitting);
        });


        Button tAsk1 = findViewById(R.id.task1);
        tAsk1.setOnClickListener((view -> {
            String taskTitle = tAsk1.getText().toString();
            Intent goToDetail = new Intent(MainActivity.this , DetailPage.class);
            goToDetail.putExtra("taskName", taskTitle);
            startActivity(goToDetail);
        }));


        Button tAsk2 = findViewById(R.id.task2);
        tAsk2.setOnClickListener((view -> {
            String taskTitle = tAsk2.getText().toString();
            Intent goToDetail = new Intent(MainActivity.this , DetailPage.class);
            goToDetail.putExtra("taskName", taskTitle);
            startActivity(goToDetail);
        }));


        Button tAsk3 = findViewById(R.id.task3);
        tAsk3.setOnClickListener((view -> {
            String taskTitle = tAsk3.getText().toString();
            Intent goToDetail = new Intent(MainActivity.this , DetailPage.class);
            goToDetail.putExtra("taskName", taskTitle);
            startActivity(goToDetail);
        }));
    }



    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Override onStart()", Toast.LENGTH_SHORT).show();
    }
    @SuppressLint("SetTextI18n")
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Override onResume()", Toast.LENGTH_SHORT).show();

        String usernameTasks = "’s tasks";

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String instName = sharedPreferences.getString("UserName","Go and set your Name");

        TextView theUser = findViewById(R.id.textView9);
        theUser.setText( instName  + usernameTasks);
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
////        Toast.makeText(getApplicationContext(), "Override onPause()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
////        Toast.makeText(getApplicationContext(), "Override onStop()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
////        Toast.makeText(getApplicationContext(), "Override onRestart()", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
////        Toast.makeText(getApplicationContext(), "Override onDestroy()", Toast.LENGTH_SHORT).show();
//    }
}