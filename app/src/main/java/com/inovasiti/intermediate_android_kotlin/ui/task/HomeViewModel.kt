package com.inovasiti.intermediate_android_kotlin.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.model.Todo

class HomeViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String> get() = mText

    //List of task (mutable-yg boleh di ubah2)
    private val _taskListLiveData: MutableLiveData<MutableList<Task>> = MutableLiveData()

    //taskListLiveData is a public, & to be used in view fragment / activity
    val taskListLiveData: LiveData<MutableList<Task>> = _taskListLiveData

    //special fun will runs when constructor is made
    init {
        //list of data
        //1. this is synchronous process use ".value", if you know what needs to assign in here
//        _taskListLiveData.value = getFakeData()
        //2. this is asynchronous process, use "postValue".  async value to live data for those observers (in fragment / activity)
        _taskListLiveData.postValue(getFakeData())

        mText = MutableLiveData()
        mText.value = "This is home fragment"
    }

    //business logic & data should be in this class
    fun getFakeData(): MutableList<Task> = mutableListOf(
        Task(
            "Test 1", mutableListOf(
                Todo("Test todo1", true),
                Todo("Test todo2")
            )
        ),
        Task("Test 2"),
        Task("Test 3")
    )
}