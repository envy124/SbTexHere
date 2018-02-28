package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class WorkTimeGroups(

	@Json(name="general")
	val general: List<GeneralItem?>? = null,

	@Json(name="natural")
	val natural: List<Any?>? = null,

	@Json(name="legal")
	val legal: List<Any?>? = null
)