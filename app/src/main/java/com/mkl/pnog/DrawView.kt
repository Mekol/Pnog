package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.security.AccessControlContext

class DrawView(context: Context,attrs: AttributeSet) : View(context,attrs) {

val paint = Paint()




    init {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }
}