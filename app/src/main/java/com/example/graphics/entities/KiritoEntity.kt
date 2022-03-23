package com.example.graphics.entities

import android.graphics.*
import kotlin.math.pow

class KiritoEntity(canvas: Canvas) : Entity(canvas) {
    constructor(canvas: Canvas, x: Float, y: Float) : this(canvas) {
        this.initX = x
        this.initY = y
    }
    constructor(canvas: Canvas, position: PointF) : this(canvas, position.x, position.y)

    var jeanColor = Color.BLUE
    var jacketColor = Color.parseColor("#000000")
    var hairColor = Color.parseColor("#000000")
    var shoeColor = Color.parseColor("#000000")
    var skinColor = Color.parseColor("#FFE4C4")
    var eyeColor = Color.BLUE


    override fun draw() {
        val hair = floatArrayOf(38f, 35f, 38f, 22f, 41f, 17f, 47f, 29f, 46f, 25f, 52f, 30f, 51f, 24f, 52f, 13f, 57f, 22f, 59f, 26f, 59f, 30f, 60f, 26f, 60f, 27f, 59f, 26f, 62f, 29f, 61f, 26f, 64f, 30f, 65f, 32f, 66f, 26f, 66f, 23f, 68f, 25f, 67f, 17f, 71f, 20f, 68f, 10f, 69f, 12f, 63f, 4f, 58f, 1f, 52f, 0f, 46f, 0f, 36f, 1f, 40f, 3f, 35f, 6f, 32f, 10f, 27f, 13f, 33f, 12f, 27f, 22f, 32f, 17f, 32f, 32f, 35f, 26f, 38f, 35f)
        val face = floatArrayOf(34f, 28f, 35f, 26f, 38f, 35f, 38f, 22f, 41f, 17f, 47f, 29f, 46f, 25f, 52f, 30f, 51f, 24f, 52f, 13f, 57f, 22f, 59f, 26f, 59f, 30f, 60f, 26f, 60f, 27f, 59f, 26f, 62f, 29f, 61f, 26f, 64f, 30f, 62f, 35f, 61f, 35f, 59f, 39f, 50f, 45f, 43f, 41f, 40f, 38f, 38f, 35f, 37f, 35f, 34f, 28f)
        val faceDetails = floatArrayOf(62f, 35f, 61f, 35f, 59f, 39f, 50f, 45f, 43f, 41f, 40f, 38f, 38f, 35f, 37f, 35f, 34f, 28f)
        val eyebrowLeft = floatArrayOf(38f, 22f, 44f, 22f, 38f, 22f)
        val eyebrowRight = floatArrayOf(53f, 23f, 57f, 22f, 53f, 23f)
        val eyeLeft = floatArrayOf(44f, 30f, 46f, 28f, 47f, 29f, 45f, 26f, 43f, 25f, 40f, 26f, 39f, 27f, 40f, 29f, 42f, 30f, 44f, 30f)
        val eyeRight = floatArrayOf(56f, 25f, 58f, 25f, 59f, 26f, 59f, 28f, 58f, 30f, 55f, 30f, 54f, 28f, 54f, 27f, 56f, 25f)
        val pupilLeft = floatArrayOf(44f, 25f, 43f, 25f, 40f, 24f, 41f, 28f, 43f, 30f, 44f, 30f, 44f, 29f, 44f, 25f)
        val pupilRight = floatArrayOf(55f, 26f, 55f, 29f, 56f, 30f, 57f, 30f, 58f, 28f, 58f, 25f, 56f, 25f, 55f, 26f)
        val neck = floatArrayOf(44f, 41f, 44f, 49f, 42f, 53f, 48f, 56f, 53f, 56f, 59f, 53f, 56f, 50f, 56f, 41f, 50f, 45f, 44f, 41f)
        val jacket = floatArrayOf(68f, 52f, 75f, 54f, 80f, 62f, 83f, 84f, 84f, 87f, 84f, 95f, 87f, 99f, 87f, 111f, 90f, 129f, 90f, 135f, 91f, 142f, 89f, 144f, 84f, 144f, 83f, 143f, 81f, 135f, 77f, 109f, 75f, 105f, 73f, 81f, 71f, 91f, 71f, 106f, 75f, 123f, 75f, 138f, 74f, 139f, 55f, 140f, 47f, 140f, 26f, 138f, 24f, 137f, 24f, 121f, 29f, 108f, 30f, 100f, 28f, 79f, 25f, 105f, 23f, 108f, 23f, 113f, 25f, 115f, 22f, 116f, 20f, 119f, 19f, 122f, 20f, 125f, 23f, 126f, 23f, 128f, 20f, 128f, 15f, 120f, 13f, 110f, 13f, 101f, 16f, 85f, 19f, 75f, 23f, 58f, 26f, 56f, 31f, 55f, 68f, 52f)
        val jacketNeck = floatArrayOf(33f, 57f, 31f, 52f, 33f, 47f, 37f, 43f, 42f, 40f, 61f, 43f, 68f, 49f, 68f, 55f, 61f, 58f, 59f, 61f, 50f, 92f, 43f, 64f, 42f, 60f, 39f, 58f, 36f, 57f, 33f, 57f)
        val shirt = floatArrayOf(59f, 53f, 56f, 68f, 50f, 92f, 43f, 64f, 42f, 53f, 48f, 56f, 53f, 56f, 59f, 53f)
        val handLeft = floatArrayOf(26f, 115f, 25f, 115f, 22f, 116f, 20f, 119f, 19f, 122f, 20f, 125f, 23f, 126f, 24f, 126f, 26f, 115f)
        val handRight = floatArrayOf(91f, 142f, 92f, 145f, 92f, 158f, 87f, 159f, 82f, 159f, 80f, 157f, 80f, 153f, 81f, 150f, 82f, 148f, 84f, 147f, 84f, 146f, 83f, 143f, 84f, 144f, 89f, 144f, 91f, 142f)
        val handRightDetails = floatArrayOf(82f, 159f, 85f, 155f, 87f, 155f, 85f, 155f, 86f, 152f, 82f, 159f)
        val jean = floatArrayOf(24f, 137f, 25f, 152f, 27f, 162f, 29f, 176f, 30f, 190f, 30f, 223f, 32f, 235f, 33f, 240f, 34f, 253f, 34f, 255f, 31f, 256f, 31f, 263f, 43f, 263f, 46f, 261f, 46f, 254f, 44f, 252f, 45f, 215f, 45f, 189f, 46f, 166f, 47f, 158f, 50f, 143f, 60f, 188f, 60f, 203f, 69f, 245f, 69f, 252f, 67f, 254f, 69f, 259f, 69f, 262f, 75f, 264f, 78f, 264f, 81f, 263f, 81f, 259f, 83f, 257f, 80f, 254f, 75f, 214f, 74f, 194f, 74f, 149f, 73f, 139f, 55f, 140f, 47f, 140f, 24f, 137f)
        val shoeLeft = floatArrayOf(31f, 262f, 26f, 268f, 19f, 272f, 18f, 275f, 18f, 279f, 22f, 282f, 31f, 280f, 37f, 275f, 40f, 275f, 47f, 272f, 47f, 264f, 45f, 261f, 43f, 263f, 31f, 263f, 31f, 262f)
        val shoeRight = floatArrayOf(69f, 262f, 69f, 273f, 72f, 275f, 74f, 280f, 77f, 283f, 81f, 284f, 87f, 284f, 91f, 281f, 91f, 276f, 85f, 270f, 80f, 263f, 78f, 264f, 75f, 264f, 69f, 262f)
        val shoeDetails = arrayOf(
            floatArrayOf(40f, 263f, 32f, 269f, 25f, 273f, 21f, 273f, 20f, 272f, 20f, 271f),
            floatArrayOf(18f, 277f, 20f, 278f, 24f, 279f, 27f, 279f, 30f, 278f, 37f, 273f, 39f, 272f, 40f, 272f, 47f, 269f),
            floatArrayOf(72f, 263f, 77f, 274f, 79f, 276f, 83f, 277f, 87f, 277f, 88f, 276f, 89f, 275f),
            floatArrayOf(69f, 269f, 72f, 273f, 73f, 277f, 76f, 280f, 80f, 282f, 87f, 282f, 91f, 279f)
        )
        val jacketDetails = arrayOf(
            floatArrayOf(23f, 57f, 26f, 78f, 30f, 75f, 37f, 81f, 43f, 66f, 42f, 60f, 39f, 58f, 36f, 57f, 33f, 57f, 32f, 54f, 31f, 55f, 26f, 55f, 23f, 57f),
            floatArrayOf(56f, 69f, 60f, 67f, 61f, 84f, 64f, 82f, 64f, 91f, 72f, 81f, 74f, 71f, 77f, 57f, 75f, 54f, 68f, 53f, 68f, 55f, 65f, 56f, 61f, 58f, 59f, 61f, 56f, 69f),
            floatArrayOf(40f, 73f, 47f, 95f, 47f, 140f),
            floatArrayOf(50f, 92f, 50f, 140f),
            floatArrayOf(60f, 74f, 54f, 98f, 53f, 140f),
            floatArrayOf(25f, 70f, 30f, 69f, 34f, 70f, 34f, 104f, 32f, 110f, 28f, 109f, 32f, 110f, 34f, 111f, 36f, 113f, 38f, 117f, 39f, 123f),
            floatArrayOf(60f, 70f, 67f, 70f, 74f, 71f, 67f, 70f, 67f, 110f, 71f, 118f, 75f, 124f)
        )

        val jeanDetails = floatArrayOf(61f, 147f, 50f, 141f, 71f, 145f, 50f, 141f, 33f, 147f, 50f, 141f, 41f, 151f)
        val mouth = floatArrayOf(52f, 39f, 46f, 39f)

        paint.color = jeanColor
        paint.style = Paint.Style.FILL_AND_STROKE
        fillPolygon(jean)

        paint.color = jacketColor
        fillPolygon(jacket)
        fillPolygon(jacketNeck)


        paint.color = hairColor
        fillPolygon(hair)

        paint.style = Paint.Style.FILL
        paint.color = shoeColor
        fillPolygon(shoeLeft)
        fillPolygon(shoeRight)

        paint.color = skinColor
        fillPolygon(face)
        fillPolygon(neck)
        fillPolygon(handLeft)
        fillPolygon(handRight)


        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        drawPolygon(handRightDetails)
        drawPolygon(faceDetails)
        drawPolygon(eyebrowLeft)
        drawPolygon(eyebrowRight)

        paint.color = Color.DKGRAY


        shoeDetails.forEach {
            drawPolygon(it)
        }

        jacketDetails.forEach {
            drawPolygon(it)
        }

        drawPolygon(jeanDetails)

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        fillPolygon(shirt)


        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        fillPolygon(eyeLeft)
        fillPolygon(eyeRight)

        paint.color = eyeColor
        fillPolygon(pupilLeft)
        fillPolygon(pupilRight)


        paint.color = Color.RED
        paint.strokeWidth = 1.5f
        drawPolygon(mouth)
    }

}