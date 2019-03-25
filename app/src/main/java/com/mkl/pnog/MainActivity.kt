package com.mkl.pnog

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1p.setOnClickListener {
            val intent = Intent(this, Game1p::class.java)
            startActivity(intent)
        }

        button2p.setOnClickListener {
            val intent = Intent(this, Game2p::class.java)
            startActivity(intent)
        }

        buttonExit.setOnClickListener {
            finish()
            System.exit(0)
        }
    }

}
