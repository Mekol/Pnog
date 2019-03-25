package com.mkl.pnog

import android.app.Activity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_game2p.*

class Game2p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2p)
        val gameView = findViewById<DrawView>(R.id.dV)
        gameView.tag = "2"


        buttonLeftDown2.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveLeftDown = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveLeftDown = false
                }
            }
            return@OnTouchListener true
        })

        buttonRightDown2.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveRightDown = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveRightDown = false
                }

            }
            return@OnTouchListener true
        })

        buttonLeftUp.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveLeftUp = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveLeftUp = false
                }
            }
            return@OnTouchListener true
        })

        buttonRightUp.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveRightUp = true
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveRightUp = false
                }

            }
            return@OnTouchListener true
        })


    }
}
