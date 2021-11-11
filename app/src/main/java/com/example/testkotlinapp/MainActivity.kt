package com.example.testkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddTask: Button
    private lateinit var editTextTextTaskTitle: EditText
    private lateinit var editTextTextTaskDescription: EditText
    private lateinit var recyclerViewTasksList: RecyclerView

    private lateinit var tasksManager: TasksManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tasksManager = TasksManager()

        recyclerViewTasksList = findViewById(R.id.recyclerViewTasksList)
        var llm = LinearLayoutManager(applicationContext)
        recyclerViewTasksList.layoutManager = llm

        editTextTextTaskTitle = findViewById(R.id.editTextTextTaskTitle)
        editTextTextTaskDescription = findViewById(R.id.editTextTextTaskDescription)

        buttonAddTask = findViewById(R.id.buttonAddTask)
        buttonAddTask.setOnClickListener(buttonAddTaskClickListener)
    }

    private val buttonAddTaskClickListener: View.OnClickListener = View.OnClickListener {
        var title = editTextTextTaskTitle.text.toString()
        var description = editTextTextTaskDescription.text.toString()

        editTextTextTaskTitle.text.clear()
        editTextTextTaskDescription.text.clear()

        var taskItem = TaskItem(title, description)
        tasksManager.addTask(taskItem)

        Toast.makeText(applicationContext,"Задача успешно добавлена", Toast.LENGTH_LONG).show()

        var rvAdapterTasksList = RvAdapterTasksList(tasksManager)
        recyclerViewTasksList.adapter = rvAdapterTasksList
    }
}