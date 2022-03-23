package com.example.graphics.scenes

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.os.Handler
import android.util.DisplayMetrics
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
    private var scale: PointF = PointF(3.5f, 3f)
    private var kiritoPos: Point = Point(100, 180)

    private var btnBack: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 10f) }
        .apply { endPoint = PointF(830f, 60f) }
        .apply { text = "Menu Principal" }
        .apply { action = { finish() } }

    private var btnMode: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 70f) }
        .apply { endPoint = PointF(830f, 120f) }
        .apply { text = "Dia" }
        .apply { action = { isDay = !isDay } }

    private var btnKirito: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 130f) }
        .apply { endPoint = PointF(830f, 190f) }
        .apply { text = "Kirito" }
        .apply { action = { isKiritoVisible = !isKiritoVisible } }

    private var btnHome: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 200f) }
        .apply { endPoint = PointF(830f, 250f) }
        .apply { text = "Ir a casa" }
        .apply { action = { environment = Environment.ROOM } }

    private var btnTravel: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 260f) }
        .apply { endPoint = PointF(830f, 310f) }
        .apply { text = "Viajar" }
        .apply { action = { environment = Environment.EARTH } }

    private var btnKiritoLeft: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(660f, 320f) }
        .apply { endPoint = PointF(745f, 370f) }
        .apply { text = "<" }
        .apply { action = { kiritoMovement(Direction.LEFT) } }

    private var btnKiritoRight: ButtonEntity = ButtonEntity()
        .apply { initPoint = PointF(755f, 320f) }
        .apply { endPoint = PointF(830f, 370f) }
        .apply { text = ">" }
        .apply { action = { kiritoMovement(Direction.RIGHT) } }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        scale.x = 3.5f * display.width.toFloat() / 2960f
        scale.y = display.height.toFloat() / 480f
        canvas.scale(scale.x, scale.y)

        drawContainer(canvas)

        when(environment) {
            Environment.UNIVERSITY -> {
                val rusb = RusbEntity(canvas)
                rusb.isDay = isDay
                rusb.draw()
                btnHome.text = "Ir a Casa"
                btnHome.action = {
                    environment = Environment.ROOM
                    kiritoPos.y = 180
                }
            }
            Environment.EARTH -> {
                val earth = EarthEntity(canvas)
                earth.draw()

                btnTravel.text = "Viajar/Volver"
                btnTravel.action = {
                    if(environment == Environment.EARTH) {
                        environment = Environment.ROOM
                        kiritoPos.y = 180
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
                    kiritoPos.y = 140
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

        val mouse = PointF((event.x / scale.x), (event.y / scale.y))

        if(environment == Environment.UNIVERSITY)
            btnMode.onClick(mouse) { invalidate() }

        btnBack.onClick(mouse) { invalidate() }

        if(environment != Environment.EARTH)
        {
            btnKirito.onClick(mouse) { invalidate() }
            btnHome.onClick(mouse) { invalidate() }
        }


        btnTravel.onClick(mouse) { invalidate() }

        if(isKiritoVisible){
            btnKiritoLeft.onClick(mouse) { invalidate() }
            btnKiritoRight.onClick(mouse) { invalidate() }
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

        canvas.drawRect(640f,0f,845f,480f, paint)

        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 8f
        paint.style = Style.STROKE

        canvas.drawLine(640f, 0f, 640f, 480f, paint)

        canvas.drawLine(640f, 0f, 845f, 0f, paint)

        paint.strokeWidth = 5f
        paint.color = Color.WHITE
        canvas.drawLine(845f, 0f, 845f, 480f, paint)

        canvas.drawLine(640f, 480f, 845f, 480f, paint)
    }
}