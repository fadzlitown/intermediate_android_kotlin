package com.inovasiti.intermediate_android_kotlin.ui.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.ui.foundations.BaseRecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class TaskAdapter(
    //add in constructor, also assigned as a member var in this class, need to pass a list of task
    taskList: MutableList<Task> = mutableListOf() //by def mutableListOf() is empty list, used mutableListOf bcs we dont want to change later on

) : BaseRecyclerView<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return ViewHolder(v);
    }

    //to be able view as a member class, just add "val view"
    class ViewHolder(val view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            view.titleView.text = data.title
        }
    }
}