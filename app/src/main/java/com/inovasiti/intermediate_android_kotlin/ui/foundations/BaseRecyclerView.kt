package com.inovasiti.intermediate_android_kotlin.ui.foundations

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//1. abstract class, cannot be instatntiate w/o implementing the method
// our base adapter should be flexible to accept GENERIC of obj list, (T as any object)
abstract class BaseRecyclerView<T>(
    //2. protected will visible in classes that extend or the child classes
    protected val masterList:  MutableList<T> = mutableListOf()
)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //3. only override some of the generic method which can be extended
    override fun getItemCount(): Int = masterList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BaseViewHolder<T>).onBind(masterList.get(position))
    }

    // need to add <E> bcs it should accept generic Viewholder obj (since T already used, then use any other word)
    abstract class BaseViewHolder<anyVH>(itemView: View) : RecyclerView.ViewHolder(itemView){
        // when passing the generic obj in the method, should add "type E"
        abstract fun onBind(data: anyVH)
    }
}