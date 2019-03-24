package com.mkl.pnog

import android.graphics.Canvas
import android.graphics.Paint
import android.util.Log
import java.lang.Math.random
import kotlin.math.cos
import kotlin.math.sin

class Ball(val parentHeight: Float, val parentWidth: Float) {

    var xPos = 500f
    var yPos = 100f
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

        xSpeed = (10 * cos(random().toFloat()))
        ySpeed = (10 * sin(random().toFloat()))
    }

    fun update() {
        xPos += xSpeed
        yPos += ySpeed
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
        Log.d("edge", "$xPos $yPos    $parentWidth")
        if (xPos < 0 + radius + 29 || xPos > parentWidth - radius - 29) {
            xSpeed *= -1
            Log.d("edge", "edge")
        }
        if (yPos < 0 + radius || yPos > parentHeight - radius) {
            ySpeed *= -1
            Log.d("edge", "edge")
        }
    }
}