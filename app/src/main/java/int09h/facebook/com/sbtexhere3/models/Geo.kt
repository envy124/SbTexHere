package int09h.facebook.com.sbtexhere3.models

import org.json.JSONObject

/**
 * Created by int09h on 23/02/2018.
 */

data class Point (var latitude: Double, var longitude: Double)

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

data class Triangle (val left: Point, val right: Point, val cb: Point) {

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
        fun createFromPointAndRadius(center: Point, radius: Double): Triangle {
            // This is the goofiest way to get triangle from point, but I don't care
            val cb = Point(center.latitude + radius, center.longitude)
            val radiusVector = Vector(center, cb)
            val left = radiusVector.rotate(-120.0)
            val right = radiusVector.rotate(120.0)
            left.latitude -= radius / 2
            right.latitude -= radius / 2
            cb.latitude -= radius * 1.5
            return Triangle(left, right, cb)
        }
    }
}