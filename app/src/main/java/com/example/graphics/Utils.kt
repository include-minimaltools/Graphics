package com.example.graphics

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path

class Utils {
    companion object {
        fun drawPolygon(canvas: Canvas, paint: Paint, points: FloatArray) {
            for(i in points.indices step 2) {
                if(i != points.size - 2)
                    canvas.drawLine(points[i], points[i+1], points[i+2], points[i+3], paint)
            }
        }

        fun fillPolygon(canvas: Canvas, paint: Paint, points: FloatArray) {
            val path = Path()

            path.moveTo(0f, 0f)

            for(i in points.indices step 2) {
                path.lineTo(points[i], points[i + 1])
            }

            path.close()

            canvas.drawPath(path, paint)
        }

    }
    class ArrayPath(points: FloatArray) : Path() {
        init {
            moveTo(0f, 0f)
            for (i in points.indices step 2) {
                lineTo(points[i], points[i + 1])
            }
            close()
        }
    }
}