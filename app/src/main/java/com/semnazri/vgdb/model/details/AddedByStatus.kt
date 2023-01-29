package com.semnazri.vgdb.model.details

import com.google.gson.annotations.SerializedName

data class AddedByStatus(

	@SerializedName("owned")
	val owned: Int? = 0,

	@SerializedName("beaten")
	val beaten: Int? = 0,

	@SerializedName("dropped")
	val dropped: Int? = 0,

	@SerializedName("yet")
	val yet: Int? = 0,

	@SerializedName("playing")
	val playing: Int? = 0,

	@SerializedName("toplay")
	val toplay: Int? = 0
)