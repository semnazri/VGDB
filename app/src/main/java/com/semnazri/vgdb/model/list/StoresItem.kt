package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class StoresItem(

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("store")
	val store: Store? = null
)