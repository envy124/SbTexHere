package int09h.facebook.com.sbtexhere3.api

import android.util.Log
import int09h.facebook.com.sbtexhere3.models.Triangle
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


/**
 * Created by int09h on 23/02/2018.
 */

const val SB_ENDPOINT = "https://sberbank.ru/portalserver/proxy/"
const val SB_GET_ATMS = "http://localhost/oib-rs/byBounds/entities"

class Sberbank(private val host: String = SB_ENDPOINT) {
    private val TAG = Sberbank::class.java.simpleName

    private val client: OkHttpClient = OkHttpClient()

    fun getAtms(geo: Triangle, size: Int = 0, page: Int = 0) {
        val internalMethod = okhttp3.HttpUrl.parse(SB_GET_ATMS)?.newBuilder()
                ?.addQueryParameter("size", size.toString())
                ?.addQueryParameter("page", page.toString())
                ?.addQueryParameter("filter[type][]", "itt")
                ?.addQueryParameter("filter[type][]", "atm")
                ?.addQueryParameter("filter[flags][forPrivate]", "1")

        for ((name, value) in geo.serialize()) {
            internalMethod?.addQueryParameter(name, value)
        }

        val method = HttpUrl.parse(SB_ENDPOINT)?.newBuilder()
                ?.addQueryParameter("pipe", "branchesPipe")
                ?.addQueryParameter("url", internalMethod.toString())
                ?.build()

        val request = Request.Builder()
                .url(method)
                .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code " + response)
            val body = response.body()

            Log.d(TAG, body.toString())
        }
    }
}