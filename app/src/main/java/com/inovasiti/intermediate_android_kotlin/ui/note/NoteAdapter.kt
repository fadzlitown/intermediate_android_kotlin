package com.inovasiti.intermediate_android_kotlin.ui.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Note
import com.inovasiti.intermediate_android_kotlin.ui.foundations.BaseRecyclerView
import kotlinx.android.synthetic.main.item_task.view.*

class NoteAdapter(
    noteList : MutableList<Note> = mutableListOf()

) : BaseRecyclerView<Note>(noteList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(val view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            view.titleView.text = data.description
        }
    }
}