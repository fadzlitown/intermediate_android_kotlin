package com.inovasiti.intermediate_android_kotlin.ui.task

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.model.Todo
import kotlinx.android.synthetic.main.fragment_task_list.*

class TaskListFragment : Fragment() {
    lateinit var taskListViewModel: HomeViewModel

    lateinit var touchActionCallback: TouchActionCallback

    lateinit var mAdapter: TaskAdapter

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
        val root = inflater.inflate(R.layout.fragment_task_list, container, false)
        bindViewModel()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //after view has been created
        rv.layoutManager = LinearLayoutManager(context)
        mAdapter = TaskAdapter(
            //avoid the warning asking the first param, just add parameter name "touchActionCallback =", so compiler knows this value to whom
            // constructor will knows, just specify the param name
            touchActionCallback = touchActionCallback
        )
        rv.adapter = mAdapter
    }

    private fun bindViewModel() {
        taskListViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        //public value taskListLiveData will observe / listen any data supply from viewmodel
        taskListViewModel.taskListLiveData.observe(viewLifecycleOwner, Observer { taskList ->
            //when data changes detect, then update in adapter
            mAdapter.updateList(taskList)
        })
    }

    interface TouchActionCallback {
        fun onAddButtonClicked(value: String)
    }
}