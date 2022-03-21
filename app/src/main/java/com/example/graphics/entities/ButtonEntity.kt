package com.example.graphics.entities

import android.graphics.*
import android.graphics.Paint.Style
import android.os.Handler
import android.view.MotionEvent

class ButtonEntity: Entity() {
    var initPoint: Point = Point(0, 0)
    var endPoint:Point = Point(0, 0)
    var text: String = ""
    var isPressed = false
    var action: () -> Unit = {}
    var delay: Long = 200

    override fun draw() {

        paint.color = Color.LTGRAY
        paint.style = Style.FILL
        canvas.drawRect(initPoint.x.toFloat(), initPoint.y.toFloat(), endPoint.x.toFloat(), endPoint.y.toFloat(), paint)

        if(isPressed)
            paint.color = Color.BLACK
        else
            paint.color = Color.WHITE

        paint.style = Style.STROKE
        paint.strokeWidth = 3f
        drawPolygon(
            floatArrayOf(
                initPoint.x.toFloat(),
                endPoint.y.toFloat(),
                initPoint.x.toFloat(),
                initPoint.y.toFloat(),
                endPoint.x.toFloat(),
                initPoint.y.toFloat(),
            )
        )

        if(isPressed)
            paint.color = Color.WHITE
        else
            paint.color = Color.BLACK

        paint.style = Style.STROKE
        drawPolygon(
            floatArrayOf(
                initPoint.x.toFloat(),
                endPoint.y.toFloat(),
                endPoint.x.toFloat(),
                endPoint.y.toFloat(),
                endPoint.x.toFloat(),
                initPoint.y.toFloat(),
            )
        )

        paint.strokeWidth = 2f
        paint.textSize = 20f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, (initPoint.x + endPoint.x).toFloat() / 2, (initPoint.y + endPoint.y).toFloat() / 2 + 5, paint)
    }

    fun onClick(mouse: Point, event: MotionEvent, invalid: () -> Unit) {
        if(event == null)
            return

        if(!(mouse.x in initPoint.x .. endPoint.x && mouse.y in initPoint.y .. endPoint.y))
            return

        isPressed = true
        invalid()

        val handler = Handler()
        handler.postDelayed({
            isPressed = false
            invalid()
            action()
        }, delay)
    }
}