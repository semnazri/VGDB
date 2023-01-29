package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class Filters(

	@SerializedName("years")
	val years: List<YearsItem?>? = listOf()
)