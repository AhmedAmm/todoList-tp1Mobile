package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

    private EditText editTask;
    private Button btnAddTask;
    private ListView listViewTasks;

    private ArrayList<String> tasks;          // List of tasks
    private ArrayAdapter<String> adapter;     // Adapter for ListView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);  // link to your XML file

        // Initialize UI components
        editTask = findViewById(R.id.editTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        listViewTasks = findViewById(R.id.listViewTasks);

        // Initialize list + adapter
        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(adapter);

        // Add task when button is clicked
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    tasks.add(task);              // add to ArrayList
                    adapter.notifyDataSetChanged(); // refresh ListView
                    editTask.setText("");         // clear input
                } else {
                    Toast.makeText(ToDoList.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Delete task when long pressed
        listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String removedTask = tasks.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(ToDoList.this, "Deleted: " + removedTask, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}