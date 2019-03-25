package com.mkl.pnog

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.View


class DrawView(context: Context, attrs: AttributeSet) : View(context, attrs) {


    var playerCollisionCounter = 0
    var add = 10
    val redrawHandler = Handler(Looper.getMainLooper())
    val redraw = object : Runnable {
        override fun run() {
            add++
            invalidate()
            redrawHandler.postDelayed(this, 33)
        }
    }

    lateinit var ball: Ball
    lateinit var pDown: Player
    lateinit var pUp: Player
    var secElapsed = 0
    val timerHandler = Handler()
    val secElapsedTimer = object : Runnable {

        override fun run() {
            secElapsed++
            timerHandler.postDelayed(this, 1000)
        }

    }

    init {


        redrawHandler.post(redraw)
        timerHandler.post(secElapsedTimer)
        Log.d("drawview", "$this.height , $this.width")


    }

    var X = width / 2
    var moveLeftDown = false
    var moveRightDown = false
    var moveLeftUp = false
    var moveRightUp = false
    var once = true
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var _height = height
        var _width = width
        //Log.d("redrv","redrawing")
        //Log.d("drawview","$this.height , $this.width")
        if (once) {
            ball = Ball(_height.toFloat(), _width.toFloat(), context, this)
            // ball.addParameters(secElapsed)

            pDown = Player(_height.toFloat(), _width.toFloat(), false)
            if (!ball.gametype1)
                pUp = Player(_height.toFloat(), _width.toFloat(), true)

            once = false
        }

        canvas?.drawRGB(255, 255, 255)
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        brush1.textSize = 20f
        canvas?.drawText(secElapsed.toString(), 100f, 100f, brush1)

        if (moveLeftDown && !moveRightDown) pDown.movement = -20
        if (!moveLeftDown && moveRightDown) pDown.movement = 20
        if (::pUp.isInitialized) {
            if (moveLeftUp && !moveRightUp) pUp.movement = -20
            if (!moveLeftUp && moveRightUp) pUp.movement = 20
        }

        pDown.update()
        if (::pUp.isInitialized) pUp.update()
        pDown.draw(canvas)
        if (::pUp.isInitialized) pUp.draw(canvas)

        ball.detectCollisionWithPlayer(pDown)
        ball.update()
        ball.checkEdges()
        ball.draw(canvas)


    }

}