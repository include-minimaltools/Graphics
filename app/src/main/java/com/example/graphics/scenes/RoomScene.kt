package com.example.graphics.scenes

import android.content.Context
import android.graphics.Canvas
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.RoomEntity

class RoomScene(context: Context, finish: () -> Unit, setScene: (String) -> Unit) : BaseScene(context, finish, setScene) {
    init {
        val sceneButtons = arrayOf(
            ButtonEntity().apply {
                text = ("Ir a la UNI")
                action = { setScene(RusbScene::class.java.simpleName) }
            },
            ButtonEntity().apply {
                text = ("Viajar")
                action = { setScene(EarthScene::class.java.simpleName) }
            }
        )
        interfaceButtons.addAll(sceneButtons)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val room = RoomEntity(canvas)
        room.draw()
        drawPlayer(canvas)
    }
}