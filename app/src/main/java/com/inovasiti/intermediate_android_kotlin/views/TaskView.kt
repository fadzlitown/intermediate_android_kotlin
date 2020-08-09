package com.inovasiti.intermediate_android_kotlin.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import kotlinx.android.synthetic.main.item_task.view.*


//Custom  View
class TaskView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    lateinit var task: Task

    fun initView(task: Task) {
        this.task = task
        titleView.text = task.title
        task.todos.forEach { todo ->
            // item task view will wrapping inside the todos container (nested custom view)
            val inflatedTodoView = (LayoutInflater.from(context).inflate(R.layout.view_todo, container, false) as TodoView)
                .apply {
                    initView(todo, {
                        //here where the callback will be invoked
                        if (isTaskCompleted()){
                            createStrikeThrough()
                        } else{
                            removeStrikeThrough()
                        }
                    })
                }
            //add todoView inside container in LL
            container.addView(inflatedTodoView)
        }

    }

    //need to check everything each item all todos are completed / not, run everything the checkbox is toggled
    fun isTaskCompleted(): Boolean {
        return task.todos.filter { ! it.isComplete }.isEmpty()
    }

    /**
     * bitwise OR ( | ). It compares 2 bits and if EITHER ONE OR BOTH are true
     * bitwise inverse (~) : takes 1 bit, and flips every value (true -> false, false -> true)
     */
    private fun createStrikeThrough() {
        titleView?.apply {
            //10101000 | 00000010 => 10101010
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        titleView?.apply {
            //~(Paint.StrikeThrough) : 10101010 & 11111101 = 10101000
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}