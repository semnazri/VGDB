package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class PlatformsItem(

	@SerializedName("requirements_ru")
	val requirementsRu: Any? = null,

	@SerializedName("requirements_en")
	val requirementsEn: Any? = null,

	@SerializedName("released_at")
	val releasedAt: String? = "",

	@SerializedName("platform")
	val platform: Platform? = null
)