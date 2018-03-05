package int09h.facebook.com.sbtexhere3.models

import android.location.Location

/**
 * Created by int09h on 05/03/2018.
 */
data class FilialArguments(val currentPos: Point, val radius: Double) {
    constructor(loc: Location, radius: Double) : this(Point(loc.latitude, loc.longitude), radius)
}