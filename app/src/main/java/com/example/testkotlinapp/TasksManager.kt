package com.example.testkotlinapp

class TasksManager {
    private var tasks: ArrayList<TaskItem> = arrayListOf()
    private var id: Int = 0

    fun addTask(taskItem: TaskItem) {
        id++
        taskItem.id = id
        tasks.add(taskItem)
    }

    fun deleteTask(index: Int) {
        tasks.removeAt(index)
    }

    fun getByIndex(index: Int): TaskItem {
        return tasks[index]
    }

    fun getCount(): Int {
        return tasks.size
    }
}