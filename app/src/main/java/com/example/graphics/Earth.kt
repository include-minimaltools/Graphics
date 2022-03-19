package com.example.graphics

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.view.View

class Earth(context:Context): View(context)
{
    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas)
    {
        val paint = Paint()
        val matrix = Matrix()

        paint.color = Color.BLACK
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)

        val scale = 3f
        matrix.setTranslate(width / 2f - 703, 0f)
        canvas.concat(matrix)
        canvas.scale(scale, scale)

        drawEarth(canvas, paint)

        canvas.restore()
    }

    private fun drawEarth(canvas: Canvas, paint: Paint) {
        val earthPath = getEarthPath()

        paint.style = Style.FILL
        paint.color = Color.BLUE

        canvas.drawCircle(235f, 237f, 234f, paint)

        paint.color = Color.GREEN

        earthPath.forEach {
            canvas.drawPath(it, paint)
            canvas.save()
        }
    }

    private fun getEarthPath(): Array<Path> {
        val result = arrayOf(Path(), Path(), Path(), Path(), Path())
        val earthCoordinates = arrayOf(
            // America
            floatArrayOf(113f, 34f, 109f, 40f, 97f, 51f, 97f, 57f, 95f, 60f, 93f, 59f, 71f, 84f, 65f, 99f, 66f, 103f, 68f, 106f, 65f, 115f, 65f, 119f, 67f, 124f, 61f, 126f, 67f, 132f, 65f, 137f, 67f, 144f, 70f, 144f, 70f, 121f, 68f, 116f, 71f, 112f, 72f, 115f, 71f, 124f, 74f, 126f, 73f, 128f, 74f, 131f, 73f, 134f, 78f, 143f, 78f, 151f, 76f, 156f, 77f, 160f, 92f, 170f, 97f, 173f, 102f, 173f, 106f, 171f, 109f, 172f, 111f, 177f, 114f, 179f, 127f, 183f, 128f, 182f, 130f, 185f, 134f, 190f, 133f, 194f, 134f, 197f, 137f, 197f, 141f, 199f, 141f, 203f, 147f, 203f, 152f, 207f, 154f, 207f, 154f, 203f, 157f, 201f, 160f, 201f, 162f, 203f, 160f, 204f, 163f, 210f, 164f, 222f, 158f, 227f, 157f, 230f, 152f, 236f, 151f, 248f, 155f, 248f, 155f, 250f, 151f, 253f, 150f, 256f, 150f, 261f, 153f, 265f, 160f, 273f, 162f, 278f, 166f, 284f, 171f, 292f, 171f, 296f, 177f, 301f, 183f, 304f, 189f, 307f, 194f, 311f, 196f, 316f, 196f, 324f, 195f, 328f, 195f, 344f, 194f, 350f, 194f, 354f, 194f, 358f, 195f, 363f, 195f, 368f, 193f, 377f, 193f, 384f, 193f, 388f, 192f, 391f, 192f, 395f, 193f, 399f, 196f, 400f, 196f, 404f, 195f, 407f, 193f, 411f, 196f, 414f, 198f, 419f, 202f, 426f, 207f, 428f, 212f, 432f, 216f, 433f, 223f, 432f, 217f, 427f, 214f, 423f, 214f, 420f, 217f, 415f, 220f, 411f, 215f, 409f, 215f, 407f, 223f, 401f, 223f, 396f, 223f, 396f, 220f, 395f, 220f, 392f, 227f, 393f, 230f, 384f, 241f, 385f, 247f, 380f, 247f, 377f, 246f, 375f, 243f, 370f, 248f, 373f, 256f, 372f, 261f, 367f, 266f, 358f, 268f, 357f, 269f, 360f, 278f, 348f, 279f, 339f, 284f, 334f, 290f, 333f, 291f, 330f, 302f, 330f, 308f, 325f, 308f, 321f, 313f, 316f, 313f, 312f, 319f, 301f, 319f, 290f, 322f, 290f, 335f, 272f, 337f, 267f, 334f, 259f, 332f, 257f, 329f, 259f, 318f, 248f, 309f, 248f, 299f, 245f, 292f, 240f, 279f, 238f, 271f, 240f, 277f, 233f, 277f, 229f, 273f, 227f, 272f, 220f, 263f, 212f, 252f, 212f, 248f, 213f, 241f, 205f, 235f, 201f, 231f, 201f, 232f, 197f, 227f, 196f, 226f, 193f, 220f, 193f, 216f, 196f, 209f, 192f, 205f, 193f, 200f, 191f, 196f, 187f, 193f, 191f, 188f, 192f, 189f, 189f, 192f, 187f, 189f, 186f, 186f, 187f, 182f, 189f, 176f, 190f, 173f, 194f, 171f, 198f, 167f, 202f, 164f, 199f, 160f, 197f, 156f, 198f, 153f, 200f, 149f, 200f, 146f, 197f, 142f, 192f, 142f, 185f, 146f, 177f, 146f, 173f, 141f, 171f, 136f, 171f, 132f, 172f, 127f, 172f, 129f, 166f, 129f, 162f, 131f, 162f, 133f, 159f, 133f, 156f, 136f, 153f, 136f, 149f, 125f, 150f, 123f, 154f, 121f, 158f, 117f, 162f, 112f, 161f, 108f, 162f, 103f, 158f, 101f, 151f, 102f, 142f, 105f, 136f, 107f, 134f, 108f, 127f, 113f, 123f, 118f, 121f, 121f, 120f, 127f, 120f, 130f, 122f, 133f, 122f, 136f, 117f, 144f, 118f, 148f, 120f, 152f, 118f, 154f, 121f, 155f, 129f, 156f, 133f, 160f, 135f, 163f, 132f, 163f, 125f, 162f, 114f, 166f, 109f, 173f, 106f, 182f, 99f, 183f, 93f, 187f, 90f, 193f, 81f, 203f, 81f, 204f, 73f, 209f, 72f, 215f, 69f, 221f, 69f, 217f, 73f, 220f, 74f, 225f, 71f, 231f, 70f, 232f, 68f, 229f, 67f, 224f, 66f, 222f, 62f, 224f, 57f, 224f, 54f, 236f, 54f, 240f, 51f, 243f, 51f, 246f, 47f, 241f, 44f, 239f, 42f, 232f, 41f, 231f, 37f, 226f, 32f, 219f, 36f, 215f, 32f, 217f, 29f, 210f, 27f, 202f, 27f, 199f, 32f, 197f, 35f, 198f, 38f, 195f, 40f, 191f, 43f, 189f, 47f, 189f, 51f, 183f, 51f, 183f, 46f, 185f, 43f, 179f, 41f, 173f, 38f, 168f, 37f, 167f, 33f, 174f, 27f, 181f, 24f, 190f, 22f, 196f, 20f, 200f, 20f, 207f, 14f, 210f, 14f, 214f, 16f, 214f, 18f, 210f, 22f, 221f, 27f, 224f, 25f, 227f, 24f, 224f, 20f, 230f, 20f, 234f, 19f, 222f, 12f, 215f, 11f, 209f, 10f, 204f, 11f, 200f, 10f, 195f, 12f, 189f, 8f, 186f, 14f, 189f, 15f, 183f, 11f, 179f, 9f, 179f, 6f, 113f, 34f),
            // Africa
            floatArrayOf(436f, 114f, 429f, 108f, 424f, 106f, 421f, 102f, 418f, 96f, 413f, 94f, 405f, 94f, 402f, 98f, 400f, 99f, 392f, 98f, 393f, 102f, 391f, 106f, 391f, 113f, 394f, 117f, 393f, 122f, 390f, 126f, 388f, 132f, 388f, 139f, 386f, 146f, 387f, 152f, 390f, 156f, 392f, 161f, 392f, 168f, 392f, 175f, 395f, 184f, 400f, 191f, 405f, 199f, 407f, 205f, 413f, 209f, 423f, 219f, 428f, 206f, 433f, 215f, 437f, 217f, 443f, 211f, 448f, 210f, 451f, 218f, 457f, 219f, 458f, 223f, 458f, 232f, 457f, 237f, 458f, 243f, 460f, 257f, 461f, 275f, 458f, 287f, 454f, 298f, 450f, 311f, 448f, 327f, 439f, 349f, 434f, 359f, 428f, 370f, 428f, 373f, 436f, 114f),
            // Greenland
            floatArrayOf(212f, 1f, 214f, 4f, 221f, 5f, 226f, 4f, 229f, 6f, 238f, 6f, 241f, 9f, 242f, 13f, 245f, 15f, 247f, 20f, 249f, 22f, 255f, 27f, 261f, 30f, 265f, 29f, 268f, 30f, 270f, 28f, 270f, 24f, 273f, 21f, 285f, 13f, 283f, 12f, 279f, 11f, 276f, 8f, 273f, 6f, 268f, 5f, 265f, 1f, 212f, 1f),
            // Antarctica
            floatArrayOf(159f, 462f, 179f, 465f, 194f, 465f, 202f, 463f, 217f, 463f, 226f, 461f, 224f, 456f, 232f, 451f, 234f, 451f, 232f, 454f, 229f, 456f, 234f, 461f, 236f, 465f, 232f, 466f, 222f, 470f, 230f, 472f, 245f, 471f, 255f, 471f, 260f, 467f, 275f, 466f, 275f, 465f, 279f, 465f, 290f, 462f, 299f, 461f, 309f, 460f, 319f, 459f, 159f, 462f),
            // Europe
            floatArrayOf(318f, 15f, 337f, 26f, 350f, 35f, 353f, 35f, 361f, 40f, 361f, 43f, 365f, 43f, 365f, 48f, 369f, 52f, 369f, 57f, 367f, 60f, 371f, 62f, 383f, 72f, 371f, 72f, 370f, 75f, 373f, 80f, 377f, 85f, 381f, 94f, 388f, 95f, 391f, 97f, 395f, 95f, 397f, 93f, 397f, 89f, 395f, 84f, 392f, 75f, 395f, 73f, 395f, 71f, 411f, 84f, 414f, 83f, 318f, 15f),
        )

        result.forEachIndexed { pathIndex, path ->
            path.moveTo(0f, 0f)

            earthCoordinates[pathIndex].forEachIndexed { index, coordinate ->
                if (index % 2 == 0)
                {
                    path.lineTo(coordinate, earthCoordinates[pathIndex][index + 1])
                }
            }

            path.close()
        }

        return result
    }
}

