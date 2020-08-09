package com.inovasiti.intermediate_android_kotlin.ui.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.BottomNavigationActivity
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.ui.foundations.BaseRecyclerView
import com.inovasiti.intermediate_android_kotlin.views.TaskView
import kotlinx.android.synthetic.main.view_add_button.view.*


class TaskAdapter(
    //add in constructor, also assigned as a member var in this class, need to pass a list of task
    taskList: MutableList<Task> = mutableListOf(), //by def mutableListOf() is empty list, used mutableListOf bcs we dont want to change later on
    val touchActionCallback : TaskListFragment.TouchActionCallback

) : BaseRecyclerView<Task>(taskList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //return based on viewType & the right viewholder
        return if (viewType == TYPE_ADD_BUTTON) {
            AddButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_add_button, parent, false)
            )
        } else {
            TaskViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
            )
        }
    }

    //to be able view as a member class, just add "val view"
    class TaskViewHolder(val view: View) : BaseViewHolder<Task>(view) {
        override fun onBind(data: Task) {
            (view as TaskView).initView(data)
        }
    }

    // added inner class under TaskAdapter class. so that touchActionCallback can be accessed
    inner class AddButtonViewHolder(view: View) : BaseRecyclerView.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button)
            view.setOnClickListener {
                touchActionCallback.onAddButtonClicked(BottomNavigationActivity.FRAGM_VALUE_TASK)
            }
        }
    }

}