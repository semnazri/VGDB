package com.semnazri.vgdb.model.list

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@SerializedName("added")
	val added: Int? = 0,

	@SerializedName("rating")
	val rating: Double? = 0.0,

	@SerializedName("metacritic")
	val metacritic: Int? = 0,

	@SerializedName("playtime")
	val playtime: Int? = 0,

	@SerializedName("short_screenshots")
	val shortScreenshots: List<ShortScreenshotsItem?>? = listOf(),

	@SerializedName("platforms")
	val platforms: List<PlatformsItem?>? = listOf(),

	@SerializedName("user_game")
	val userGame: Any? = null,

	@SerializedName("rating_top")
	val ratingTop: Int? = 0,

	@SerializedName("reviews_text_count")
	val reviewsTextCount: Int? = 0,

	@SerializedName("ratings")
	val ratings: List<RatingsItem?>? = listOf(),

	@SerializedName("genres")
	val genres: List<GenresItem?>? = listOf(),

	@SerializedName("saturated_color")
	val saturatedColor: String? = "",

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("added_by_status")
	val addedByStatus: AddedByStatus? = null,

	@SerializedName("parent_platforms")
	val parentPlatforms: List<ParentPlatformsItem?>? = listOf(),

	@SerializedName("ratings_count")
	val ratingsCount: Int? = 0,

	@SerializedName("slug")
	val slug: String? = "",

	@SerializedName("released")
	val released: String? = "",

	@SerializedName("suggestions_count")
	val suggestionsCount: Int? = 0,

	@SerializedName("stores")
	val stores: List<StoresItem?>? = null,

	@SerializedName("tags")
	val tags: List<TagsItem?>? = null,

	@SerializedName("background_image")
	val backgroundImage: String? = "",

	@SerializedName("tba")
	val tba: Boolean? = false,

	@SerializedName("dominant_color")
	val dominantColor: String? = "",

	@SerializedName("esrb_rating")
	val esrbRating: EsrbRating? = null,

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("updated")
	val updated: String? = "",

	@SerializedName("clip")
	val clip: Any? = null,

	@SerializedName("reviews_count")
	val reviewsCount: Int? = 0
)