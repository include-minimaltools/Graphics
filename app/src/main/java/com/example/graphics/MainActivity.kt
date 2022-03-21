package com.example.graphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val BotonJugar: Button = findViewById(R.id.btnJugar)

        BotonJugar.setOnClickListener(){
            try {
                val myCanvas = Earth(this);
                View.SYSTEM_UI_FLAG_FULLSCREEN.also { myCanvas.systemUiVisibility = it }
                setContentView(myCanvas);
            }catch (e: Exception){}
        }
    }
}