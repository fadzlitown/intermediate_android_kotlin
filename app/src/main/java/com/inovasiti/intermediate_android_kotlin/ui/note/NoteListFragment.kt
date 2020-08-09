package com.inovasiti.intermediate_android_kotlin.ui.note

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
import com.inovasiti.intermediate_android_kotlin.model.Note
import kotlinx.android.synthetic.main.fragment_note_list.*

class NoteListFragment : Fragment() {
    lateinit var mAdapter: NoteAdapter
    lateinit var noteViewModel: NoteListViewModel
    lateinit var touchActionCallback: NoteListFragment.TouchActionCallback

    companion object {
        fun newInstance(): NoteListFragment {
            return NoteListFragment()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //need to check context null or not
        context?.let {
            if (it is TouchActionCallback) {
                touchActionCallback = it
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_note_list, container, false)
        noteViewModel = ViewModelProviders.of(this).get(NoteListViewModel::class.java)
        noteViewModel.noteLiveData.observe(viewLifecycleOwner, Observer {
            mAdapter.updateList(it)
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv.layoutManager = LinearLayoutManager(context)
        mAdapter = NoteAdapter(touchActionCallback =  touchActionCallback)
        rv.adapter = mAdapter
    }

    interface TouchActionCallback {
        fun onAddButtonClicked(value: String)
    }


}