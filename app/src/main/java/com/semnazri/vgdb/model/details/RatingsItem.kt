package com.semnazri.vgdb.model.details

import com.google.gson.annotations.SerializedName

data class RatingsItem(

	@SerializedName("count")
	val count: Int? = 0,

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("title")
	val title: String? = "",

	@SerializedName("percent")
	val percent: Double? = 0.0
)