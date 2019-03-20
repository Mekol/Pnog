package com.mkl.pnog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout

class game1p : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)
        val layout = findViewById<ConstraintLayout>(R.id.constLay)
        val gameView = DrawView(this)
        layout.addView(gameView)
    }
}
