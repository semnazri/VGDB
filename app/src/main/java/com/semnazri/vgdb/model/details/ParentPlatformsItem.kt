package com.semnazri.vgdb.model.details

import com.google.gson.annotations.SerializedName

data class ParentPlatformsItem(

	@field:SerializedName("platform")
	val platform: Platform? = null
)