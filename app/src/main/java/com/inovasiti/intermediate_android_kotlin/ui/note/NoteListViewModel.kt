package com.inovasiti.intermediate_android_kotlin.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inovasiti.intermediate_android_kotlin.model.Note

class NoteListViewModel : ViewModel() {
    private val mText: MutableLiveData<String>

    val text: LiveData<String>
        get() = mText

    init {
        mText = MutableLiveData()
        mText.value = "This is dashboard fragment"
    }

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("asdasdas"),
        Note("HAHAHA"),
        Note("powerrr")
    )
}