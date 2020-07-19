package com.inovasiti.intermediate_android_kotlin.ui.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Note
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment : Fragment() {
    private var dashboardViewModel: NoteListViewModel? = null

    companion object {
        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_note_list, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.layoutManager  = LinearLayoutManager(context)
        rv.adapter = NoteAdapter(mutableListOf(
            Note("asdasdas"),
            Note("HAHAHA"),
            Note("powerrr")
        ))
    }
}