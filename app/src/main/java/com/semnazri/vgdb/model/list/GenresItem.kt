package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class GenresItem(

	@SerializedName("games_count")
	val gamesCount: Int? = 0,

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("image_background")
	val imageBackground: String? = "",

	@SerializedName("slug")
	val slug: String? = ""
)