package com.example.graphics.scenes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.os.Handler
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import com.example.graphics.entities.*

class TempScene (context: Context, finish: () -> Unit): View(context) {

    enum class Direction {
        LEFT, RIGHT, UP, DOWN
    }
    enum class Environment {
        UNIVERSITY, EARTH, ROOM
    }

    private var environment: Environment = Environment.ROOM
    private var isKiritoVisible: Boolean = false
    private var isDay: Boolean = false
    private var scale: Float = 3.5f
    private var kiritoPos: Point = Point(100, 140)

    private var btnBack: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 10) }
        .apply { endPoint = Point(830, 60) }
        .apply { text = "Menu Principal" }
        .apply { action = { finish() } }

    private var btnMode: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 70) }
        .apply { endPoint = Point(830, 120) }
        .apply { text = "Dia" }
        .apply { action = { isDay = !isDay } }

    private var btnKirito: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 130) }
        .apply { endPoint = Point(830, 190) }
        .apply { text = "Kirito" }
        .apply { action = { isKiritoVisible = !isKiritoVisible } }

    private var btnHome: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 200) }
        .apply { endPoint = Point(830, 250) }
        .apply { text = "Ir a casa" }
        .apply { action = { environment = Environment.ROOM } }

    private var btnTravel: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 260) }
        .apply { endPoint = Point(830, 310) }
        .apply { text = "Viajar" }
        .apply { action = { environment = Environment.EARTH } }

    private var btnKiritoLeft: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(660, 320) }
        .apply { endPoint = Point(745, 370) }
        .apply { text = "<" }
        .apply { action = { kiritoMovement(Direction.LEFT) } }

    private var btnKiritoRight: ButtonEntity = ButtonEntity()
        .apply { initPoint = Point(755, 320) }
        .apply { endPoint = Point(830, 370) }
        .apply { text = ">" }
        .apply { action = { kiritoMovement(Direction.RIGHT) } }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: android.graphics.Canvas) {
        super.onDraw(canvas)

        canvas.scale(scale, scale)

        drawContainer(canvas)

        when(environment) {
            Environment.UNIVERSITY -> {
                val rusb = RusbEntity(canvas)
                rusb.isDay = isDay
                rusb.draw()
                btnHome.text = "Ir a Casa"
                btnHome.action = {
                    environment = Environment.ROOM
                    kiritoPos.y = 140
                }
            }
            Environment.EARTH -> {
                val earth = EarthEntity(canvas)
                earth.draw()

                btnTravel.text = "Viajar/Volver"
                btnTravel.action = {
                    if(environment == Environment.EARTH) {
                        environment = Environment.ROOM
                        kiritoPos.y = 140
                    } else
                        environment = Environment.EARTH
                }
            }
            Environment.ROOM -> {
                val room = RoomEntity(canvas)
                room.draw()
                btnHome.text = "Ir a la UNI"
                btnHome.action = {
                    environment = Environment.UNIVERSITY
                    kiritoPos.y = 120
                }
            }
        }

        val kirito = KiritoEntity(canvas, kiritoPos.x.toFloat(), kiritoPos.y.toFloat())
        if(isKiritoVisible && environment != Environment.EARTH) {
            btnKiritoLeft.draw()
            btnKiritoRight.draw()
            kirito.draw()
        }

        btnBack.canvas = canvas
        btnMode.canvas = canvas
        btnKirito.canvas = canvas
        btnHome.canvas = canvas
        btnTravel.canvas = canvas
        btnKiritoLeft.canvas = canvas
        btnKiritoRight.canvas = canvas

        if(isDay)
            btnMode.text = "Noche"
        else
            btnMode.text = "Dia"

        btnBack.draw()
        if(environment == Environment.UNIVERSITY)
            btnMode.draw()

        if(environment != Environment.EARTH)
            btnKirito.draw()

        btnTravel.draw()

        if(environment != Environment.EARTH) {
            btnHome.draw()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event == null)
            return super.onTouchEvent(event)

        val mouse = Point((event!!.x / scale).toInt(), (event.y / scale).toInt())

        if(environment == Environment.UNIVERSITY)
            btnMode.onClick(mouse, event) { invalidate() }

        btnBack.onClick(mouse, event) { invalidate() }

        if(environment != Environment.EARTH)
        {
            btnKirito.onClick(mouse, event) { invalidate() }
            btnHome.onClick(mouse, event) { invalidate() }
        }


        btnTravel.onClick(mouse, event) { invalidate() }

        if(isKiritoVisible){
            btnKiritoLeft.onClick(mouse, event) { invalidate() }
            btnKiritoRight.onClick(mouse, event) { invalidate() }
        }
        return super.onTouchEvent(event)
    }

    private fun kiritoMovement(direction: Direction){
        when(direction){
            Direction.LEFT -> {
                if(kiritoPos.x > 0)
                    kiritoPos.x -= 10
            }
            Direction.RIGHT -> {
                if(kiritoPos.x < 540)
                    kiritoPos.x += 10
            }
            Direction.UP -> kiritoPos = Point(kiritoPos.x, kiritoPos.y - 10)
            Direction.DOWN -> kiritoPos = Point(kiritoPos.x, kiritoPos.y + 10)
        }
    }

    private fun drawContainer(canvas: Canvas)
    {
        val paint = Paint()

        paint.color = Color.parseColor("#BAE9EE")
        paint.style = Style.FILL

        canvas.drawRect(640f,0f,845f,410f, paint)

        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 8f
        paint.style = Style.STROKE

        canvas.drawLine(640f, 0f, 640f, 410f, paint)

        canvas.drawLine(640f, 0f, 845f, 0f, paint)

        paint.strokeWidth = 5f
        paint.color = Color.WHITE
        canvas.drawLine(845f, 0f, 845f, 410f, paint)

        canvas.drawLine(640f, 410f, 845f, 410f, paint)
    }
}