package com.mkl.pnog

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_game1p.*

class game1p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)

        val gameView = findViewById<DrawView>(R.id.dV)


//        buttonLeft.setOnClickListener {
//            //gameView.test = true
//            gameView.add += 10
//
//        }
        buttonLeft.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveLeft = true
                    // gameView.X = gameView.X - 10
                    Log.d("x", gameView.X.toString())
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveLeft = false
                }

            }
            return@OnTouchListener true
        })

        buttonRight.setOnTouchListener(View.OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    gameView.moveRight = true
                    // gameView.X = gameView.X + 10
                }
                MotionEvent.ACTION_UP -> {
                    gameView.moveRight = false
                }

            }
            return@OnTouchListener true
        })

    }
}
