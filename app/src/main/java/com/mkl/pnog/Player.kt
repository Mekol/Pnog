package com.mkl.pnog

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

class Player(val parentHeight: Float, val parentWidth: Float) {

    val playerWidth = 150
    val playerHeight = 10
    lateinit var rect: Rect

    init {
        rect = Rect(
            ((parentWidth - playerWidth) / 2).toInt(),
            (parentHeight - playerHeight - 30).toInt(),
            (((parentWidth - playerWidth) / 2) + playerWidth).toInt(), (parentHeight - playerHeight).toInt()
        )

    }

    fun reset() {

    }

    fun update() {

    }

    fun draw(canvas: Canvas?) {
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        canvas?.drawRect(rect, brush1)
    }

}