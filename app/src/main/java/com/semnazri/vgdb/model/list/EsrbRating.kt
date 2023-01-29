package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class EsrbRating(

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("slug")
	val slug: String? = ""
)