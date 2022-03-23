package com.example.graphics.scenes

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import com.example.graphics.entities.AirplaneEntity
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.EarthEntity

class EarthScene(context: Context, finish: () -> Unit, setScene: (String) -> Unit) : BaseScene(context, finish, setScene) {
    private var airplanePosition: PointF = PointF(200f, 170f)
    private var currentStatus: AirplaneEntity.State = AirplaneEntity.State.UP
    init {
        interfaceButtons.add(ButtonEntity().apply {
            text = "Volver"
            action = { setScene(RoomScene::class.java.simpleName) }
        })

        val newActions = arrayOf(
            { setAirplanePosition(AirplaneEntity.State.LEFT) },
            { setAirplanePosition(AirplaneEntity.State.RIGHT) },
            { setAirplanePosition(AirplaneEntity.State.DOWN) },
            { setAirplanePosition(AirplaneEntity.State.UP) }
        )

        interfaceButtons[2].text = "Despegar"
        interfaceButtons[2].action = {
            isGameButtonsVisible = true
            isPlayerVisible = true
            interfaceButtons[2].isVisible = false
            interfaceButtons[3].text = "Aterrizar"

        }

        gameButtons.forEachIndexed { index, button ->
            button.action = newActions[index]
        }
    }

    override fun onDraw(canvas: Canvas) {
        interfaceButtons.last().isVisible = airplanePosition.x in 200f..250f && airplanePosition.y in 170f..210f
        super.onDraw(canvas)

        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = 0xFF000000.toInt()

        canvas.drawRect(0f, 0f, 640f, 480f, paint)

        val earth = EarthEntity(canvas, PointF(90f, 0f))
        earth.draw()


        val airplane = AirplaneEntity(canvas, airplanePosition)
        if(isGameButtonsVisible) {
            airplane.airplaneState = currentStatus
            airplane.draw()
        }

        paint.style = Paint.Style.STROKE
        paint.color = Color.RED
        paint.strokeWidth = 3f
        canvas.drawRect(200f, 160f, 250f, 210f, paint)
    }

    private fun setAirplanePosition(airplaneState: AirplaneEntity.State) {
        currentStatus = airplaneState
         when (airplaneState) {
            AirplaneEntity.State.UP -> {
                if(airplanePosition.y > 0) {
                    var animator = ValueAnimator().apply {
                        setFloatValues(airplanePosition.y, 0f)
                        addUpdateListener {
                            airplanePosition.y = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 10000
                    }
                    animator.start()
                }
            }
            AirplaneEntity.State.DOWN -> {
                if(airplanePosition.y < 440) {
                    var animator = ValueAnimator().apply {
                        setFloatValues(airplanePosition.y, 440f)
                        addUpdateListener {
                            airplanePosition.y = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 10000
                    }
                    animator.start()
                }
            }
            AirplaneEntity.State.LEFT -> {
                if(airplanePosition.x > 90) {
                    var animator = ValueAnimator().apply {
                        setFloatValues(airplanePosition.x, 90f)
                        addUpdateListener {
                            airplanePosition.x = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 10000
                    }
                    animator.start()
                }
            }
            AirplaneEntity.State.RIGHT -> {
                if(airplanePosition.x < 550) {
                    var animator = ValueAnimator().apply {
                        setFloatValues(airplanePosition.x, 550f)
                        addUpdateListener {
                            airplanePosition.x = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 10000
                    }
                    animator.start()
                }
            }
        }
    }
}