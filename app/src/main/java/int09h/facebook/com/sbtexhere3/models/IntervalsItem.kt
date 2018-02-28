package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class IntervalsItem(

	@Json(name="start")
	val start: String? = null,

	@Json(name="end")
	val end: String? = null
)