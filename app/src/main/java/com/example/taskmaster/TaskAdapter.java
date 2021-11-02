package com.example.taskmaster;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    List<Task> allTasks= new ArrayList<>();

    public TaskAdapter(List<Task> allTasks) {
        this.allTasks = allTasks;
    }
    public  static  class TaskViewHolder extends RecyclerView.ViewHolder{

        public Task task;
        View itemView;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToDetailsPage=new Intent(v.getContext(),DetailPage.class);
                    goToDetailsPage.putExtra("taskNameClickListener",task.title);
                    goToDetailsPage.putExtra("taskBodyClickListener",task.body);
                    goToDetailsPage.putExtra("taskStateClickListener",task.state);
                    v.getContext().startActivity(goToDetailsPage);
                }
            });
        }

    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_task, viewGroup , false);
        return new TaskViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder taskViewHolder, int i) {

        taskViewHolder.task=allTasks.get(i);

        TextView taskTitle = taskViewHolder.itemView.findViewById(R.id.titletask);
        TextView taskBody = taskViewHolder.itemView.findViewById(R.id.bodytask);
        TextView taskState = taskViewHolder.itemView.findViewById(R.id.statetask);

        taskTitle.setText(taskViewHolder.task.title);
        taskBody.setText(taskViewHolder.task.body);
        taskState.setText(taskViewHolder.task.state);

    }

    @Override
    public int getItemCount() {
        return allTasks.size();
    }


}