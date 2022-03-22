package com.example.graphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.graphics.scenes.TempScene

class CanvasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myCanvas = TempScene(this) { finish() }
        View.SYSTEM_UI_FLAG_FULLSCREEN.also { myCanvas.systemUiVisibility = it }
        setContentView(myCanvas)
    }
}