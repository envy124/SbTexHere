package int09h.facebook.com.sbtexhere3.models

import org.json.JSONObject

/**
 * Created by int09h on 23/02/2018.
 */

data class Point (val latitude: Float, val longitude: Float)

data class Triangle (val left: Point, val right: Point, val cb: Point) {

    fun toJson(): JSONObject {
        val json = JSONObject()
        json.put("llat", left.latitude)
        json.put("llon", left.longitude)
        json.put("rlat", right.latitude)
        json.put("rlon", right.latitude)
        json.put("cbLat", cb.latitude)
        json.put("cbLon", cb.longitude)
        return json
    }

    fun serialize(): Map<String, String> {
        return mapOf(
                "llat" to left.latitude.toString(),
                "llon" to left.latitude.toString(),
                "rlat" to left.latitude.toString(),
                "rlon" to left.latitude.toString(),
                "cbLat" to left.latitude.toString(),
                "cbLon" to left.latitude.toString())
    }

    companion object {
        fun createFromPointAndRadius(point: Point, radius: Float): Triangle {
            val left = Point(0.0f, 0.0f)
            val right = Point(0.0f, 0.0f)
            val cornerBack = Point(0.0f, 0.0f)
            return Triangle(left, right, cornerBack)
        }
    }
}