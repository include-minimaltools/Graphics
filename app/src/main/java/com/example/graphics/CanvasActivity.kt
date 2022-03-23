package com.example.graphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.graphics.scenes.*

class CanvasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setScene("PresentationScene")
    }

    private fun setScene(scene: String) {
        var myCanvas: View = BaseScene(this, {} , {})

        when (scene) {
            "RoomScene" -> myCanvas = RoomScene(this, finish =  { finish() }, { scene -> setScene(scene)  })
            "RusbScene" -> myCanvas = RusbScene(this, finish =  { finish() }, { scene -> setScene(scene)  })
            "EarthScene" -> myCanvas = EarthScene(this, finish =  { finish() }, { scene -> setScene(scene)  })
            "PresentationScene" -> myCanvas = PresentationScene(this, finish =  { finish() }, { scene -> setScene(scene)  })
        }

        hideSystemUI(myCanvas)
        setContentView(myCanvas)
    }

    private fun hideSystemUI(view: View){
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, view).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

}