package com.example.graphics.entities

import android.content.res.Resources
import android.graphics.*
import com.example.graphics.R
import com.example.graphics.R.drawable.ic_launcher_background
import kotlin.random.Random

class PresentationEntity(canvas: Canvas) : Entity(canvas) {
    var archColor = Color.BLUE
    var windowsColor = Color.CYAN
    val matrix = Matrix()
    val Sol : Path = Path()
    val txtColor = Color.WHITE



    override fun draw() {
        val archLogo = floatArrayOf(2f, 100f, 29f, 35f, 40f, 40f, 31f, 30f, 40f, 2f, 68f, 79f, 60f, 75f, 71f, 87f, 77f, 100f, 48f, 84f, 48f, 72f, 48f, 66f, 44f, 62f, 41f, 60f, 34f, 62f, 33f, 66f, 32f, 72f, 31f, 84f, 2f, 100f)
        val windowsLogo = arrayOf( floatArrayOf(4f, 19f, 43f, 13f, 42f, 52f, 4f, 52f, 4f, 19f),
            floatArrayOf(49f, 12f, 100f, 4f, 100f, 52f, 49f, 52f, 49f, 12f),
            floatArrayOf(4f, 57f, 43f, 57f, 43f, 97f, 4f, 90f, 4f, 57f),
            floatArrayOf(49f, 57f, 100f, 57f, 100f, 105f, 49f, 97f, 49f, 57f)
        )

        for(i in 1..640){
            paint.color = Color.WHITE
            canvas.drawPoint((Random.nextInt(0, 640)).toFloat(), (Random.nextInt(0, 480)).toFloat(), paint)
        }

        try {
            val temp = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.bmpgabriel)

            println("temp $temp")
            val luisbmp : Bitmap? = BitmapFactory.decodeResource(Resources.getSystem(), ic_launcher_background)
            val gabrielbmp : Bitmap? = BitmapFactory.decodeResource(Resources.getSystem(), ic_launcher_background)
            if(luisbmp != null && gabrielbmp != null){
                canvas.drawBitmap(luisbmp, 105f, 160f, paint)
                canvas.drawBitmap(gabrielbmp, 235f, 160f, paint)
            }

        }catch(e: Exception){ println("Error ${e.message}")}

        paint.color = txtColor
        paint.textSize = 14f
        canvas.drawText("PROGRAMACION GRAFICA",100f, 30f, paint)
        canvas.drawText("3T1-CO",160f, 50f, paint)
        canvas.drawText("INTEGRANTES:",140f, 100f, paint)
        paint.textSize = 10f
        canvas.drawText("Luis M. Pineda J.",80f, 130f, paint)
        canvas.drawText("Gabriel A. Ortiz A.",210f, 130f, paint)
        paint.textSize = 8f
        canvas.drawText("2020-0251U",95f, 140f, paint)
        canvas.drawText("2020-0325U",225f, 140f, paint)

        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        canvas.drawOval(RectF(-15f, -15f, 75f, 82f) , paint)

        paint.color = Color.DKGRAY
        canvas.drawCircle(10f, 10f, 50f, paint)

        paint.color = Color.YELLOW
        paint.style = Paint.Style.FILL_AND_STROKE
        Sol.moveTo(340f, 260f)
        Sol.addCircle(340f, 260f, 21f, Path.Direction.CCW)
        Sol.lineTo(370f, 260f)
        Sol.lineTo(365f, 270f)
        Sol.lineTo(350f, 260f)
        Sol.lineTo(360f, 260f)
        Sol.close()
        canvas.drawPath(Sol, paint)
        canvas.save()

        for(i in 1..8){
            matrix.setRotate(45f, 340f, 260f)
            canvas.concat(matrix)
            canvas.drawPath(Sol, paint)
            canvas.save()
        }

        paint.color = archColor
        paint.style = Paint.Style.FILL_AND_STROKE
        matrix.setTranslate(5f, 205f)
        canvas.concat(matrix)
        fillPolygon(archLogo)

        paint.style = Paint.Style.FILL_AND_STROKE
        matrix.setTranslate(270f, -205f)
        canvas.concat(matrix)

        paint.color = Color.BLACK
        canvas.drawRoundRect(RectF(4f, 19f, 130f, 93f), 10f, 10f, paint)

        paint.color = windowsColor
        windowsLogo.forEach{
            fillPolygon((it))
        }
    }
}