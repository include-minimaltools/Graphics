package com.example.graphics.scenes

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.KiritoEntity

open class BaseScene(context: Context, finish: () -> Unit, setScene: (String) -> Unit): View(context) {
    enum class Direction {
        LEFT, RIGHT, UP, DOWN
    }
    internal var scale: PointF = PointF(1f, 1f)
    internal var isPlayerVisible = false
    internal var playerPosition = PointF(100f, 200f)
    internal var interfaceButtons: MutableList<ButtonEntity> = mutableListOf(
        ButtonEntity().apply {
            text = "Menu Principal"
            action = { finish() }
            isVisible = true
        },
        ButtonEntity().apply {
            text = "Creditos"
            action = { setScene(PresentationScene::class.java.simpleName) }
            isVisible = true
        },
        ButtonEntity().apply {
            text = "Jugador"
            action = {
                isGameButtonsVisible = !isPlayerVisible
                isPlayerVisible = !isPlayerVisible
            }
            isVisible = true
        }
    )
    internal var isGameButtonsVisible = false
    internal var gameButtons = listOf(
        ButtonEntity().apply {
            initPoint = PointF(660f, 420f)
            endPoint = PointF(710f, 470f)
            text = "<"
            action = { playerMovement(Direction.LEFT) }
        },
        ButtonEntity().apply {
            initPoint = PointF(780f, 420f)
            endPoint = PointF(830f, 470f)
            text = ">"
            action = { playerMovement(Direction.RIGHT) }
        },
        ButtonEntity().apply {
            initPoint = PointF(720f, 420f)
            endPoint = PointF(770f, 470f)
            text = "V"
            action = { playerMovement(Direction.DOWN) }
        },
        ButtonEntity().apply {
            initPoint = PointF(720f, 360f)
            endPoint = PointF(770f, 410f)
            text = "^"
            action = { playerMovement(Direction.UP) }
        }
    )

    init {
        scale = PointF(
            context.resources.displayMetrics.widthPixels.toFloat() * 3.5f / 2960f,
            context.resources.displayMetrics.heightPixels.toFloat() / 480f
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.scale(scale.x, scale.y)
        drawInterface(canvas)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val mouse = PointF(event.x / scale.x, event.y / scale.y)

        interfaceButtons.forEach {
            if(it.isVisible)
                it.onClick(mouse) { invalidate() }
        }

        if(isPlayerVisible)
            gameButtons.forEach {
                it.onClick(mouse) { invalidate() }
            }

        return super.onTouchEvent(event)
    }

    internal fun drawPlayer(canvas: Canvas) {
        if(isGameButtonsVisible) {
            val player = KiritoEntity(canvas, playerPosition)
            player.draw()
        }
    }

    internal fun drawInterface(canvas: Canvas) {
        val paint = Paint().apply { isAntiAlias = true }

        paint.color = Color.parseColor("#BAE9EE")
        paint.style = Paint.Style.FILL

        canvas.drawRect(640f,0f,845f,480f, paint)

        paint.color = Color.BLACK
        paint.strokeWidth = 8f
        paint.style = Paint.Style.STROKE

        canvas.drawLine(640f, 0f, 640f, 480f, paint)
        canvas.drawLine(640f, 0f, 845f, 0f, paint)

        paint.strokeWidth = 5f
        paint.color = Color.WHITE
        canvas.drawLine(845f, 0f, 845f, 480f, paint)
        canvas.drawLine(640f, 480f, 845f, 480f, paint)


        var buttonPosY = 10f
        interfaceButtons.forEach { button ->
            if(!button.isVisible)
                return@forEach

            button.canvas = canvas
            button.initPoint = PointF(660f, buttonPosY)
            button.endPoint = PointF(830f, buttonPosY + 50)
            button.draw()

            buttonPosY += 60
        }

        if(isGameButtonsVisible) {
            gameButtons.forEach { button ->
                button.canvas = canvas
                button.draw()
            }
        }
    }

    fun playerMovement(direction: Direction){
        when(direction){
            Direction.LEFT -> {
                if(playerPosition.x > 0) {
                    ValueAnimator().apply{
                        setFloatValues(playerPosition.x, playerPosition.x - 20)
                        addUpdateListener {
                            playerPosition.x = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 500
                    }.start()
                }
            }
            Direction.RIGHT -> {
                if(playerPosition.x < 540)
                    ValueAnimator().apply{
                        setFloatValues(playerPosition.x, playerPosition.x + 20)
                        addUpdateListener {
                            playerPosition.x = it.animatedValue as Float
                            invalidate()
                        }
                        duration = 500
                    }.start()
            }
            //Direction.UP -> playerPosition = PointF(playerPosition.x, playerPosition.y - 10)
            //Direction.DOWN -> playerPosition = PointF(playerPosition.x, playerPosition.y + 10)
        }
    }
}