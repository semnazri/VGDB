package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class GameListResponse(

	@SerializedName("next")
	val next: String? = "",

	@SerializedName("nofollow")
	val nofollow: Boolean? = false,

	@SerializedName("noindex")
	val noindex: Boolean? = false,

	@SerializedName("nofollow_collections")
	val nofollowCollections: List<String?>? = listOf(),

	@SerializedName("previous")
	val previous: String? = "",

	@SerializedName("count")
	val count: Int? = 0,

	@SerializedName("description")
	val description: String? = "",

	@SerializedName("seo_h1")
	val seoH1: String? = "",

	@SerializedName("filters")
	val filters: Filters? = null,

	@SerializedName("seo_title")
	val seoTitle: String? = "",

	@SerializedName("seo_description")
	val seoDescription: String? = "",

	@SerializedName("results")
	val results: List<ResultsItem> = listOf(),

	@SerializedName("seo_keywords")
	val seoKeywords: String? = ""
)