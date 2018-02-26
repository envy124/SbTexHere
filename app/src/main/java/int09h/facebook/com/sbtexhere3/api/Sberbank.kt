package int09h.facebook.com.sbtexhere3.api

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import int09h.facebook.com.sbtexhere3.models.SbAtmResponse
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

class Sberbank(
        private val sbApi: String = SB_ENDPOINT,
        private val httpClient: OkHttpClient = OkHttpClient()
) {
    private val TAG = Sberbank::class.java.simpleName
    private val moshi = Moshi.Builder().build()
    private val atmList = Types.newParameterizedType(List::class.java, SbAtmResponse::class.java)!!
    private val getAtmsJsonAdapter = moshi.adapter<ArrayList<SbAtmResponse>>(atmList)

    fun getAtms(geo: Triangle, size: Int = 9, page: Int = 0) {
        val internalMethod = okhttp3.HttpUrl.parse(SB_GET_ATMS)?.newBuilder()!!
                .addQueryParameter("size", size.toString())
                .addQueryParameter("page", page.toString())
                .addQueryParameter("filter[type][]", "itt")
                .addQueryParameter("filter[type][]", "atm")
                .addQueryParameter("filter[flags][forPrivate]", "1")

        for ((name, value) in geo.serialize()) {
            internalMethod.addQueryParameter(name, value)
        }
//
//        val internalMethodUrl = internalMethod.toString() + "&filter[type][]=itt" +
//                "&filter[type][]=atm&filter[flags][forPrivate]=1"

        val method = HttpUrl.parse(sbApi)?.newBuilder()!!
                .addQueryParameter("pipe", "branchesPipe")
                .addQueryParameter("url", internalMethod.build().url().toString())
                .build()

        val request = Request.Builder()
                .url(method)
                .build()

//        httpClient.newCall(request).execute().use { response ->
//            if (!response.isSuccessful) throw IOException("Unexpected code " + response)
//            val bodyStr = response.body()?.string()
//            val data = getAtmsJsonAdapter.fromJson(bodyStr)
////            val data = getAtmsJsonAdapter.fromJson(response.body()?.source())
//
//            Log.d(TAG, data!![0].address)
//        }
    }
}