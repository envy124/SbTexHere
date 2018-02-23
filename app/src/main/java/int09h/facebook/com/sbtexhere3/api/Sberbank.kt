package int09h.facebook.com.sbtexhere3.api

import int09h.facebook.com.sbtexhere3.models.Triangle

/**
 * Created by int09h on 23/02/2018.
 */

const val SB_HOST = "https://sberbank.ru/portalserver/proxy/"
const val SB_GET_ATMS = "http://localhost/oib-rs/byBounds/entities"

class Sberbank(private val host: String = SB_HOST) {

    fun getAtms(geo: Triangle, size: Int = 0, page: Int = 0) {

    }
}