package com.mkl.pnog

import android.app.Activity

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        

        buttonExit.setOnClickListener{
            finish()
            System.exit(0)
        }
    }

}
