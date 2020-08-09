package com.inovasiti.intermediate_android_kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inovasiti.intermediate_android_kotlin.model.Note

class NoteView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var titleView: TextView? = null

    fun initView(note: Note) {
        titleView?.text = note.description
    }
}