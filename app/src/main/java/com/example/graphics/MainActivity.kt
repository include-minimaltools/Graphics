package com.example.graphics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btnExit -> {
                exitProcess(0);
            }
            R.id.btnPlay -> {
                val intent = Intent(this, CanvasActivity::class.java)
                startActivity(intent)
            }
        }
    }
}