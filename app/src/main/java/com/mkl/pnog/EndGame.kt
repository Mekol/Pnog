package com.mkl.pnog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_end_game.*

class EndGame : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_end_game)
        val b = intent.extras
        val secs = b.getInt("secs")
        val bounces = b.getInt("bounces")

        secsTextView.text = "Game time: $secs "
        pointsTextView.text = "Number of bounces: $bounces "
        ok_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)


        }


    }
}
