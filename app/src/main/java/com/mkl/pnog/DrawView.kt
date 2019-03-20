package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.security.AccessControlContext

class DrawView(context: Context) : View(context) {

val paint = Paint()




    init {

    }

    override fun onDraw(canvas: Canvas?) {
       // super.onDraw(canvas)
        canvas?.drawRGB (255, 255, 255)
        val width = getWidth ()
        val hieght = getHeight ()
        val brush1 = Paint ()
        brush1.setARGB (255, 255, 0, 0)
        brush1.setStyle (Paint.Style.STROKE)
        for (f in 0..9)
            canvas?.drawCircle ((width / 2) .toFloat (), (hieght / 2) .toFloat (), (f * 15) .toFloat (), brush1)
    }
}