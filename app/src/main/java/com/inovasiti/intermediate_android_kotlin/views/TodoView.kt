package com.inovasiti.intermediate_android_kotlin.views

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inovasiti.intermediate_android_kotlin.model.Todo
import kotlinx.android.synthetic.main.view_todo.view.*

//create a class, add overload constructor & extend the layout by passing the parameter
class TodoView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
) : ConstraintLayout(context, attrs, defStyleAttr) {
    /*
    * By adding these, we can remove duplicate override constructor
    *
    *  @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 1
    ) : ConstraintLayout(context, attrs, defStyleAttr)
    * */

//    constructor(context: Context?) : super(context) {}
//    constructor(context: Context?, attrs: AttributeSet?) : super(
//        context,
//        attrs
//    ) {
//    }
//    constructor(
//        context: Context?,
//        attrs: AttributeSet?,
//        defStyleAttr: Int
//    ) : super(context, attrs, defStyleAttr) {
//    }

    fun initView(todo: Todo, callback: (() -> Unit)? = null) {
        //need to set desc & textview & checkbox
        descTextView?.text = todo.description
        checkBox?.isChecked = todo.isComplete

        if (todo.isComplete) {
            createStrikeThrough()
        }
        setCheckStateListener(callback, todo)
    }

    //passing fun into a fun,
    // has 1 boolean / empty as parameter, return unit as void (in java),
    // setCheckStateListener(param), param: could be a fun or null, by def wont pass anything
    fun setCheckStateListener(
        callback: (() -> Unit)? = null,
        todo: Todo
    ) {
        //available in java 8
//        checkBox!!.setOnCheckedChangeListener { _, isChecked: Boolean -> }

        //if variable in listener was never be used, change to '_'
        //old
        checkBox?.setOnCheckedChangeListener { _, isChecked ->
            todo.isComplete = isChecked
            //if callback is not null, then call invoke isChecked boolean
            callback?.invoke()
            if (isChecked) {
                createStrikeThrough()
            } else {
                removeStrikeThrough()
            }
        }
    }

    /**
     * bitwise OR ( | ). It compares 2 bits and if EITHER ONE OR BOTH are true
     * bitwise inverse (~) : takes 1 bit, and flips every value (true -> false, false -> true)
     */
    private fun createStrikeThrough() {
        descTextView?.apply {
            //10101000 | 00000010 => 10101010
            paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThrough() {
        descTextView?.apply {
            //~(Paint.StrikeThrough) : 10101010 & 11111101 = 10101000
            paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}