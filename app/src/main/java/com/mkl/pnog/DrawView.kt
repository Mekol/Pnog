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
    var ball = Ball(this.height, this.width)

    init {

        redraw.run()
        Log.d("drawview", "$this.height , $this.width")


    }

    var X = width / 2
    var moveLeft = false
    var moveRight = false
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //Log.d("redrv","redrawing")
        //Log.d("drawview","$this.height , $this.width")

        canvas?.drawRGB(255, 255, 255)

        val _height = height
        Log.d("height tag:", "$_height")
        val brush1 = Paint()
        brush1.setARGB(255, 255, 0, 0)
        brush1.style = Paint.Style.STROKE
        if (moveLeft == true && moveRight == false) X -= 10
        if (moveLeft == false && moveRight == true) X += 10

        canvas?.drawCircle(
            X.toFloat(),
            (_height / 2).toFloat(),
            300f,
            brush1
        )


        ball.update()
        ball.checkEdges()
        ball.draw(canvas)


    }
///https://stackoverflow.com/questions/3591784/views-getwidth-and-getheight-returns-0
//    fun <T : View> T.height(function: (Int) -> Unit) {
//        if (height == 0)
//            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                override fun onGlobalLayout() {
//                    viewTreeObserver.removeOnGlobalLayoutListener(this)
//                    function(height)
//                }
//            })
//        else function(height)
//    }
//    fun <T : View> T.width(function: (Int) -> Unit) {
//        if (width == 0)
//            viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                override fun onGlobalLayout() {
//                    viewTreeObserver.removeOnGlobalLayoutListener(this)
//                    function(width)
//                }
//            })
//        else function(width)
//    }
}