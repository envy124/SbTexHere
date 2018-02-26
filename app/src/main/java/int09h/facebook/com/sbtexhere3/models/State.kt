package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class State(

	@Json(name="siteStatus")
	val siteStatus: String? = null,

	@Json(name="display")
	val display: Boolean? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="shortName")
	val shortName: String? = null
)