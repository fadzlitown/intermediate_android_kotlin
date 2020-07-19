package com.inovasiti.intermediate_android_kotlin.ui.task

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.ui.foundations.BaseRecyclerView
import com.inovasiti.intermediate_android_kotlin.views.TodoView
import kotlinx.android.synthetic.main.item_task.view.*
import kotlinx.android.synthetic.main.view_todo.view.*

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


            //iterate each  list objs
            data.todos.forEach { todo ->

                //Here where we need to inflate our custom layout view
                //inflate()
                // resource -> layout view, root -> your base view (parent view)
                // attachToRoot true
                // -> will returns ViewGroup (parent) , will add View as Child of the ViewGroup (parent) eg. receive touch event etc
                // Auto added to parent(sometimes dont want this)
                // eg. we've a fragment where we dont want to add viewholder in recyclerview to rv adapter. But only need recyclerview independent to control the viewholder

                // attachToRoot false
                // returns view(resource) inflated
                // doesnt add View as child so it will not receive touch event (only uses parent for layout params)
                // can later be added with parent.addView() = same concept like inflating attachToRoot true

                //if attachToRoot true, then we going to get back the (root view) LinearLayout container attached + childs.
                // otherwise (false) will get child (resource view_todo)

                val inflatedTodoView = (LayoutInflater.from(view.context).inflate(R.layout.view_todo, view.container, false) as TodoView)
                    .apply {
                        //apply block = anything under this view manipulation set / logic can be under this block
                        //eg. can directly access the specific view id (good to consolidation views, & apply to inflatedTodoView)

                        initView(todo)
                    }

                //add todoView inside container in LL
                view.container.addView(inflatedTodoView)
            }

        }
    }
}