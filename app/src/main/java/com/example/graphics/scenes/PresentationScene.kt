package com.example.graphics.scenes

import android.content.Context
import android.graphics.Canvas
import com.example.graphics.entities.ButtonEntity
import com.example.graphics.entities.PresentationEntity

class PresentationScene(context: Context, finish: () -> Unit, setScene: (String) -> Unit) : BaseScene(context, finish, setScene) {

    init {
        interfaceButtons.add(ButtonEntity().apply {
            text = "Volver"
            action = { setScene(RoomScene::class.java.simpleName) }
        })

        interfaceButtons[1].isVisible = false
        interfaceButtons[2].isVisible = false
    }

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)

        canvas.scale(1.5f, 1.6f)
        val presentation = PresentationEntity(canvas)
        presentation.draw()
    }
}