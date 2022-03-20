package com.example.graphics.entities

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path

open class Entity(canvas: Canvas) {
    internal val canvas = canvas
    internal val paint = Paint()

    open fun draw() { }

    internal fun drawPolygon(points: FloatArray) {
        for(i in points.indices step 2) {
            if(i != points.size - 2)
                canvas.drawLine(points[i], points[i+1], points[i+2], points[i+3], paint)
        }
    }

    internal fun fillPolygon(points: FloatArray) {
        val path = Path()

        path.moveTo(0f, 0f)

        for(i in points.indices step 2) {
            path.lineTo(points[i], points[i + 1])
        }

        path.close()

        canvas.drawPath(path, paint)
    }
}