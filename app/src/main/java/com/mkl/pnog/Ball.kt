package com.mkl.pnog

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import kotlin.math.cos
import kotlin.math.sin

class Ball(val parentHeight: Int, val parentWidth: Int) {

    var xPos = 500
    var yPos = 100
    var ySpeed = 0f
    var xSpeed = 0f
    var radius = 20


    init {
        reset()
        Log.d("ball init", "$parentHeight     $parentWidth")
    }

    fun reset() {
        xPos = parentWidth / 2
        yPos = parentHeight / 2
        xSpeed = (5 * cos(0f))
        ySpeed = (5 * sin(0f))
    }

    fun update() {
        xPos += xSpeed.toInt()
        yPos += ySpeed.toInt()
    }

    fun draw(canvas: Canvas?) {
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        canvas?.drawCircle(
            xPos.toFloat(),
            yPos.toFloat(),
            radius.toFloat(),
            brush1
        )
    }

    fun checkEdges() {
        if (yPos < 0 || yPos > parentHeight) {
            ySpeed *= -1
            Log.d("edge", "edge")
        }
    }
}