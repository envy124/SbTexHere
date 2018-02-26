package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class Coordinates(

	@Json(name="qidb")
	val qidb: Int? = null,

	@Json(name="latitude")
	val latitude: Double? = null,

	@Json(name="qid")
	val qid: Int? = null,

	@Json(name="longitude")
	val longitude: Double? = null
)