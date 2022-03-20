package com.example.graphics.scenes

import android.content.Context
import android.graphics.Matrix
import android.graphics.Paint
import android.view.View
import com.example.graphics.entities.KiritoEntity
import com.example.graphics.entities.RusbEntity

class TempScene (context: Context): View(context) {
    override fun onDraw(canvas: android.graphics.Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val matrix = Matrix()

        val scalex = 4.65f
        val scaley = 3.5f
        canvas.scale(4.65f,3.5f)

        val rusb = RusbEntity(canvas)
        val kirito = KiritoEntity(canvas)
        rusb.draw()

        matrix.setTranslate(200f, 250f)
        canvas.concat(matrix)
        kirito.draw()
    }
}