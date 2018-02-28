package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class WorkTimeListItem(

	@Json(name="weekDayName")
	val weekDayName: String? = null,

	@Json(name="timeList")
	val timeList: List<String?>? = null,

	@Json(name="weekDayNo")
	val weekDayNo: Int? = null
)