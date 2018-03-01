package int09h.facebook.com.sbtexhere3.models

import org.json.JSONObject
import java.lang.StrictMath.pow
import kotlin.math.sqrt

/**
 * Created by int09h on 23/02/2018.
 */

data class Point (var latitude: Double, var longitude: Double) {
    fun distanceTo(p1: Point): Double {
        return sqrt(pow(p1.latitude - latitude, 2.0) + pow(p1.longitude - longitude, 2.0))
    }
}

data class Vector(val point1: Point, val point2: Point) {

    fun rotate(angle: Double): Point {
        val centerX = point1.longitude
        val centerY = point1.latitude
        val point2x = point2.longitude
        val point2y = point2.latitude
        val newX = centerX + (point2x-centerX)*Math.cos(angle) - (point2y-centerY)*Math.sin(angle)
        val newY = centerY + (point2x-centerX)*Math.sin(angle) + (point2y-centerY)*Math.cos(angle)
        return Point(newY, newX)
    }
}

data class SbGeo(val left: Point, val right: Point, val cb: Point) {

    fun toJson(): JSONObject {
        val json = JSONObject()
        for ((k, v) in serialize()) {
            json.put(k, v)
        }
        return json
    }

    fun serialize(): Map<String, String> {
        return mapOf(
                "llat" to left.latitude.toString(),
                "llon" to left.longitude.toString(),
                "rlat" to right.latitude.toString(),
                "rlon" to right.longitude.toString(),
                "cbLat" to cb.latitude.toString(),
                "cbLon" to cb.longitude.toString())
    }

    companion object {
        fun createFromPointAndRadius(center: Point, radius: Double): SbGeo {
            val homeLocation = Point(55.750518899999996, 37.9878976)
            val right = Point(center.latitude + radius, center.longitude + radius)
            val left = Point(center.latitude - radius, center.longitude - radius)
            return SbGeo(left, right, homeLocation)
        }
    }
}