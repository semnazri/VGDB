package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class YearsItem(

    @SerializedName("filter")
	val filter: String? = "",

    @SerializedName("nofollow")
	val nofollow: Boolean? = false,

    @SerializedName("decade")
	val decade: Int? = 0,

    @SerializedName("count")
	val count: Int? = 0,

    @SerializedName("from")
	val from: Int? = 0,

    @SerializedName("to")
	val to: Int? = 0,

    @SerializedName("years")
	val years: List<YearsItem?>? = listOf(),

    @SerializedName("year")
	val year: Int? = 0
)