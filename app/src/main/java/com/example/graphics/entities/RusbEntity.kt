package com.example.graphics.entities

import android.graphics.Canvas
import android.graphics.Paint.Style
import android.graphics.Color

class RusbEntity(canvas: Canvas) : Entity(canvas) {
    var isDay: Boolean = false

    override fun draw() {
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

        fillPolygon(sky)

        if(isDay)
        {
            paint.color = Color.YELLOW
            canvas.drawCircle(322f, 0f, 60f, paint)
        }

        paint.color = Color.BLUE
        fillPolygon(pillarLeft)
        fillPolygon(pillarRight)

        paint.color = Color.DKGRAY
        fillPolygon(sideLeft)
        fillPolygon(sideRight)

        paint.color = Color.LTGRAY
        fillPolygon(wallCenter)
        fillPolygon(wallLeft)
        fillPolygon(wallRight)
        platforms.forEach { fillPolygon(it) }
        balconys.forEach { fillPolygon(it) }

        paint.color = Color.DKGRAY
        fillPolygon(floor)

        paint.color = Color.GREEN
        gardens.forEach { fillPolygon(it) }

        paint.color = Color.BLUE
        stripBlue.forEach { fillPolygon(it) }

        paint.color = Color.DKGRAY
        stripGray.forEach { fillPolygon(it) }
        stripWall.forEach { fillPolygon(it) }
        stairs.forEach { fillPolygon(it) }

        if(isDay)
            paint.color = Color.BLACK
        else
            paint.color = Color.YELLOW

        windows.forEach { fillPolygon(it) }
    }
}