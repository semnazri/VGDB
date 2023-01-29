package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class Store(

	@SerializedName("games_count")
	val gamesCount: Int? = 0,

	@SerializedName("domain")
	val domain: String? = "",

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("image_background")
	val imageBackground: String? = "",

	@SerializedName("slug")
	val slug: String? = ""
)