package com.semnazri.vgdb.model.details

import com.google.gson.annotations.SerializedName

data class PlatformsItem(

	@field:SerializedName("requirements")
	val requirements: Requirements? = null,

	@field:SerializedName("released_at")
	val releasedAt: String? = "",

	@field:SerializedName("platform")
	val platform: Platform? = null
)