package com.inovasiti.intermediate_android_kotlin.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inovasiti.intermediate_android_kotlin.model.Note

class NoteListViewModel : ViewModel() {
    private val mText: MutableLiveData<String>
    val text: LiveData<String>
        get() = mText

    private val _noteLiveData: MutableLiveData<MutableList<Note>> = MutableLiveData()

    //only this val is public to view
    val noteLiveData: LiveData<MutableList<Note>> = _noteLiveData

    init {
        mText = MutableLiveData()
        mText.value = "This is dashboard fragment"
        //pass list of note
        _noteLiveData.postValue(getFakeData())
    }

    fun getFakeData(): MutableList<Note> = mutableListOf(
        Note("asdasdas kkk"),
        Note("HAHAHA aaaa"),
        Note("powerrr")
    )
}