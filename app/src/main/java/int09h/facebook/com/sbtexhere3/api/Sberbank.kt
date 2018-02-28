package int09h.facebook.com.sbtexhere3.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import int09h.facebook.com.sbtexhere3.models.SbAtmResponse
import int09h.facebook.com.sbtexhere3.models.Triangle
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URLEncoder


/**
 * Created by int09h on 23/02/2018.
 */

const val SB_ENDPOINT = "https://sberbank.ru/portalserver/proxy/"
const val SB_INTERNAL_GET = "http://localhost/oib-rs/byBounds/entities"

class Sberbank(
        private val sbApi: String = SB_ENDPOINT,
        private val httpClient: OkHttpClient = OkHttpClient()
) {
    private val TAG = Sberbank::class.java.simpleName
    private val moshi = Moshi.Builder().build()
    private val atmList = Types.newParameterizedType(List::class.java, SbAtmResponse::class.java)!!
    private val getAtmsJsonAdapter = moshi.adapter<ArrayList<SbAtmResponse>>(atmList)

    fun fetchAtms(geo: Triangle, size: Int = 9, page: Int = 0): ArrayList<SbAtmResponse>? {
        val internalMethod = okhttp3.HttpUrl.parse(SB_INTERNAL_GET)?.newBuilder()!!

        for ((name, value) in geo.serialize()) {
            internalMethod.addQueryParameter(name, value)
        }

        internalMethod
                .addQueryParameter("size", size.toString())
                .addQueryParameter("page", page.toString())
                .addQueryParameter("filter[type][]", "itt")
                .addQueryParameter("filter[type][]", "atm")
                .addQueryParameter("filter[flags][forPrivate]", "1")

        val method = HttpUrl.parse(sbApi)?.newBuilder()!!
                .addQueryParameter("pipe", "branchesPipe")
                .addEncodedQueryParameter("url", URLEncoder.encode(internalMethod.build().toString(), "UTF-8"))
                .build()

        val request = Request.Builder()
                .url(method)
                .build()

        httpClient.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code " + response)
            return@fetchAtms getAtmsJsonAdapter.fromJson(response.body()?.source())
        }
    }
}