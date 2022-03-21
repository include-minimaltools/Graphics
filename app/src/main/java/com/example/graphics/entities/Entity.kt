package com.example.graphics.entities

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path

open class Entity(canvas: Canvas) {
    constructor() : this(Canvas())

    var canvas = canvas
    var initX = 0f
    var initY = 0f
    internal val paint = Paint()

    open fun draw() { }

    internal fun drawPolygon(points: FloatArray) {
        for(i in points.indices step 2) {
            if(i != points.size - 2)
                canvas.drawLine(points[i] + initX, points[i+1] + initY, points[i+2] + initX, points[i+3] + initY, paint)
        }
    }

    internal fun fillPolygon(points: FloatArray) {
        val path = Path()

        path.moveTo(0f, 0f)

        for(i in points.indices step 2) {
            path.lineTo(points[i] + initX, points[i + 1] + initY)
        }

        path.close()

        canvas.drawPath(path, paint)
    }
}