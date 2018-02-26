package int09h.facebook.com.sbtexhere3.models

import org.json.JSONObject

/**
 * Created by int09h on 23/02/2018.
 */

data class Point (val latitude: Double, val longitude: Double)

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
        fun createFromPointAndRadius(point: Point, radius: Float): Triangle {
            val left = Point(0.0, 0.0)
            val right = Point(0.0, 0.0)
            val cornerBack = Point(0.0, 0.0)
            return Triangle(left, right, cornerBack)
        }
    }
}