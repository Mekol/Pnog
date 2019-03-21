package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.security.AccessControlContext

class DrawView(context: Context, attrs: AttributeSet) : View(context,attrs) {
    var test = false
    var add = 10;





    init {

    }

    override fun onDraw(canvas: Canvas?) {
       // super.onDraw(canvas)
        if(test) {
            canvas?.drawRGB(255, 255, 255)
            val width = getWidth()
            val hieght = getHeight()
            val brush1 = Paint()
            brush1.setARGB(255, 255, 0, 0)
            brush1.setStyle(Paint.Style.STROKE)
            for (f in 0..9)
                canvas?.drawCircle((width / 2).toFloat()+add, (hieght / 2).toFloat()+add, (f * 15).toFloat(), brush1)

            canvas?.drawPoint(Math.random().toFloat() * width, Math.random().toFloat() * height, brush1)
        }
    }
}