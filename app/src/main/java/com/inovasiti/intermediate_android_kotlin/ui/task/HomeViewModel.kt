package com.inovasiti.intermediate_android_kotlin.ui.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inovasiti.intermediate_android_kotlin.model.Task
import com.inovasiti.intermediate_android_kotlin.model.Todo

class HomeViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String> get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is home fragment"
    }

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