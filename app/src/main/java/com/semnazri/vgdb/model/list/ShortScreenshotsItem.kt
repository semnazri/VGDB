package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class ShortScreenshotsItem(

	@SerializedName("image")
	val image: String? = "",

	@SerializedName("id")
	val id: Int? = 0
)