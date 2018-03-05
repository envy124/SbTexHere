package int09h.facebook.com.sbtexhere3

import android.location.Location
import android.os.AsyncTask
import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.Point
import int09h.facebook.com.sbtexhere3.models.SbEntity

/**
 * Created by int09h on 05/03/2018.
 */
class FilialDownloader(private val adapter: AtmRecyclerViewAdapter, private val geo: LocationRetriever) : AsyncTask<Double, Void, Array<SbEntity>>() {
    private var factory: FilialFactory? = null

    init {
        factory = FilialFactory(Sberbank())
    }

    override fun doInBackground(vararg p0: Double?): Array<SbEntity> {
        val result = mutableListOf<SbEntity>()
        val currentPos = geo.getLocation()
        for(radius in p0) {
            val filials = factory?.getFilials(Point(currentPos!!.latitude, currentPos.longitude), radius!!)
            if (filials != null) result.addAll(filials)
        }
        return result.toTypedArray()
    }

    override fun onPostExecute(result: Array<SbEntity>?) {
        result?.forEach { adapter.addItem(it) }
    }

    override fun onCancelled(result: Array<SbEntity>?) {
        super.onCancelled(result)
    }

    interface LocationRetriever {
        fun getLocation(): Location?
    }
}