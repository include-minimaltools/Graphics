package com.example.graphics.scenes

import android.content.Context
import android.graphics.Canvas
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.RusbEntity

class RusbScene(context: Context, finish: () -> Unit, setScene: (String) -> Unit) : BaseScene(context, finish, setScene) {
    private var isDay = true

    init {
        val sceneButtons = listOf(
            ButtonEntity().apply {
                text = "Volver a Casa"
                action = { setScene(RoomScene::class.java.simpleName) }
            },
            ButtonEntity().apply {
                text = "Día/Noche"
                action = { isDay = !isDay }
            }
        )

        interfaceButtons.addAll(sceneButtons)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val rusb = RusbEntity(canvas)
        rusb.isDay = isDay
        rusb.draw()
        drawPlayer(canvas)
    }
}