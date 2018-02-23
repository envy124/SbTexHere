package int09h.facebook.com.sbtexhere3.models

/**
 * Created by int09h on 23/02/2018.
 */

data class Point (val latitude: Float, val longitude: Float)

data class Triangle (val left: Point, val right: Point, val cb: Point) {

    companion object {
        fun createFromPointAndRadius(point: Point, radius: Float): Triangle {
            val left = Point(0.0f, 0.0f)
            val right = Point(0.0f, 0.0f)
            val cornerBack = Point(0.0f, 0.0f)
            return Triangle(left, right, cornerBack)
        }
    }
}