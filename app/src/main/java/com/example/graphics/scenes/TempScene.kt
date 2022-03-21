package com.example.graphics.scenes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Point
import android.os.Handler
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.KiritoEntity
import com.example.graphics.entities.RusbEntity

class TempScene (context: Context, finish: () -> Unit): View(context) {
    var isFirstDraw = true
    var isKiritoVisible = true
    var isDay = false
    var scale = 3.5f
    var kiritoPos = Point(100, 120)

    var btnBack: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 10) }
        .apply { endPoint = Point(830, 60) }
        .apply { text = "Menu Principal" }
        .apply { action = { finish() } }

    var btnMode: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 70) }
        .apply { endPoint = Point(830, 120) }
        .apply {
            text = if(isDay) "Noche" else "Día"
        }
        .apply { action = { isDay = !isDay } }

    var btnKirito: ButtonEntity = ButtonEntity().apply {
            initPoint = Point(660, 130)
            endPoint = Point(830, 190)
            text = "Kirito"
            action = { isKiritoVisible = !isKiritoVisible }
        }

    var btnKiritoLeft: ButtonEntity = ButtonEntity().apply {
        initPoint = Point(660, 200)
        endPoint = Point(745, 250)
        text = "<"
        action = { kiritoPos = Point(kiritoPos.x - 10, kiritoPos.y) }
    }

    var btnKiritoRight: ButtonEntity = ButtonEntity().apply {
        initPoint = Point(755, 200)
        endPoint = Point(830, 250)
        text = ">"
        action = { kiritoPos = Point(kiritoPos.x + 10, kiritoPos.y) }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: android.graphics.Canvas) {
        super.onDraw(canvas)

        canvas.scale(scale, scale)

        val rusb = RusbEntity(canvas)
        rusb.isDay = isDay
        rusb.draw()

        val kirito = KiritoEntity(canvas, kiritoPos.x.toFloat(), kiritoPos.y.toFloat())
        if(isKiritoVisible){
            btnKiritoLeft.draw()
            btnKiritoRight.draw()
            kirito.draw()
        }



        btnBack.canvas = canvas
        btnMode.canvas = canvas
        btnKirito.canvas = canvas
        btnKiritoLeft.canvas = canvas
        btnKiritoRight.canvas = canvas


        btnBack.draw()
        btnMode.draw()
        btnKirito.draw()


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event == null)
            return false

        val mouse = Point((event!!.x / scale).toInt(), (event.y / scale).toInt())


        // Buttons
        btnBack.onClick(mouse, event) { invalidate() }
        btnMode.onClick(mouse, event) { invalidate() }
        btnKirito.onClick(mouse, event) { invalidate() }
        btnKiritoLeft.onClick(mouse, event) { invalidate() }
        btnKiritoRight.onClick(mouse, event) { invalidate() }

        return super.onTouchEvent(event)
    }

    fun Back_Click() {
        println("Back_Click")
    }

}