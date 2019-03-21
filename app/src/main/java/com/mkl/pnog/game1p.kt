package com.mkl.pnog

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game1p.*

class game1p : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1p)

        val gameView = findViewById<DrawView>(R.id.dV)


        buttonLeft.setOnClickListener {
            gameView.test = true
            gameView.add += 10
            // gameView.invalidate()
        }

    }
}
