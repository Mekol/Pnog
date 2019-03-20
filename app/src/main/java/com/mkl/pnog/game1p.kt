package com.mkl.pnog

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import kotlinx.android.synthetic.main.activity_game1p.*

class game1p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)
        val layout = findViewById<ConstraintLayout>(R.id.constLay)
        val gameView = DrawView(this)
        layout.addView(gameView)

        button.setOnClickListener{
            gameView.test=true
            gameView.add+=10
            gameView.invalidate()
        }
    }
}
