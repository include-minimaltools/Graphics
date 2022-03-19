package com.example.graphics

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.view.View
import com.example.graphics.Utils.*

class Kirito(context: Context): View(context) {
    var jeanColor = Color.BLUE
    var jacketColor = Color.parseColor("#000000")
    var hairColor = Color.parseColor("#000000")
    var shoeColor = Color.parseColor("#000000")
    var skinColor = Color.parseColor("#FFE4C4")
    var eyeColor = Color.BLUE

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        val matrix = Matrix()

        val scalex = 4.65f
        val scaley = 3.5f
        canvas.scale(4.65f,3.5f)

        drawRusb(canvas, paint, false)

        matrix.setTranslate(200f, 250f)
        canvas.concat(matrix)
        drawKirito(canvas, paint)
    }

    fun drawRoom(canvas: Canvas, paint: Paint)
    {
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
        Companion.fillPolygon(canvas, paint, ceiling)

        paint.color = Color.parseColor("#77dd77")
        walls.forEach { Companion.fillPolygon(canvas, paint, it) }

        paint.color = Color.parseColor("#018031")
        Companion.fillPolygon(canvas, paint, skirtingBoard)

        paint.color = Color.parseColor("#804000")
        Companion.fillPolygon(canvas, paint, floor)

        paint.color = Color.BLACK
        walls.forEach { Companion.drawPolygon(canvas, paint, it) }
        Companion.drawPolygon(canvas, paint, ceiling)
        Companion.drawPolygon(canvas, paint, skirtingBoard)
        Companion.drawPolygon(canvas, paint, floor)

        paint.color = Color.parseColor("#454546")
        Companion.fillPolygon(canvas, paint, table)
        Companion.fillPolygon(canvas, paint, bed)

        paint.color = Color.WHITE
        Companion.fillPolygon(canvas, paint, mattress)

        paint.color = Color.BLACK
        Companion.drawPolygon(canvas, paint, table)
        Companion.drawPolygon(canvas, paint, tableDetails)
        Companion.drawPolygon(canvas, paint, bed)
        Companion.drawPolygon(canvas, paint, mattress)

        mattressDetails.forEach { Companion.drawPolygon(canvas, paint, it) }

        paint.color = Color.LTGRAY
        Companion.fillPolygon(canvas, paint, computer)

        paint.color = Color.BLACK
        Companion.drawPolygon(canvas, paint, computerDetails)
        Companion.drawPolygon(canvas, paint, computer)
        canvas.drawLine(502f, 225f, 536f, 235f, paint)
    }

    fun drawRusb(canvas: Canvas, paint: Paint, isDay: Boolean)
    {
        val sky = floatArrayOf(0f, 118f, 15f, 99f, 40f, 85f, 91f, 95f, 91f, 114f, 111f, 117f, 207f, 73f, 229f, 63f, 239f, 65f, 269f, 116f, 270f, 294f, 378f, 294f, 376f, 115f, 380f, 63f, 388f, 60f, 545f, 110f, 562f, 106f, 562f, 85f, 618f, 74f, 640f, 82f, 640f, 0f, 0f, 0f, 0f, 118f)
        val pillarLeft = floatArrayOf(207f, 73f, 229f, 63f, 239f, 65f, 269f, 116f, 269f, 293f, 243f, 300f, 204f, 295f, 207f, 73f)
        val pillarRight = floatArrayOf(380f, 63f, 388f, 60f, 427f, 74f, 430f, 287f, 547f, 284f, 546f, 297f, 381f, 300f, 380f, 63f)
        val wallLeft = floatArrayOf(207f, 74f, 204f, 295f, 109f, 288f, 11f, 295f, 11f, 109f, 40f, 85f, 91f, 96f, 91f, 115f, 111f, 118f, 207f, 74f)
        val wallRight = floatArrayOf(427f, 74f, 545f, 111f, 562f, 107f, 562f, 86f, 618f, 74f, 640f, 97f, 640f, 272f, 626f, 275f, 620f, 280f, 610f, 284f, 605f, 281f, 595f, 287f, 584f, 291f, 561f, 292f, 546f, 297f, 547f, 284f, 430f, 287f, 427f, 74f)
        val sideLeft = floatArrayOf(40f, 85f, 15f, 99f, 0f, 118f, 0f, 303f, 11f, 295f, 11f, 109f, 40f, 85f)
        val sideRight = floatArrayOf(640f, 97f, 640f, 83f, 618f, 74f, 640f, 97f)
        val gardens = arrayOf(
            floatArrayOf(302f, 311f, 285f, 315f, 277f, 324f, 277f, 330f, 287f, 333f, 381f, 333f, 403f, 329f, 407f, 322f, 399f, 316f, 381f, 313f, 319f, 311f, 302f, 311f),
            floatArrayOf(0f, 303f, 11f, 295f, 109f, 288f, 204f, 295f, 243f, 300f, 263f, 309f, 152f, 338f, 106f, 357f, 0f, 357f, 0f, 303f),
            floatArrayOf(448f, 312f, 490f, 310f, 544f, 298f, 561f, 292f, 584f, 291f, 595f, 287f, 605f, 281f, 610f, 284f, 620f, 280f, 626f, 275f, 640f, 272f, 640f, 352f, 605f, 346f, 562f, 346f, 448f, 312f),
        )

        val floor = floatArrayOf(0f, 357f, 106f, 357f, 152f, 338f, 263f, 309f, 243f, 300f, 269f, 293f, 377f, 293f, 381f, 300f, 544f, 298f, 490f, 310f, 448f, 312f, 562f, 346f, 605f, 346f, 640f, 352f, 640f, 480f, 0f, 480f, 0f, 357f)

        val stripWall = arrayOf(
            // Right
            floatArrayOf(640f, 273f, 637f, 273f, 632f, 113f, 602f, 119f, 607f, 282f, 606f, 282f, 598f, 286f, 592f, 100f, 633f, 90f, 640f, 97f, 640f, 273f),
            // Left
            floatArrayOf(11f, 295f, 11f, 109f, 21f, 102f, 63f, 109f, 61f, 292f, 50f, 292f, 53f, 127f, 23f, 123f, 21f, 294f, 11f, 295f)
        )


        val stripGray = arrayOf(
            // Right
            floatArrayOf(547f, 270f, 546f, 263f, 429f, 260f, 430f, 269f, 547f, 270f),
            floatArrayOf(429f, 225f, 429f, 216f, 546f, 227f, 546f, 235f, 429f, 225f),
            floatArrayOf(428f, 173f, 428f, 182f, 545f, 200f, 545f, 192f, 428f, 173f),
            floatArrayOf(545f, 164f, 545f, 157f, 427f, 130f, 426f, 138f, 545f, 164f),
            floatArrayOf(427f, 87f, 545f, 122f, 545f, 129f, 427f, 96f, 427f, 87f),
            // Left
            floatArrayOf(192f, 80f, 193f, 95f, 111f, 129f, 111f, 136f, 193f, 103f, 193f, 135f, 111f, 162f, 111f, 169f, 193f, 144f, 193f, 177f, 111f, 196f, 111f, 202f, 193f, 186f, 193f, 219f, 111f, 229f, 111f, 236f, 193f, 228f, 193f, 261f, 111f, 262f, 111f, 269f, 193f, 269f, 193f, 294f, 205f, 296f, 207f, 74f, 192f, 80f)
        )

        val stripBlue = arrayOf(
            // Left
            floatArrayOf(193f, 280f, 111f, 279f, 111f, 289f, 193f, 294f, 193f, 289f, 193f, 280f),
            floatArrayOf(193f, 253f, 111f, 257f, 111f, 250f, 193f, 245f, 193f, 253f),
            floatArrayOf(193f, 210f, 111f, 224f, 111f, 217f, 193f, 203f, 193f, 210f),
            floatArrayOf(193f, 168f, 193f, 160f, 111f, 182f, 111f, 189f, 193f, 168f),
            floatArrayOf(193f, 127f, 193f, 119f, 111f, 149f, 111f, 156f, 193f, 127f),

            // Right
            floatArrayOf(438f, 244f, 438f, 253f, 546f, 257f, 546f, 249f, 438f, 244f),
            floatArrayOf(437f, 201f, 437f, 209f, 545f, 221f, 545f, 214f, 437f, 201f),
            floatArrayOf(545f, 186f, 545f, 178f, 436f, 158f, 436f, 166f, 545f, 186f),
            floatArrayOf(436f, 116f, 436f, 124f, 544f, 151f, 544f, 143f, 436f, 116f),
        )

        val platforms = arrayOf(
            floatArrayOf(270f, 262f, 290f, 260f, 363f, 260f, 378f, 259f, 378f, 271f, 270f, 271f, 270f, 262f),
            floatArrayOf(270f, 238f, 289f, 239f, 324f, 235f, 362f, 240f, 378f, 239f, 377f, 226f, 323f, 226f, 290f, 227f, 270f, 226f, 270f, 238f),
            floatArrayOf(270f, 203f, 290f, 205f, 323f, 202f, 377f, 205f, 377f, 191f, 360f, 193f, 323f, 191f, 290f, 193f, 270f, 193f, 270f, 203f),
            floatArrayOf(270f, 169f, 291f, 172f, 323f, 168f, 361f, 170f, 377f, 167f, 377f, 156f, 359f, 160f, 324f, 158f, 288f, 161f, 270f, 158f, 270f, 169f),
            floatArrayOf(270f, 135f, 269f, 116f, 289f, 121f, 322f, 115f, 359f, 120f, 376f, 115f, 377f, 134f, 360f, 138f, 323f, 134f, 288f, 138f, 270f, 135f),
        )

        val wallCenter = floatArrayOf(376f, 115f, 377f, 295f, 381f, 300f, 380f, 63f, 376f, 115f)

        val balconys = arrayOf(
            // Right
            floatArrayOf(381f, 80f, 381f, 81f, 389f, 79f, 416f, 86f, 412f, 109f, 389f, 103f, 381f, 105f, 381f, 89f, 381f, 80f),
            floatArrayOf(381f, 124f, 390f, 122f, 412f, 129f, 412f, 153f, 390f, 149f, 381f, 151f, 381f, 124f),
            floatArrayOf(382f, 174f, 382f, 195f, 391f, 195f, 412f, 197f, 412f, 173f, 390f, 169f, 383f, 170f, 382f, 174f),
            floatArrayOf(383f, 215f, 390f, 214f, 412f, 217f, 412f, 241f, 383f, 241f, 383f, 215f),
            floatArrayOf(384f, 300f, 384f, 262f, 412f, 262f, 412f, 300f, 384f, 300f),
            // Left
            floatArrayOf(212f, 113f, 229f, 105f, 239f, 108f, 242f, 111f, 242f, 90f, 239f, 83f, 229f, 80f, 212f, 89f, 212f, 113f),
            floatArrayOf(212f, 131f, 229f, 124f, 239f, 126f, 242f, 131f, 242f, 154f, 239f, 152f, 229f, 150f, 212f, 156f, 212f, 131f),
            floatArrayOf(211f, 175f, 211f, 197f, 227f, 195f, 239f, 195f, 242f, 199f, 242f, 174f, 239f, 172f, 229f, 169f, 211f, 175f),
            floatArrayOf(242f, 242f, 242f, 219f, 239f, 214f, 229f, 214f, 211f, 218f, 211f, 242f, 239f, 241f, 242f, 242f),
            floatArrayOf(243f, 400f, 211f, 296f, 211f, 262f, 226f, 261f, 239f, 261f, 242f, 262f, 243f, 400f)
        )

        val stairs = arrayOf(
            floatArrayOf(362f, 293f, 343f, 277f, 329f, 277f, 322f, 271f, 309f, 271f, 326f, 284f, 340f, 284f, 352f, 293f, 362f, 293f),
            floatArrayOf(360f, 260f, 337f, 242f, 320f, 242f, 311f, 236f, 304f, 237f, 316f, 245f, 330f, 245f, 350f, 260f, 360f, 260f),
            floatArrayOf(303f, 202f, 316f, 214f, 332f, 214f, 346f, 226f, 356f, 226f, 337f, 210f, 320f, 209f, 311f, 202f, 303f, 202f),
            floatArrayOf(354f, 192f, 344f, 192f, 331f, 181f, 314f, 181f, 303f, 170f, 310f, 169f, 317f, 176f, 334f, 176f, 354f, 192f),
        )

        val windows = arrayOf(
            // Left
            floatArrayOf(193f, 280f, 111f, 279f, 111f, 269f, 193f, 269f, 193f, 280f),
            floatArrayOf(193f, 245f, 111f, 250f, 111f, 236f, 193f, 228f, 193f, 245f),
            floatArrayOf(193f, 203f, 111f, 217f, 111f, 202f, 193f, 186f, 193f, 203f),
            floatArrayOf(193f, 160f, 193f, 144f, 111f, 169f, 111f, 182f, 193f, 160f),
            floatArrayOf(193f, 119f, 193f, 103f, 111f, 136f, 111f, 149f, 193f, 119f),

            // Side Left
            floatArrayOf(82f, 131f, 82f, 155f, 99f, 157f, 99f, 134f, 82f, 131f),
            floatArrayOf(99f, 163f, 99f, 190f, 81f, 190f, 82f, 161f, 99f, 163f),
            floatArrayOf(82f, 194f, 82f, 219f, 99f, 218f, 99f, 194f, 82f, 194f),
            floatArrayOf(99f, 228f, 82f, 228f, 82f, 254f, 99f, 253f, 99f, 228f),
            floatArrayOf(99f, 289f, 99f, 265f, 82f, 266f, 82f, 290f, 99f, 289f),

            // Right
            floatArrayOf(439f, 286f, 547f, 284f, 547f, 270f, 439f, 268f, 439f, 286f),
            floatArrayOf(438f, 244f, 546f, 249f, 546f, 235f, 438f, 227f, 438f, 244f),
            floatArrayOf(437f, 183f, 545f, 200f, 545f, 214f, 437f, 201f, 437f, 183f),
            floatArrayOf(436f, 141f, 436f, 158f, 545f, 178f, 545f, 164f, 436f, 141f),
            floatArrayOf(544f, 143f, 544f, 129f, 436f, 99f, 436f, 116f, 544f, 143f),

            // Side Right
            floatArrayOf(555f, 128f, 556f, 151f, 574f, 149f, 573f, 124f, 555f, 128f),
            floatArrayOf(556f, 158f, 574f, 155f, 575f, 184f, 557f, 186f, 556f, 158f),
            floatArrayOf(557f, 193f, 558f, 222f, 576f, 221f, 576f, 191f, 557f, 193f),
            floatArrayOf(558f, 229f, 559f, 249f, 578f, 248f, 577f, 228f, 558f, 229f),
            floatArrayOf(578f, 271f, 578f, 291f, 561f, 292f, 559f, 293f, 559f, 271f, 578f, 271f),

            // Balcony Left
            floatArrayOf(220f, 286f, 235f, 286f, 235f, 270f, 220f, 270f, 220f, 286f),
            floatArrayOf(220f, 241f, 235f, 242f, 235f, 226f, 220f, 226f, 220f, 241f),
            floatArrayOf(220f, 182f, 219f, 195f, 235f, 195f, 235f, 183f, 220f, 182f),
            floatArrayOf(235f, 151f, 235f, 139f, 220f, 139f, 219f, 153f, 229f, 150f, 235f, 151f),
            floatArrayOf(219f, 109f, 220f, 96f, 235f, 96f, 235f, 107f, 229f, 106f, 219f, 109f),
            // Balcony Right
            floatArrayOf(389f, 103f, 405f, 107f, 405f, 93f, 389f, 94f, 389f, 103f),
            floatArrayOf(389f, 148f, 389f, 137f, 405f, 137f, 405f, 151f, 389f, 148f),
            floatArrayOf(405f, 196f, 406f, 181f, 390f, 181f, 390f, 194f, 405f, 196f),
            floatArrayOf(391f, 225f, 406f, 225f, 406f, 241f, 391f, 241f, 391f, 225f),
            floatArrayOf(391f, 269f, 391f, 287f, 408f, 287f, 408f, 269f, 391f, 269f),
        )

        paint.style = Style.FILL

        if(isDay)
            paint.color = Color.CYAN
        else
            paint.color = Color.parseColor("#000c42")

        Companion.fillPolygon(canvas, paint, sky)

        if(isDay)
        {
            paint.color = Color.YELLOW
            canvas.drawCircle(322f, 0f, 60f, paint)
        }

        paint.color = Color.BLUE
        Companion.fillPolygon(canvas, paint, pillarLeft)
        Companion.fillPolygon(canvas, paint, pillarRight)

        paint.color = Color.DKGRAY
        Companion.fillPolygon(canvas, paint, sideLeft)
        Companion.fillPolygon(canvas, paint, sideRight)

        paint.color = Color.LTGRAY
        Companion.fillPolygon(canvas, paint, wallCenter)
        Companion.fillPolygon(canvas, paint, wallLeft)
        Companion.fillPolygon(canvas, paint, wallRight)
        platforms.forEach { Companion.fillPolygon(canvas, paint, it) }
        balconys.forEach { Companion.fillPolygon(canvas, paint, it) }

        paint.color = Color.DKGRAY
        Companion.fillPolygon(canvas, paint, floor)

        paint.color = Color.GREEN
        gardens.forEach { Companion.fillPolygon(canvas, paint, it) }

        paint.color = Color.BLUE
        stripBlue.forEach { Companion.fillPolygon(canvas, paint, it) }

        paint.color = Color.DKGRAY
        stripGray.forEach { Companion.fillPolygon(canvas, paint, it) }
        stripWall.forEach { Companion.fillPolygon(canvas, paint, it) }
        stairs.forEach { Companion.fillPolygon(canvas, paint, it) }

        if(isDay)
            paint.color = Color.BLACK
        else
            paint.color = Color.YELLOW

        windows.forEach { Companion.fillPolygon(canvas, paint, it) }
    }

    fun drawKirito(canvas: Canvas, paint: Paint) {
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
        paint.style = Style.FILL_AND_STROKE
        Companion.fillPolygon(canvas, paint, jean)

        paint.color = jacketColor
        Companion.fillPolygon(canvas, paint, jacket)
        Companion.fillPolygon(canvas, paint, jacketNeck)


        paint.color = hairColor
        Companion.fillPolygon(canvas, paint, hair)

        paint.style = Style.FILL
        paint.color = shoeColor
        Companion.fillPolygon(canvas, paint, shoeLeft)
        Companion.fillPolygon(canvas, paint, shoeRight)

        paint.color = skinColor
        Companion.fillPolygon(canvas, paint, face)
        Companion.fillPolygon(canvas, paint, neck)
        Companion.fillPolygon(canvas, paint, handLeft)
        Companion.fillPolygon(canvas, paint, handRight)


        paint.color = Color.BLACK
        paint.style = Style.STROKE
        Companion.drawPolygon(canvas, paint, handRightDetails)
        Companion.drawPolygon(canvas, paint, faceDetails)
        Companion.drawPolygon(canvas, paint, eyebrowLeft)
        Companion.drawPolygon(canvas, paint, eyebrowRight)

        paint.color = Color.DKGRAY


        shoeDetails.forEach {
            Companion.drawPolygon(canvas, paint, it)
        }

        jacketDetails.forEach {
            Companion.drawPolygon(canvas, paint, it)
        }

        Companion.drawPolygon(canvas, paint, jeanDetails)

        paint.color = Color.RED
        paint.style = Style.FILL
        Companion.fillPolygon(canvas, paint, shirt)


        paint.color = Color.WHITE
        paint.style = Style.FILL
        Companion.fillPolygon(canvas, paint, eyeLeft)
        Companion.fillPolygon(canvas, paint, eyeRight)

        paint.color = eyeColor
        Companion.fillPolygon(canvas, paint, pupilLeft)
        Companion.fillPolygon(canvas, paint, pupilRight)


        paint.color = Color.RED
        paint.strokeWidth = 1.5f
        Companion.drawPolygon(canvas, paint, mouth)
    }
}