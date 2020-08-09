package com.inovasiti.intermediate_android_kotlin.ui.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.inovasiti.intermediate_android_kotlin.R
import com.inovasiti.intermediate_android_kotlin.model.Note
import com.inovasiti.intermediate_android_kotlin.ui.task.TaskAdapter
import kotlinx.android.synthetic.main.view_add_button.view.*

//1. abstract class, cannot be instatntiate w/o implementing the method
// our base adapter should be flexible to accept GENERIC of obj list, (T as any object)
abstract class BaseRecyclerView<T>(
    //2. protected will visible in classes that extend or the child classes
    protected val masterList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    //return the viewtype
    override fun getItemViewType(position: Int): Int = if (position == 0) TYPE_ADD_BUTTON else TYPE_INFO

    //3. only override some of the generic method which can be extended
    //masterList came from BaseRecyclerView which hold both 2 viewtype items, added + 1 coz of the button item
    override fun getItemCount(): Int = masterList.size + 1


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //is = is an object of
        if (holder is AddButtonViewHolder) {
            holder.onBind(Unit)
        } else {
            // -1 bcoz we have 1 button view
            (holder as BaseViewHolder<T>).onBind(masterList[position-1])
        }
    }

    // need to add <E> bcs it should accept generic Viewholder obj (since T already used, then use any other word)
    abstract class BaseViewHolder<anyVH>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // when passing the generic obj in the method, should add "type E"
        abstract fun onBind(data: anyVH)
    }

    //Unit type = to the `void` type in Java
    abstract class AddButtonViewHolder(val view: View) : BaseViewHolder<Unit>(view)

    abstract fun updateList(list : MutableList<T>)

    //constants val
    companion object {
        const val TYPE_ADD_BUTTON = 0
        const val TYPE_INFO = 1
    }
}