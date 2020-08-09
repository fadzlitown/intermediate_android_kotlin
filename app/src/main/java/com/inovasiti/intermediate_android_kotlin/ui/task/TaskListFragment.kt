package com.inovasiti.intermediate_android_kotlin.ui.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.model.Todo
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {
    private var taskListViewModel: HomeViewModel? = null

    lateinit var touchActionCallback: TouchActionCallback

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //need to check context null or not
        context?.let {
            if (it is TouchActionCallback) {
                touchActionCallback = it
            }
        }
    }

    //this below method like public static newInstance in Java. Kotlin doesnt allow static to be used
    companion object {
        fun newInstance(): TaskListFragment {
            return TaskListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        taskListViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_task_list, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after view has been created
        rv.layoutManager = LinearLayoutManager(context)
        val adapter = TaskAdapter(
            mutableListOf(
                Task(
                    "Test 1", mutableListOf(
                        Todo("Test todo1", true),
                        Todo("Test todo2")
                    )
                ),
                Task("Test 2"),
                Task("Test 3")
            )
        ,touchActionCallback)
        rv.adapter = adapter
    }

    interface TouchActionCallback {
        fun onAddButtonClicked(value : String)
    }
}