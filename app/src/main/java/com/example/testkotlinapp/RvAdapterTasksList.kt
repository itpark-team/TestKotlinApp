package com.example.testkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RvAdapterTasksList : RecyclerView.Adapter<RvAdapterTasksList.TaskItemViewHolder> {

    class TaskItemViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var textViewTaskitemViewTitle: TextView =
            itemView.findViewById(R.id.textViewTaskitemViewTitle)
        var textViewTaskitemViewDescription: TextView =
            itemView.findViewById(R.id.textViewTaskitemViewDescription)
        var buttonTaskitemViewDeleteTask: Button =
            itemView.findViewById(R.id.buttonTaskitemViewDeleteTask)
    }

    private var taskManager: TasksManager

    constructor(taskManager: TasksManager) {
        this.taskManager = taskManager
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.taskitem_view, parent, false)

        return TaskItemViewHolder(v)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        var taskItem: TaskItem = taskManager.getByIndex(position)

        holder.textViewTaskitemViewTitle.text = taskItem.title
        holder.textViewTaskitemViewDescription.text = taskItem.description

        holder.buttonTaskitemViewDeleteTask.setOnClickListener{
            taskManager.deleteTask(position)

            notifyItemRemoved(position)
            notifyItemRangeChanged(position, taskManager.getCount())
        }
    }

    override fun getItemCount(): Int = taskManager.getCount()


}