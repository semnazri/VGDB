package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class RequirementsRu(

	@field:SerializedName("minimum")
	val minimum: String? = null,

	@field:SerializedName("recommended")
	val recommended: String? = null
)