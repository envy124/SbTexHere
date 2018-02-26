package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class CasNsiAddressEntity(

	@Json(name="zipCode")
	val zipCode: String? = null,

	@Json(name="townName")
	val townName: String? = null,

	@Json(name="address3")
	val address3: String? = null,

	@Json(name="accessName")
	val accessName: String? = null,

	@Json(name="address2")
	val address2: String? = null,

	@Json(name="address1")
	val address1: String? = null,

	@Json(name="addressCyr")
	val addressCyr: String? = null,

	@Json(name="instPlaceCatId")
	val instPlaceCatId: String? = null,

	@Json(name="conditionName")
	val conditionName: String? = null,

	@Json(name="townType")
	val townType: String? = null,

	@Json(name="conditionCode")
	val conditionCode: String? = null,

	@Json(name="areaName")
	val areaName: String? = null,

	@Json(name="areaType")
	val areaType: String? = null,

	@Json(name="statusName")
	val statusName: String? = null,

	@Json(name="address4")
	val address4: String? = null,

	@Json(name="statusCode")
	val statusCode: String? = null
)