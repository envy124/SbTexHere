package int09h.facebook.com.sbtexhere3

import android.os.AsyncTask
import int09h.facebook.com.sbtexhere3.api.Sberbank
import int09h.facebook.com.sbtexhere3.models.FilialArguments
import int09h.facebook.com.sbtexhere3.models.SbEntity

/**
 * Created by int09h on 05/03/2018.
 */
class FilialDownloader(private val adapter: AtmRecyclerViewAdapter) : AsyncTask<FilialArguments, Void, Array<SbEntity>>() {
    private var factory: FilialFactory? = null

    init {
        factory = FilialFactory(Sberbank())
    }

    override fun doInBackground(vararg p0: FilialArguments?): Array<SbEntity> {
        val result = mutableListOf<SbEntity>()
        for(item in p0) {
            val filials = factory?.getFilials(item!!.currentPos, item.radius)
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
}