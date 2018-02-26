package int09h.facebook.com.sbtexhere3.models

import com.squareup.moshi.Json

data class SbAtmResponse(

	@Json(name="lmd")
	val lmd: Long? = null,

	@Json(name="code")
	val code: String? = null,

	@Json(name="postAddress")
	val postAddress: String? = null,

	@Json(name="conditionName")
	val conditionName: String? = null,

	@Json(name="storage")
	val storage: String? = null,

	@Json(name="type")
	val type: String? = null,

	@Json(name="terminalModelName")
	val terminalModelName: String? = null,

	@Json(name="sbCardId")
	val sbCardId: Boolean? = null,

	@Json(name="stateName")
	val stateName: String? = null,

	@Json(name="cbCode")
	val cbCode: String? = null,

	@Json(name="statusName")
	val statusName: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="state")
	val state: State? = null,

	@Json(name="requisites")
	val requisites: Requisites? = null,

	@Json(name="address")
	val address: String? = null,

	@Json(name="filial")
	val filial: String? = null,

	@Json(name="cashin")
	val cashin: Boolean? = null,

	@Json(name="accessName")
	val accessName: String? = null,

	@Json(name="addOn")
	val addOn: String? = null,

	@Json(name="idCode")
	val idCode: String? = null,

	@Json(name="stateId")
	val stateId: Int? = null,

	@Json(name="instPlaceCatId")
	val instPlaceCatId: String? = null,

	@Json(name="jtype")
	val jtype: String? = null,

	@Json(name="coordinates")
	val coordinates: Coordinates? = null,

	@Json(name="instPlace")
	val instPlace: String? = null,

	@Json(name="cachid")
	val cachid: Boolean? = null,

	@Json(name="nameShort")
	val nameShort: String? = null,

	@Json(name="moto")
	val moto: Boolean? = null,

	@Json(name="currExchange")
	val currExchange: Boolean? = null,

	@Json(name="conditionCode")
	val conditionCode: String? = null,

	@Json(name="srvPayId")
	val srvPayId: Boolean? = null,

	@Json(name="phone")
	val phone: String? = null,

	@Json(name="casNsiAddressEntity")
	val casNsiAddressEntity: CasNsiAddressEntity? = null,

	@Json(name="worktime")
	val worktime: String? = null,

	@Json(name="metroStation")
	val metroStation: String? = null,

	@Json(name="hash")
	val hash: String? = null,

	@Json(name="statusCode")
	val statusCode: String? = null
)