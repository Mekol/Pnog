package com.mkl.pnog

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_game1p.*

class game1p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)

        val gameView = findViewById<DrawView>(R.id.dV)

        buttonLeftDown.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveLeft = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveLeft = false
                }
            }
            return@OnTouchListener true
        })

        buttonRightDown.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveRight = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveRight = false
                }

            }
            return@OnTouchListener true
        })

    }
}
