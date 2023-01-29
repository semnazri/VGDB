package com.semnazri.vgdb.model.details

import com.google.gson.annotations.SerializedName

data class GameDetailResponse(

	@SerializedName("added")
	val added: Int? = 0,

	@SerializedName("developers")
	val developers: List<DevelopersItem?>? = listOf(),

	@SerializedName("name_original")
	val nameOriginal: String? = "",

	@SerializedName("rating")
	val rating: Double? = 0.0,

	@SerializedName("game_series_count")
	val gameSeriesCount: Int? = 0,

	@SerializedName("playtime")
	val playtime: Int? = 0,

	@SerializedName("platforms")
	val platforms: List<PlatformsItem?>? = listOf(),

	@SerializedName("rating_top")
	val ratingTop: Int? = 0,

	@SerializedName("reviews_text_count")
	val reviewsTextCount: Int? = 0,

	@SerializedName("publishers")
	val publishers: List<PublishersItem?>? = listOf(),

	@SerializedName("achievements_count")
	val achievementsCount: Int? = 0,

	@SerializedName("id")
	val id: Int? = 0,

	@SerializedName("parent_platforms")
	val parentPlatforms: List<ParentPlatformsItem?>? = listOf(),

	@SerializedName("reddit_name")
	val redditName: String? = "",

	@SerializedName("ratings_count")
	val ratingsCount: Int? = 0,

	@SerializedName("slug")
	val slug: String? = "",

	@SerializedName("released")
	val released: String? = "",

	@SerializedName("youtube_count")
	val youtubeCount: Int? = 0,

	@SerializedName("movies_count")
	val moviesCount: Int? = 0,

	@SerializedName("description_raw")
	val descriptionRaw: String? = "",

	@SerializedName("tags")
	val tags: List<TagsItem?>? = listOf(),

	@SerializedName("background_image")
	val backgroundImage: String? = "",

	@SerializedName("tba")
	val tba: Boolean? = false,

	@SerializedName("dominant_color")
	val dominantColor: String? = "",

	@SerializedName("name")
	val name: String? = "",

	@SerializedName("reddit_description")
	val redditDescription: String? = "",

	@SerializedName("reddit_logo")
	val redditLogo: String? = "",

	@SerializedName("updated")
	val updated: String? = "",

	@SerializedName("reviews_count")
	val reviewsCount: Int? = 0,

	@SerializedName("metacritic")
	val metacritic: Any? = null,

	@SerializedName("description")
	val description: String? = "",

	@SerializedName("metacritic_url")
	val metacriticUrl: String? = "",

	@SerializedName("alternative_names")
	val alternativeNames: List<Any?>? = listOf(),

	@SerializedName("parents_count")
	val parentsCount: Int? = 0,

	@SerializedName("user_game")
	val userGame: Any? = null,

	@SerializedName("metacritic_platforms")
	val metacriticPlatforms: List<Any?>? = listOf(),

	@SerializedName("creators_count")
	val creatorsCount: Int? = 0,

	@SerializedName("ratings")
	val ratings: List<RatingsItem?>? = listOf(),

	@SerializedName("genres")
	val genres: List<GenresItem?>? = listOf(),

	@SerializedName("saturated_color")
	val saturatedColor: String? = "",

	@SerializedName("added_by_status")
	val addedByStatus: AddedByStatus? = null,

	@SerializedName("reddit_url")
	val redditUrl: String? = "",

	@SerializedName("reddit_count")
	val redditCount: Int? = 0,

	@SerializedName("parent_achievements_count")
	val parentAchievementsCount: Int? = 0,

	@SerializedName("website")
	val website: String? = "",

	@SerializedName("suggestions_count")
	val suggestionsCount: Int? = 0,

	@SerializedName("stores")
	val stores: List<Any?>? = listOf(),

	@SerializedName("additions_count")
	val additionsCount: Int? = 0,

	@SerializedName("twitch_count")
	val twitchCount: Int? = 0,

	@SerializedName("background_image_additional")
	val backgroundImageAdditional: String? = "",

	@SerializedName("esrb_rating")
	val esrbRating: Any? = null,

	@SerializedName("screenshots_count")
	val screenshotsCount: Int? = 0,

	@SerializedName("reactions")
	val reactions: Reactions? = null,

	@SerializedName("clip")
	val clip: Any? = null
)