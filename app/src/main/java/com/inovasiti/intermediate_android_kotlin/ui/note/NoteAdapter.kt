package com.inovasiti.intermediate_android_kotlin.ui.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.BottomNavigationActivity
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Note
import com.inovasiti.intermediate_android_kotlin.ui.foundations.BaseRecyclerView
import com.inovasiti.intermediate_android_kotlin.views.NoteView
import kotlinx.android.synthetic.main.view_add_button.view.*

class NoteAdapter(
    noteList: MutableList<Note> = mutableListOf(),
    val touchActionCallback: NoteListFragment.TouchActionCallback

) : BaseRecyclerView<Note>(noteList) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ADD_BUTTON){
            return AddButtonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_add_button,parent,false))
        } else {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false))
        }
    }

    class ViewHolder(val view: View) : BaseViewHolder<Note>(view) {
        override fun onBind(data: Note) {
            (view as NoteView).initView(data)

            //moved below code inside  initView(data)
//            view.titleView.text = data.description
        }
    }

    //REMMEBER!!! innear class has access to WRAPPING CLASS variable!!
    inner class AddButtonViewHolder(view: View) : BaseRecyclerView.AddButtonViewHolder(view) {
        override fun onBind(data: Unit) {
            view.buttonText.text = view.context.getString(R.string.add_button_note)
            view.setOnClickListener {
                touchActionCallback.onAddButtonClicked(BottomNavigationActivity.FRAG_VALUE_NOTE)
            }
        }
    }
}