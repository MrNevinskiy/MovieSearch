package com.example.moviesearch.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.moviesearch.R

class MainActivity : AppCompatActivity(R.layout.main_activity){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_graph) as NavHostFragment
        navHostFragment.navController
    }
}