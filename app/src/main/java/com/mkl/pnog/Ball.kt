package com.mkl.pnog

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle

import android.util.Log
import java.lang.Math.random
import kotlin.math.cos
import kotlin.math.sin

class Ball(
    val parentHeight: Float,
    val parentWidth: Float,
    val context: Context,
    var parent: DrawView
) {


    var xPos = 0f
    var yPos = 0f
    var ySpeed = 0f
    var xSpeed = 0f
    var radius = 20
    var gametype1 = false

    init {
        reset()
        Log.d("ball init", "$parentHeight     $parentWidth")
        gametype1 = parent.tag.toString().equals("1")
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
        brush1.style = Paint.Style.FILL_AND_STROKE
        canvas?.drawCircle(
            xPos,
            yPos,
            radius.toFloat(),
            brush1
        )
    }

    fun checkEdges() {
        Log.d("edge", "$xPos $yPos    $parentWidth")
        if (xPos < 0 + radius || xPos > parentWidth - radius) {
            xSpeed *= -1

        }
        if ((yPos < 0 + radius) || yPos > parentHeight - radius) {
            if (yPos < 0 + radius && gametype1) {
                ySpeed *= -1
                return
            }
            // ySpeed *= -1
            parent.redrawHandler.removeCallbacks(null)
            val intent = Intent(context, EndGame::class.java)
            var b = Bundle()
            b.putInt("secs", parent.secElapsed)
            b.putInt("bounces", parent.playerCollisionCounter)
            intent.putExtras(b)

            context.startActivity(intent)


        }
    }

    fun detectCollisionWithPlayer(p: Player) {
        if (xPos > p.rect.left && xPos < p.rect.right && yPos + radius > p.rect.top) {
            xSpeed *= -1
            ySpeed *= -1
            parent.playerCollisionCounter++
        }

    }
}