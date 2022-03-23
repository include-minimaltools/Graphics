package com.example.graphics.entities

import android.graphics.*
import android.graphics.Paint.Style
import android.os.Handler
import android.view.MotionEvent

class ButtonEntity: Entity() {
    var initPoint: PointF = PointF(0f, 0f)
    var endPoint:PointF = PointF(0f, 0f)
    var isVisible = true
    var text: String = ""
    var isPressed = false
    var action: () -> Unit = {}
    var delay: Long = 200

    override fun draw() {
        if(!isVisible) return


        println("draw pressed: $isPressed")
        paint.color = Color.LTGRAY
        paint.style = Style.FILL
        canvas.drawRect(initPoint.x, initPoint.y, endPoint.x, endPoint.y, paint)

        if(isPressed)
            paint.color = Color.BLACK
        else
            paint.color = Color.WHITE

        paint.style = Style.STROKE
        paint.strokeWidth = 3f
        drawPolygon(
            floatArrayOf(
                initPoint.x,
                endPoint.y,
                initPoint.x,
                initPoint.y,
                endPoint.x,
                initPoint.y,
            )
        )

        if(isPressed)
            paint.color = Color.WHITE
        else
            paint.color = Color.BLACK

        paint.style = Style.STROKE
        drawPolygon(
            floatArrayOf(
                initPoint.x,
                endPoint.y,
                endPoint.x,
                endPoint.y,
                endPoint.x,
                initPoint.y,
            )
        )

        paint.strokeWidth = 2f
        paint.textSize = 20f
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, (initPoint.x + endPoint.x) / 2, (initPoint.y + endPoint.y) / 2 + 5, paint)
    }

    fun onClick(mouse: PointF, invalidate: () -> Unit) {
        if(!(mouse.x in initPoint.x .. endPoint.x && mouse.y in initPoint.y .. endPoint.y))
            return

        isPressed = true
        invalidate()

        val handler = Handler()
        handler.postDelayed({
            isPressed = false
            invalidate()
            action()
        }, delay)
    }
}