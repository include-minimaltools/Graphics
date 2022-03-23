package com.example.graphics.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF

class AirplaneEntity(canvas: Canvas) : Entity(canvas) {
    constructor(canvas:Canvas, position: PointF) : this(canvas) {
        this.canvas = canvas
        this.initY = position.y
        this.initX = position.x
    }

    private val AirplaneCoordinates = arrayOf(
        floatArrayOf(11f, 1f, 12f, 0f, 13f, 0f, 14f, 1f, 14f, 8f, 25f, 14f, 25f, 16f, 14f, 13f, 14f, 21f, 17f, 24f, 8f, 24f, 11f, 21f, 11f, 13f, 0f, 16f, 0f, 14f, 11f, 8f, 11f, 1f),
        floatArrayOf(0f, 12f, 1f, 11f, 8f, 11f, 14f, 0f, 16f, 0f, 13f, 11f, 21f, 11f, 24f, 8f, 24f, 17f, 21f, 14f, 13f, 14f, 16f, 25f, 14f, 25f, 8f, 14f, 1f, 14f, 0f, 13f, 0f, 12f),
        floatArrayOf(12f, 24f, 11f, 23f, 11f, 16f, 0f, 10f, 0f, 8f, 11f, 11f, 11f, 3f, 8f, 0f, 17f, 0f, 14f, 3f, 14f, 11f, 25f, 8f, 25f, 10f, 14f, 16f, 14f, 23f, 13f, 24f, 12f, 24f),
        floatArrayOf(24f, 13f, 23f, 14f, 16f, 14f, 10f, 25f, 8f, 25f, 11f, 14f, 3f, 14f, 0f, 17f, 0f, 8f, 3f, 11f, 11f, 11f, 8f, 0f, 10f, 0f, 16f, 11f, 23f, 11f, 24f, 12f, 24f, 13f),
    )

    enum class State {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    var airplaneState = State.UP

    override fun draw() {
        paint.color = Color.BLACK
        when (airplaneState) {
            State.UP -> fillPolygon(AirplaneCoordinates[0])
            State.LEFT -> fillPolygon(AirplaneCoordinates[1])
            State.DOWN -> fillPolygon(AirplaneCoordinates[2])
            State.RIGHT -> fillPolygon(AirplaneCoordinates[3])
        }

        paint.color = Color.WHITE
        when (airplaneState) {
            State.UP -> drawPolygon(AirplaneCoordinates[0])
            State.LEFT -> drawPolygon(AirplaneCoordinates[1])
            State.DOWN -> drawPolygon(AirplaneCoordinates[2])
            State.RIGHT -> drawPolygon(AirplaneCoordinates[3])
        }
    }

}