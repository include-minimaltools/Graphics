package com.example.graphics.entities

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint.Style


class RoomEntity(canvas: Canvas) : Entity(canvas) {
    override fun draw() {
        val ceiling = floatArrayOf(0f, 4f, 165f, 82f, 461f, 82f, 566f, 0f, 0f, 0f, 0f, 4f)
        val walls = arrayOf(
            // Left
            floatArrayOf(0f, 4f, 0f, 418f, 160f, 290f, 165f, 82f, 0f, 4f),
            // Center
            floatArrayOf(160f, 290f, 165f, 82f, 461f, 82f, 461f, 299f, 160f, 290f),
            // Right
            floatArrayOf(566f, 0f, 461f, 82f, 461f, 299f, 640f, 400f, 640f, 0f, 566f, 0f)
        )
        val skirtingBoard = floatArrayOf(640f, 400f, 461f, 299f, 160f, 290f, 0f, 418f, 0f, 429f, 160f, 301f, 461f, 311f, 640f, 412f, 640f, 400f)
        val floor = floatArrayOf(0f, 429f, 160f, 301f, 461f, 311f, 640f, 412f, 640f, 480f, 0f, 480f, 0f, 429f)
        val table = floatArrayOf(613f, 248f, 461f, 211f, 386f, 211f, 386f, 216f, 389f, 217f, 389f, 310f, 422f, 335f, 490f, 335f, 490f, 398f, 503f, 398f, 503f, 259f, 594f, 256f, 594f, 393f, 604f, 393f, 604f, 256f, 614f, 256f, 613f, 248f)
        val tableDetails = floatArrayOf(613f, 248f, 498f, 248f, 386f, 211f, 386f, 216f, 496f, 259f, 498f, 248f, 496f, 259f, 594f, 256f, 594f, 393f, 604f, 393f, 604f, 256f, 594f, 256f, 614f, 256f, 503f, 259f, 503f, 398f, 490f, 398f, 490f, 256f, 490f, 335f, 422f, 335f, 425f, 230f)
        val bed = floatArrayOf(159f, 200f, 260f, 197f, 260f, 307f, 168f, 413f, 22f, 413f, 22f, 344f, 167f, 346f, 254f, 264f, 255f, 248f, 159f, 248f, 159f, 200f)
        val mattress = floatArrayOf(22f, 344f, 167f, 346f, 254f, 264f, 255f, 248f, 159f, 248f, 22f, 321f, 22f, 344f)
        val mattressDetails = arrayOf(
            floatArrayOf(22f, 321f, 167f, 326f, 167f, 346f, 167f, 326f, 255f, 248f),
            floatArrayOf(52f, 305f, 62f, 308f),
            floatArrayOf(68f, 296f, 82f, 300f),
            floatArrayOf(102f, 278f, 169f, 275f),
            floatArrayOf(120f, 268f, 147f, 269f),
            floatArrayOf(131f, 262f, 202f, 264f)
        )

        val computer = floatArrayOf(500f, 242f, 539f, 239f, 561f, 203f, 557f, 199f, 517f, 197f, 502f, 225f, 468f, 227f, 464f, 230f, 500f, 242f)
        val computerDetails = floatArrayOf(468f, 227f, 499f, 237f, 500f, 242f, 499f, 237f, 536f, 235f, 557f, 199f)

        paint.style = Style.FILL
        paint.color = Color.WHITE
        fillPolygon(ceiling)

        paint.color = Color.parseColor("#77dd77")
        walls.forEach { fillPolygon(it) }

        paint.color = Color.parseColor("#018031")
        fillPolygon(skirtingBoard)

        paint.color = Color.parseColor("#804000")
        fillPolygon(floor)

        paint.color = Color.BLACK
        walls.forEach { drawPolygon(it) }
        drawPolygon(ceiling)
        drawPolygon(skirtingBoard)
        drawPolygon(floor)

        paint.color = Color.parseColor("#454546")
        fillPolygon(table)
        fillPolygon(bed)

        paint.color = Color.WHITE
        fillPolygon(mattress)

        paint.color = Color.BLACK
        drawPolygon(table)
        drawPolygon(tableDetails)
        drawPolygon(bed)
        drawPolygon(mattress)

        mattressDetails.forEach { drawPolygon(it) }

        paint.color = Color.LTGRAY
        fillPolygon(computer)

        paint.color = Color.BLACK
        drawPolygon(computerDetails)
        drawPolygon(computer)
        canvas.drawLine(502f, 225f, 536f, 235f, paint)
    }
}