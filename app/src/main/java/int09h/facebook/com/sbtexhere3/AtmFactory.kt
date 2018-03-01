package int09h.facebook.com.sbtexhere3

import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.SbEntity
import int09h.facebook.com.sbtexhere3.models.Point
import int09h.facebook.com.sbtexhere3.models.SbGeo

/**
 * Created by int09h on 26/02/2018.
 */
class AtmFactory(private val api: Sberbank) {
    fun getNearestAtms(currentPos: Point, radius: Double): List<SbEntity>? {
        val geo = SbGeo.createFromPointAndRadius(currentPos, radius)
        val atms = api.fetchAtms(geo)?.distinctBy { it.address }
        return atms?.map {
            val atmPos = Point(it.coordinates?.latitude!!, it.coordinates.longitude!!)
            SbEntity(it.address!!, it.type!!, it.stateName!!, currentPos.distanceTo(atmPos) )
        }?.sortedBy { it.distance }
    }
}