package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class SbFilialResponse(

	@Json(name="code")
	val code: String? = null,

	@Json(name="postAddress")
	val postAddress: String? = null,

	@Json(name="dist")
	val dist: Double? = null,

	@Json(name="filialServicesEntity")
	val filialServicesEntity: FilialServicesEntity? = null,

	@Json(name="segmentMvs")
	val segmentMvs: Boolean? = null,

	@Json(name="tbCode")
	val tbCode: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="naturalPersonServices")
	val naturalPersonServices: List<String?>? = null,

	@Json(name="zona24")
	val zona24: Boolean? = null,

	@Json(name="phoneFl")
	val phoneFl: String? = null,

	@Json(name="transferNotOpen")
	val transferNotOpen: Boolean? = null,

	@Json(name="legalPerson")
	val legalPerson: Boolean? = null,

	@Json(name="childrenCorner")
	val childrenCorner: Boolean? = null,

	@Json(name="id")
	val id: Long? = null,

	@Json(name="naturalPerson")
	val naturalPerson: Boolean? = null,

	@Json(name="requisites")
	val requisites: Requisites? = null,

	@Json(name="lunchTimeList")
	val lunchTimeList: List<Any?>? = null,

	@Json(name="individualSafes")
	val individualSafes: Boolean? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="filialType")
	val filialType: String? = null,

	@Json(name="jtype")
	val jtype: String? = null,

	@Json(name="coordinates")
	val coordinates: Coordinates? = null,

	@Json(name="extWorkTime")
	val extWorkTime: Boolean? = null,

	@Json(name="legalPersonServices")
	val legalPersonServices: List<Any?>? = null,

	@Json(name="flInvvision")
	val flInvvision: Boolean? = null,

	@Json(name="workTimeList")
	val workTimeList: List<WorkTimeListItem?>? = null,

	@Json(name="mblt")
	val mblt: Boolean? = null,

	@Json(name="workTimeGroups")
	val workTimeGroups: WorkTimeGroups? = null,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="workOnWeeks")
	val workOnWeeks: Boolean? = null,

	@Json(name="name")
	val name: String? = null,

	@Json(name="metroStation")
	val metroStation: String? = null,

	@Json(name="hash")
	val hash: String? = null
)