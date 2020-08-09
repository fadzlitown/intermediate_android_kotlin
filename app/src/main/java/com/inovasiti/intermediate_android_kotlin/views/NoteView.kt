package com.inovasiti.intermediate_android_kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inovasiti.intermediate_android_kotlin.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NoteView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {

    fun initView(note: Note) {
        titleView.text = note.description
    }
}