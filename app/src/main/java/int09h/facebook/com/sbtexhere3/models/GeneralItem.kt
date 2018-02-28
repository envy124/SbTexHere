package int09h.facebook.com.sbtexhere3.models


import com.squareup.moshi.Json

data class GeneralItem(

	@Json(name="wdstart")
	val wdstart: Int? = null,

	@Json(name="intervals")
	val intervals: List<IntervalsItem?>? = null,

	@Json(name="wdend")
	val wdend: Int? = null
)