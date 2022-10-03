package com.ej.hiltlecture.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ej.hiltlecture.R
import com.ej.hiltlecture.ui.data.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository : MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}