package com.inovasiti.intermediate_android_kotlin.create

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.inovasiti.intermediate_android_kotlin.BottomNavigationActivity
import com.inovasiti.intermediate_android_kotlin.R
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        titleTv.text = if(intent.getStringExtra(BottomNavigationActivity.FRAG_TYPE_KEY)== BottomNavigationActivity.FRAGM_VALUE_TASK){
           "This is Task"
       } else if(intent.getStringExtra(BottomNavigationActivity.FRAG_TYPE_KEY)== BottomNavigationActivity.FRAG_VALUE_NOTE){
           "This is Note"
       } else
            "This is Note"
    }
}