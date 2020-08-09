package com.inovasiti.intermediate_android_kotlin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inovasiti.intermediate_android_kotlin.create.CreateActivity
import com.inovasiti.intermediate_android_kotlin.ui.note.NoteListFragment
import com.inovasiti.intermediate_android_kotlin.ui.task.TaskListFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() , TaskListFragment.TouchActionCallback, NoteListFragment.TouchActionCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_dashboard
        ).build()

        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)

        textView.text = when (appBarConfiguration.topLevelDestinations.size) {
            1 -> "Hello"
            2 -> "Geng!"
            else -> "ASDASD"
        }

    }

    private fun goToCreateActivity(fragmentVal: String){
//        val intent : Intent = Intent(this, CreateActivity::class.java)
        startActivity(Intent(this, CreateActivity::class.java).apply {
            putExtra(FRAG_TYPE_KEY,fragmentVal)
        })
    }

    override fun onAddButtonClicked(value: String) {
        goToCreateActivity(value)
    }

    companion object{
        const val FRAG_TYPE_KEY = "f_t_k"

        const val FRAG_VALUE_NOTE = "f_v_n"
        const val FRAGM_VALUE_TASK = "f_v_t"
    }


}