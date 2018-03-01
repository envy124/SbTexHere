package int09h.facebook.com.sbtexhere3

import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.SbEntity
import int09h.facebook.com.sbtexhere3.models.Point
import int09h.facebook.com.sbtexhere3.models.SbGeo

/**
 * Created by int09h on 28/02/2018.
 */
class FilialFactory(private val api: Sberbank) {
    fun getFilials(currentPos: Point, radius: Double): List<SbEntity>? {
        val geo = SbGeo.createFromPointAndRadius(currentPos, radius)
        val filials = api.fetchFilials(geo)?.distinctBy { it.address }
        return filials?.map {
            val atmPos = Point(it.coordinates?.latitude!!, it.coordinates.longitude!!)
            SbEntity(it.address!!, "", it.name!!, currentPos.distanceToMeters(atmPos) )
        }?.sortedBy { it.distance }
    }
}
