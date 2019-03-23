package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View

class DrawView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    var test = true
    var add = 10
    val redrawHandler = Handler(Looper.getMainLooper())
    val redraw = object : Runnable {
        override fun run() {
            add++
            invalidate()
            redrawHandler.postDelayed(this, 33)
        }
    }

    init {
        redraw.run()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (test) {
            canvas?.drawRGB(255, 255, 255)
            val width = width
            val hieght = height
            val brush1 = Paint()
            brush1.setARGB(255, 255, 0, 0)
            brush1.style = Paint.Style.STROKE
            for (f in 0..9)
                canvas?.drawCircle(
                    (width / 2).toFloat() + add,
                    (hieght / 2).toFloat() + add,
                    (f * 15).toFloat(),
                    brush1
                )

            canvas?.drawPoint(Math.random().toFloat() * width, Math.random().toFloat() * height, brush1)
        }
    }
}