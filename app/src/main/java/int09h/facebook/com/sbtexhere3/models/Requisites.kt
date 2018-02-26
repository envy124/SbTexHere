package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class Requisites(

	@Json(name="inn")
	val inn: String? = null,

	@Json(name="kpp")
	val kpp: String? = null
)